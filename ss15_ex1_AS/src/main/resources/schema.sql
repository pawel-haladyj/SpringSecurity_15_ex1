CREATE TABLE IF NOT EXISTS authority (
    id BIGINT PRIMARY KEY,
    name VARCHAR (50),
    user BIGINT,
    CONSTRAINT fk_user_id_authority FOREIGN KEY (user) REFERENCES users(id)
);

/*CREATE TABLE IF NOT EXISTS client (
    id BIGINT PRIMARY KEY,
    client_id VARCHAR (50),
    secret VARCHAR (50)
);*/

/*CREATE TABLE IF NOT EXISTS grant_type(
    id BIGINT PRIMARY KEY,
    name VARCHAR (50),
    client BIGINT,
    CONSTRAINT fk_client_id_grant_type FOREIGN KEY (client) REFERENCES client(id)
);*/

/*CREATE TABLE IF NOT EXISTS product(
    id BIGINT PRIMARY KEY,
    currency VARCHAR (3),
    name VARCHAR (50),
    price DECIMAL
);*/

/*CREATE TABLE IF NOT EXISTS scopes(
    id BIGINT PRIMARY KEY,
    name VARCHAR (50),
    client BIGINT,
    CONSTRAINT fk_client_id_scopes FOREIGN KEY (client) REFERENCES client(id)
);*/

CREATE TABLE IF NOT EXISTS users(
    id BIGINT PRIMARY KEY,
    password VARCHAR (50),
    username VARCHAR (50)
);

CREATE TABLE IF NOT EXISTS oauth_access_token(
    token_id VARCHAR (100) PRIMARY KEY,
    token BLOB,
    authentication_id VARCHAR (100),
    user_name VARCHAR (100),
    client_id VARCHAR (100),
    authentication BLOB,
    refresh_token VARCHAR (100)
);

CREATE TABLE IF NOT EXISTS oauth_refresh_token(
    token_id VARCHAR (100) PRIMARY KEY,
    token BLOB,
    authentication BLOB
);