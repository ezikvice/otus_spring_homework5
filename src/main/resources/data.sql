INSERT INTO acl_sid (id, principal, sid)
VALUES (1, 1, 'admin'),
       (2, 1, 'ua'),
       (3, 1, 'ug'),
       (4, 0, 'ROLE_AUTHOR_EDITOR'),
       (5, 0, 'ROLE_GENRE_EDITOR'),
       (6, 0, 'ROLE_ADMIN');

INSERT INTO acl_class (id, class, class_id_type)
VALUES (1, 'ru.ezikvice.springotus.homework13.dao.Author', 'String'),
       (2, 'ru.ezikvice.springotus.homework13.dao.Genre', 'String');

INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting)
VALUES (1, 1, 1, 1, 2, 0),
       (2, 1, 2, 1, 2, 0),
       (3, 1, 3, 1, 2, 0);

INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure)
VALUES (1, 1, 1, 4, 31, 1, 1, 1);