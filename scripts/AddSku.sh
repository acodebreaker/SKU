#!/usr/bin/env bash

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
  "description":"this product is a book",
  "skuCode":"ABCD123",
  "product" :
  {
  	"productId":"A And D",
  	"productCode" :"DAN321",
  	"productDescription":"This book is angels and demons",
  	"":200.0
  }
}' \
  http://localhost:8080/sku