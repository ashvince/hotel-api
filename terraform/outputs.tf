output "hotel_table_name" {
  value = "${module.dynamodb-table.table_name}"
}

output "hotel_table_arn" {
  value = "${module.dynamodb-table.table_arn}"
}