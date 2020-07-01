#!/usr/bin/env bash

HOST=localhost
PORT=8087
SITE_ID=6 # Greece default

SITES_LINK=$(curl --request POST \
  --url http://${HOST}:${PORT}/networks \
  --header 'content-type: application/json' \
  --data '{
	"vim_network_name": "external_gre",
	"management": true,
	"floating_ip": true,
	"external_net": false,
	"cidr": "192.168.20.0/24"
}' | jq -r ._links.site.href);

curl --request PUT \
    --url "${SITES_LINK}" \
    --header 'content-type: text/uri-list' \
    --data http://${HOST}:${PORT}/sites/"${SITE_ID}";
