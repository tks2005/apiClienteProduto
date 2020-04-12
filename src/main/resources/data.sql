DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS logs;
--DROP TABLE IF EXISTS users;
--DROP TABLE IF EXISTS roles;
--DROP TABLE IF EXISTS user_role;

CREATE TABLE clients (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) UNIQUE NOT NULL
);

CREATE TABLE logs (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    log VARCHAR(250) NOT NULL
);

CREATE TABLE products (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    codigo INT UNIQUE NOT NULL,
    description VARCHAR(250) NOT NULL
);

--CREATE TABLE users (
  --  id INT AUTO_INCREMENT  PRIMARY KEY,
   -- name VARCHAR(250) NOT NULL,
  --  password VARCHAR(250) NOT NULL
--);

--CREATE TABLE roles (
  --  id INT AUTO_INCREMENT  PRIMARY KEY,
   -- name VARCHAR(250) NOT NULL,
--);

--CREATE TABLE user_role (
  --  user_id INT NOT NULL,
    --user_role INT NOT NULL,
--);

INSERT INTO users (id, name, password) VALUES
(1,'admin', '$2y$12$NuWcrkMufOIKvPUOKbY52urB54alxh7oB775Q8i.J2fR936fwRB8a'),
(2,'user', '$2y$12$/hY/tdnj0hlTP2q5seFblOCerySJW3dmZ9X5f0vNn5zKC58XOgi6C');

INSERT INTO roles (id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

insert into user_role(user_id, role_id) values
(1,1),
(1,2),
(2,2);

--INSERT INTO clients (name) VALUES
 --   ('Joao'),
--    ('Maria'),
--    ('Joana');

--INSERT INTO products (codigo, description) VALUES
  --(10, 'Monitor'),
  --(20, 'Notebook'),
  --(30, 'Copo');