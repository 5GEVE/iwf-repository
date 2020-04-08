-- notification_type initialization
INSERT INTO notification_type (id, type) VALUES (nextval('hibernate_sequence'), 'NsLcmOperationOccurenceNotification');
INSERT INTO notification_type (id, type) VALUES (nextval('hibernate_sequence'), 'NsIdentifierCreationNotification');
INSERT INTO notification_type (id, type) VALUES (nextval('hibernate_sequence'), 'NsIdentifierDeletionNotification');
