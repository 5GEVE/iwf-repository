#!/usr/bin/env bash

HOST=localhost
PORT=8087
SITE_ID=1 # Italy default

SITES_LINK=$(curl --request POST \
  --url http://${HOST}:${PORT}/dataShippers \
  --header 'content-type: application/json' \
  --data '{
	"dataShipperId": "5bbbe24f-0d75-4044-ad34-2370cf4816ea",
	"ipAddress": "192.168.17.3",
	"username": "root",
	"password": "password",
	"configStart": "START",
	"configStop": "STOP",
	"configReset":"RESET",
	"method": "SCRIPT",
	"deviceId": "5g-antenna-asdf",
	"metricType": "CPU_CONSUMPTION"
}' | jq -r ._links.site.href)

curl --request PUT \
  --url "${SITES_LINK}" \
  --header 'content-type: text/uri-list' \
  --data http://${HOST}:${PORT}/sites/"${SITE_ID}"
