INSERT INTO users (id, password, username) VALUES
(1, '12345', 'john'),
(2, 'qwerty', 'mike');

INSERT INTO authority (id, name, user) VALUES
(1, 'READ', 1),
(2, 'WRITE', 1),
(3, 'UPDATE', 1),
(4, 'DELETE', 1),
(5,'READ',2);

/*INSERT INTO client (id, client_id, secret) VALUES
(1, 'CLIENT1', 'SECRET1'),
(2, 'CLIENT2', 'SECRET2');*/

/*INSERT INTO grant_type (id, name, client) VALUES
(1, 'password', 1),
(2, 'refresh_token', 1),
(3, 'client_credentials',2);*/

/*INSERT INTO product (id, currency, name, price) VALUES
(1,'EUR','bike', 1000),
(2,'USD','apple', 100),
(3,'GBP','ticket', 10);*/

/*INSERT INTO scopes (id, name, client) VALUES
(1,'READ',1),
(2,'WRITE',1),
(3,'READ',2);*/


