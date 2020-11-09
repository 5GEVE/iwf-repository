-- We initialize here only static stuff
-- eve sites
INSERT INTO site (name, location) VALUES ('ITALY_TURIN', 'Turin, Italy')
ON CONFLICT (name) DO NOTHING;

INSERT INTO site (name, location) VALUES ('SPAIN_5TONIC', 'Madrid, Spain')
ON CONFLICT (name) DO NOTHING;

INSERT INTO site (name, location) VALUES ('FRANCE_CHATILLON', 'Chatillon, France')
ON CONFLICT (name) DO NOTHING;

INSERT INTO site (name, location) VALUES ('FRANCE_SOPHIA_ANTIPOLIS', 'Sophia Antipolis, France')
ON CONFLICT (name) DO NOTHING;

INSERT INTO site (name, location) VALUES ('FRANCE_RENNES', 'Rennes, France')
ON CONFLICT (name) DO NOTHING;

INSERT INTO site (name, location) VALUES ('FRANCE_SACLAY', 'Saclay, France')
ON CONFLICT (name) DO NOTHING;

INSERT INTO site (name, location) VALUES ('GREECE_ATHENS', 'Athens, Greece')
ON CONFLICT (name) DO NOTHING;

-- nfvos
INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('ITALY_TURIN', 'OSM', 'R6', 'ENABLED', (SELECT id FROM site WHERE name='ITALY_TURIN'))
ON CONFLICT (name) DO NOTHING;

INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('SPAIN_5TONIC', 'OSM', 'R6', 'ENABLED', (SELECT id FROM site WHERE name='SPAIN_5TONIC'))
ON CONFLICT (name) DO NOTHING;

INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('FRANCE_CHATILLON', 'ONAP', '4.0', 'ENABLED', (SELECT id FROM site WHERE name='FRANCE_CHATILLON'))
ON CONFLICT (name) DO NOTHING;

INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('FRANCE_SOPHIA_ANTIPOLIS', 'ONAP', '4.0', 'ENABLED', (SELECT id FROM site WHERE name='FRANCE_SOPHIA_ANTIPOLIS'))
ON CONFLICT (name) DO NOTHING;

INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('FRANCE_RENNES', 'ONAP', '4.0', 'ENABLED', (SELECT id FROM site WHERE name='FRANCE_RENNES'))
ON CONFLICT (name) DO NOTHING;

INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('FRANCE_SACLAY', 'ONAP', '4.0', 'ENABLED', (SELECT id FROM site WHERE name='FRANCE_SACLAY'))
ON CONFLICT (name) DO NOTHING;

INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('GREECE_ATHENS', 'OSM', 'R6', 'ENABLED', (SELECT id FROM site WHERE name='GREECE_ATHENS'))
ON CONFLICT (name) DO NOTHING;

-- ranos
INSERT INTO ran_orchestrator (name, type, site_id)
VALUES ('ITALY_EVER', 'EVER', (SELECT id FROM site WHERE name='ITALY_TURIN'))
ON CONFLICT (name) DO NOTHING;
