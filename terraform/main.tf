provider "aws" {
  access_key = "${var.access_key}"
  secret_key = "${var.secret_key}"
  region = "${var.region}"
}

module "dynamodb-table" {
  source = "./dynamodb-table"
  name = "arv-hotels"
  hash_key = "id"
}