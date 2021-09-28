variable "access_key" {
    type = string
    sensitive = true
}
variable "secret_key" {
    type = string
    sensitive = true
}
variable "db_password" {
    type = string
    sensitive = true
}
variable "key_name" {
    value = "Terraform-Resource"
}
variable "db_name" {
    value = "production_db"
}