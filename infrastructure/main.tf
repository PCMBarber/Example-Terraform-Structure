provider "aws" {
    region = "eu-west-2"
    access_key = var.access_key
    secret_key = var.secret_key
}

module "vpc" {
    source          = "./vpc"
}
module "subnets" {
    source          = "./subnets"
    
    vpc_id          = module.vpc.vpc_id
    route_id        = module.vpc.route_id
    sec_group_id    = module.vpc.sec_group_id
    internet_gate   = module.vpc.internet_gate
}

module "ec2" {
    source          = "./ec2"
    net_id_prod     = module.subnets.net_id_prod
    net_id_test     = module.subnets.net_id_test
    net_id_jenk     = module.subnets.net_id_jenk
    ami_id          = "ami-096cb92bb3580c759"
    instance_type   = "t2.medium"
    av_zone         = "eu-west-2a"
    key_name        = var.key_name
    sec_group_id    = module.vpc.db_sec_group_id
    subnet_group_name = module.subnets.db_subnet_group
    db_password     = var.db_password
    db_name         = var.db_name
}

resource "local_file" "tf_ansible_inventory" {
  content = <<-DOC
    [jenkins]

    ${module.ec2.jenk_ip} ansible_ssh_private_key_file=~/.ssh/${var.key_name}.pem

    [swarmmaster]

    ${module.ec2.prod_ip} ansible_ssh_private_key_file=~/.ssh/${var.key_name}.pem

    [swarmtest]

    ${module.ec2.test_ip} ansible_ssh_private_key_file=~/.ssh/${var.key_name}.pem

    [swarmmaster:vars]

    ansible_user=ubuntu

    ansible_ssh_common_args='-o StrictHostKeyChecking=no'

    db_ip=${module.subnets.NAT_publicIP}

    [swarmtest:vars]

    ansible_user=ubuntu

    ansible_ssh_common_args='-o StrictHostKeyChecking=no'

    db_ip=${module.subnets.NAT_publicIP}

    [jenkins:vars]

    ansible_user=ubuntu

    ansible_ssh_common_args='-o StrictHostKeyChecking=no'
    DOC
  filename = "./inventory"
}

resource "local_file" "tf_Jenkinsfile" {
  content = <<-DOC
    pipeline{
                agent any
                stages{
                        stage('--Build Back End Jar--'){
                                steps{
                                        sh '''
                                                cd /var/lib/jenkins/workspace/$JOB_BASE_NAME/backend $$ mvn clean install
                                        '''
                                }
                        }
                        stage('--Front End Deploy--'){
                                steps{
                                        sh '''
                                                image="${module.ec2.jenk_ip}:5000/frontend:build-$BUILD_NUMBER"
                                                docker build -t $image /var/lib/jenkins/workspace/$JOB_BASE_NAME/frontend
                                                docker push $image
                                                ssh ${module.ec2.prod_ip} -oStrictHostKeyChecking=no  << EOF
                                                docker service update --image $image project_frontend
                                        '''
                                }
                        }  
                        stage('--Back End Deploy--'){
                                steps{
                                        sh '''
                                                image="${module.ec2.jenk_ip}:5000/rand1:build-$BUILD_NUMBER"
                                                docker build -t $image /var/lib/jenkins/workspace/$JOB_BASE_NAME/backend
                                                docker push $image
                                                ssh ${module.ec2.prod_ip} -oStrictHostKeyChecking=no  << EOF
                                                docker service update --image $image project_backend
                                        '''
                                }
                        }
                        stage('--Clean up--'){
                                steps{
                                        sh '''
                                                ssh ${module.ec2.prod_ip} -oStrictHostKeyChecking=no  << EOF
                                                docker system prune
                                        '''
                                }
                        }
                }
        }
    DOC
  filename = "../Jenkinsfile"
}

resource "local_file" "tf_DockerCompose" {
  content = <<-DOC
version: '3.7'
services:
    nginx:
      image: nginx:latest
      ports:
        - target: 80
          published: 80
          protocol: tcp
      volumes:
        - type: bind
          source: ./nginx/nginx.conf
          target: /etc/nginx/nginx.conf
      depends_on:
        - frontend

    frontend:
      image: jenkins:5000/frontend:build-0
      build: ./frontend
      ports:
        - target: 8080
          published:8080
    
    backend:
      image: jenkins:5000/backend:build-0
      build: ./backend
      ports:
        - target: 5001
          published: 5001
      environment:
        - MYSQL_USER=root
        - MYSQL_PWD=$${DB_PWD}
        - MYSQL_IP=${module.ec2.db_address}
        - MYSQL_DB=${var.db_name}
        - MYSQL_SK=sgjbsloiyblvbda
    DOC
  filename = "../docker-compose.yaml"
}
resource "local_file" "tf_InsecureRegistry" {
  content = <<-DOC

{
        "insecure-registries":["${module.ec2.jenk_ip}:5000"]
}
    DOC
  filename = "./daemon.json"
}
