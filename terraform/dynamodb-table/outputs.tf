output "table_name" {
  value = "${var.name}"
}

output "table_arn" {
  value = "${aws_dynamodb_table.table.arn}"
}

output "encryption_enabled" {
  value = "${aws_dynamodb_table.table.server_side_encryption}"
}