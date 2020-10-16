-- We initialize here only static stuff
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
VALUES ('FRANCE_NICE', 'ONAP', '4.0', 'ENABLED', (SELECT id FROM site WHERE name='FRANCE_NICE'))
ON CONFLICT (name) DO NOTHING;
INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('FRANCE_PARIS', 'ONAP', '4.0', 'ENABLED', (SELECT id FROM site WHERE name='FRANCE_PARIS'))
ON CONFLICT (name) DO NOTHING;
INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('FRANCE_RENNES', 'ONAP', '4.0', 'ENABLED', (SELECT id FROM site WHERE name='FRANCE_RENNES'))
ON CONFLICT (name) DO NOTHING;
INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('SPAIN_5TONIC', 'OSM', 'R6', 'ENABLED', (SELECT id FROM site WHERE name='SPAIN_5TONIC'))
ON CONFLICT (name) DO NOTHING;
INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('GREECE_ATHENS', 'OSM', 'R6', 'ENABLED', (SELECT id FROM site WHERE name='GREECE_ATHENS'))
ON CONFLICT (name) DO NOTHING;

-- ranos
INSERT INTO ran_orchestrator (name, type, site_id)
VALUES ('italian_ever', 'EVER', (SELECT id FROM site WHERE name='ITALY_TURIN'))
ON CONFLICT (name) DO NOTHING;
