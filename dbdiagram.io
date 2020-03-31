// Paste into https://dbdiagram.io/

Table NFV_ORCHESTRATOR {
  id int [pk]
  name varchar [not null]
  type varchar [not null]
  uri varchar
  created_at datetime
  updated_at datetime
  site_id int [ref: > SITE.id]
}

Table NFVO_CREDENTIALS {
  nfvo_id int [ref: - NFV_ORCHESTRATOR.id, pk]
  host varchar [not null]
  project varchar [not null]
  user varchar [not null]
  password varchar [not null]
}

table VIM {
  vim_id varchar [pk]
  type varchar [not null]
  url varchar
  nfvo_id int [ref: > NFV_ORCHESTRATOR.id]
}

table RAN_ORCHESTRATOR {
  id int [pk]
  name varchar
  type varchar
  site_id int [ref: > SITE.id]
}

table SITE {
  id int [pk]
  name varchar
}

table LccnSubscription {
  id int [pk]
  callbackUri varchar [not null]
  nsInstanceId varchar [not null]
  nvfo_id int [ref: > NFV_ORCHESTRATOR.id]
}
