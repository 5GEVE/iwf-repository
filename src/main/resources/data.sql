-- eve sites
INSERT INTO site (id, name, location) VALUES (nextval('hibernate_sequence'), 'ITALY_TURIN', 'Turin, Italy');
INSERT INTO site (id, name, location) VALUES (nextval('hibernate_sequence'), 'SPAIN_5TONIC', 'Madrid, Spain');
INSERT INTO site (id, name, location) VALUES (nextval('hibernate_sequence'), 'FRANCE_PARIS', 'Paris, France');
INSERT INTO site (id, name, location) VALUES (nextval('hibernate_sequence'), 'FRANCE_NICE', 'Nice, France');
INSERT INTO site (id, name, location) VALUES (nextval('hibernate_sequence'), 'FRANCE_RENNES', 'Rennes, France');
INSERT INTO site (id, name, location) VALUES (nextval('hibernate_sequence'), 'GREECE_ATHENS', 'Athens, Greece');

-- nfvos
INSERT INTO nfv_orchestrator (id, name, type, version, operational_state, site_id)
VALUES (nextval('hibernate_sequence'), 'Turin OSM @ Polito', 'OSM', 'R6', 'ENABLED',
(SELECT id FROM site WHERE name='ITALY_TURIN'));

-- vim
INSERT INTO vim_account (id, name, tenant, type, uri, vim_account_id)
VALUES (nextval('hibernate_sequence'), 'Cloud VIM Openstack', '5geve-cloud', 'openstack',
        'http://10.20.20.1:5000/v3', '77c531ef-ff08-42a3-aeb9-3b8eae19a32f');
INSERT INTO vim_account (id, name, tenant, type, uri, vim_account_id)
VALUES (nextval('hibernate_sequence'), 'Edge VIM Openstack', '5geve-edge', 'openstack',
        'http://10.20.20.1:5000/v3', 'e59a8dfd-dd21-42cc-98f7-a68c83cfbdbd');

-- vim_nfvo
INSERT INTO vim_nfvo (vim_id, nfvo_id) VALUES
((SELECT id FROM vim_account WHERE tenant='5geve-cloud'),
 (SELECT id FROM nfv_orchestrator WHERE name='Turin OSM @ Polito'));
INSERT INTO vim_nfvo (vim_id, nfvo_id) VALUES
((SELECT id FROM vim_account WHERE tenant='5geve-edge'),
 (SELECT id FROM nfv_orchestrator WHERE name='Turin OSM @ Polito'));

-- notification_type initialization
INSERT INTO notification_type (id, type) VALUES (nextval('hibernate_sequence'), 'NsLcmOperationOccurenceNotification');
INSERT INTO notification_type (id, type) VALUES (nextval('hibernate_sequence'), 'NsIdentifierCreationNotification');
INSERT INTO notification_type (id, type) VALUES (nextval('hibernate_sequence'), 'NsIdentifierDeletionNotification');
