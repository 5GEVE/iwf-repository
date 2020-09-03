-- eve sites
INSERT INTO site (name, location, kafka_ip_address) VALUES ('ITALY_TURIN', 'Turin, Italy', '10.50.80.18')
ON CONFLICT (name) DO NOTHING;
INSERT INTO site (name, location, kafka_ip_address) VALUES ('SPAIN_5TONIC', 'Madrid, Spain', '10.3.5.100')
ON CONFLICT (name) DO NOTHING;
INSERT INTO site (name, location, kafka_ip_address) VALUES ('FRANCE_PARIS', 'Paris, France', '10.0.0.3')
ON CONFLICT (name) DO NOTHING;
INSERT INTO site (name, location, kafka_ip_address) VALUES ('FRANCE_NICE', 'Nice, France', '10.0.0.4')
ON CONFLICT (name) DO NOTHING;
INSERT INTO site (name, location, kafka_ip_address) VALUES ('FRANCE_RENNES', 'Rennes, France', '10.0.0.5')
ON CONFLICT (name) DO NOTHING;
INSERT INTO site (name, location, kafka_ip_address) VALUES ('GREECE_ATHENS', 'Athens, Greece', '10.0.0.6')
ON CONFLICT (name) DO NOTHING;

-- nfvos
INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('ITALY_TURIN', 'OSM', 'R6', 'ENABLED', (SELECT id FROM site WHERE name='ITALY_TURIN'))
ON CONFLICT (name) DO NOTHING;
INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('onap-nice', 'ONAP', '4.0', 'ENABLED', (SELECT id FROM site WHERE name='FRANCE_NICE'))
ON CONFLICT (name) DO NOTHING;
INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('onap-paris', 'ONAP', '4.0', 'ENABLED', (SELECT id FROM site WHERE name='FRANCE_PARIS'))
ON CONFLICT (name) DO NOTHING;
INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('onap-rennes', 'ONAP', '4.0', 'ENABLED', (SELECT id FROM site WHERE name='FRANCE_RENNES'))
ON CONFLICT (name) DO NOTHING;
INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('osm-madrid', 'OSM', 'R6', 'ENABLED', (SELECT id FROM site WHERE name='SPAIN_5TONIC'))
ON CONFLICT (name) DO NOTHING;
INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('GREECE_ATHENS', 'OSM', 'R6', 'ENABLED', (SELECT id FROM site WHERE name='GREECE_ATHENS'))
ON CONFLICT (name) DO NOTHING;

-- ranos
INSERT INTO ran_orchestrator (name, type, site_id)
VALUES ('italian_ever', 'EVER', (SELECT id FROM site WHERE name='ITALY_TURIN'))
ON CONFLICT (name) DO NOTHING;

-- vim accounts. Keeping this as a reference. Should be added dynamically.
-- INSERT INTO vim_account (name, tenant, type, uri, vim_account_nfvo_id)
-- VALUES ('Cloud VIM Openstack', '5geve-cloud', 'openstack',
--         'http://10.20.20.1:5000/v3', '77c531ef-ff08-42a3-aeb9-3b8eae19a32f');
-- INSERT INTO vim_account (name, tenant, type, uri, vim_account_nfvo_id)
-- VALUES ('Edge VIM Openstack', '5geve-edge', 'openstack',
--         'http://10.20.20.1:5000/v3', 'e59a8dfd-dd21-42cc-98f7-a68c83cfbdbd');

-- vim_nfvo. Keeping this as a reference. Should be added dynamically.
-- INSERT INTO vim_nfvo (vim_id, nfvo_id) VALUES
-- ((SELECT id FROM vim_account WHERE tenant='5geve-cloud'),
--  (SELECT id FROM nfv_orchestrator WHERE name='osm-turin-cnit'));
-- INSERT INTO vim_nfvo (vim_id, nfvo_id) VALUES
-- ((SELECT id FROM vim_account WHERE tenant='5geve-edge'),
--  (SELECT id FROM nfv_orchestrator WHERE name='osm-turin-cnit'));

-- network
INSERT INTO network (vim_network_name, floating_ip, mgmt_net, external_net, site_id, cidr)
VALUES ('floating', true, false, true, (SELECT id FROM site WHERE name='ITALY_TURIN'), '10.50.160.0/24')
ON CONFLICT (vim_network_name, site_id) DO NOTHING;
INSERT INTO network (vim_network_name, floating_ip, mgmt_net, external_net, site_id, cidr)
VALUES ('vm_mgmt', false, true, false, (SELECT id FROM site WHERE name='ITALY_TURIN'), '10.50.80.0/24')
ON CONFLICT (vim_network_name, site_id) DO NOTHING;
INSERT INTO network (vim_network_name, floating_ip, mgmt_net, external_net, site_id)
VALUES ('provider', false, true, false, (SELECT id FROM site WHERE name='SPAIN_5TONIC'))
ON CONFLICT (vim_network_name, site_id) DO NOTHING;
INSERT INTO network (vim_network_name, floating_ip, mgmt_net, external_net, site_id)
VALUES ('provider2', false, false, true, (SELECT id FROM site WHERE name='SPAIN_5TONIC'))
ON CONFLICT (vim_network_name, site_id) DO NOTHING;

