#!/usr/bin/env bash

curl --header "Content-Type: application/json" \
  --request PUT \
  --data '{
  "description":"this product is a book",
  "skuCode":"ABCD123",
  "product" :
  {
  	"productId":"A Ankit Rawat",
  	"productCode" :"DAN321",
  	"productDescription":"This book is angels and demons",
  	"":200.0
  }
}' \
  http://localhost:8080/sku