-- eve sites
INSERT INTO site (name, location) VALUES ('ITALY_TURIN', 'Turin, Italy');
INSERT INTO site (name, location) VALUES ('SPAIN_5TONIC', 'Madrid, Spain');
INSERT INTO site (name, location) VALUES ('FRANCE_PARIS', 'Paris, France');
INSERT INTO site (name, location) VALUES ('FRANCE_NICE', 'Nice, France');
INSERT INTO site (name, location) VALUES ('FRANCE_RENNES', 'Rennes, France');
INSERT INTO site (name, location) VALUES ('GREECE_ATHENS', 'Athens, Greece');

-- nfvos
INSERT INTO nfv_orchestrator (name, type, version, operational_state, site_id)
VALUES ('Turin OSM @ Polito', 'OSM', 'R6', 'ENABLED',
(SELECT id FROM site WHERE name='ITALY_TURIN'));

-- vim
INSERT INTO vim_account (name, tenant, type, uri, vim_account_nfvo_id)
VALUES ('Cloud VIM Openstack', '5geve-cloud', 'openstack',
        'http://10.20.20.1:5000/v3', '77c531ef-ff08-42a3-aeb9-3b8eae19a32f');
INSERT INTO vim_account (name, tenant, type, uri, vim_account_nfvo_id)
VALUES ('Edge VIM Openstack', '5geve-edge', 'openstack',
        'http://10.20.20.1:5000/v3', 'e59a8dfd-dd21-42cc-98f7-a68c83cfbdbd');

-- vim_nfvo
INSERT INTO vim_nfvo (vim_id, nfvo_id) VALUES
((SELECT id FROM vim_account WHERE tenant='5geve-cloud'),
 (SELECT id FROM nfv_orchestrator WHERE name='Turin OSM @ Polito'));
INSERT INTO vim_nfvo (vim_id, nfvo_id) VALUES
((SELECT id FROM vim_account WHERE tenant='5geve-edge'),
 (SELECT id FROM nfv_orchestrator WHERE name='Turin OSM @ Polito'));

-- availability_zone
INSERT INTO availability_zone (latitude, location, longitude, name, vim_account_id)
VALUES (45.062379, 'CLOUD', 7.662097, 'polito cloud zone',
        (SELECT id FROM vim_account WHERE vim_account_nfvo_id='77c531ef-ff08-42a3-aeb9-3b8eae19a32f'));
INSERT INTO availability_zone (latitude, location, longitude, name, vim_account_id)
VALUES (45.062207, 'EDGE', 7.678558, 'porta nuova edge zone',
        (SELECT id FROM vim_account WHERE vim_account_nfvo_id='e59a8dfd-dd21-42cc-98f7-a68c83cfbdbd'));

-- notification_type initialization
INSERT INTO notification_type (type) VALUES ('NsLcmOperationOccurenceNotification');
INSERT INTO notification_type (type) VALUES ('NsIdentifierCreationNotification');
INSERT INTO notification_type (type) VALUES ('NsIdentifierDeletionNotification');
