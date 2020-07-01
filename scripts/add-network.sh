#!/usr/bin/env bash

HOST=localhost
PORT=8087
SITE_ID=6 # Greece default

SITES_LINK=$(curl --request POST \
  --url http://${HOST}:${PORT}/networks \
  --header 'content-type: application/json' \
  --data '{
  "vim_network_name" : "external",
  "floating_ip" : false,
  "mgmt_net" : true,
  "external_net" : true,
  "cidr" : "10.20.20.0/24",
}' | jq -r ._links.site.href);

curl --request PUT \
    --url "${SITES_LINK}" \
    --header 'content-type: text/uri-list' \
    --data http://${HOST}:${PORT}/sites/"${SITE_ID}";
