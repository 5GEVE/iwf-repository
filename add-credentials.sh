#!/usr/bin/env bash

HOST=localhost
PORT=8087
# To get NFVO ids do a GET on http://${HOST}:8087/nfvos/
NFVO_ID=1

curl --request PATCH \
  --url http://${HOST}:${PORT}/nfvos/${NFVO_ID} \
  --header 'content-type: application/json' \
  --data '{
	"credentials": {
		"host": "10.0.0.1",
		"port": 9999,
		"username": "admin",
		"password": "admin",
		"project": "admin"
	}
}'