#!/bin/bash
terraform apply -auto-approve
git add .
git commit -m "Deploying"
git push
ansible-playbook -i inventory Playbook.yaml