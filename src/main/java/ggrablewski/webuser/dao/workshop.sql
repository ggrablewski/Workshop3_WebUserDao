CREATE DATABASE webuserDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

SHOW DATABASES;

CREATE TABLE users (
                         id INT NOT NULL AUTO_INCREMENT,
                         username VARCHAR(255) NOT NULL,
                         email VARCHAR(255),
                         password VARCHAR(60),
                         PRIMARY KEY (id)
);

DESC users;

SHOW TABLES;

DELETE FROM users;

SELECT * FROM users;

UPDATE users SET username = 'nowydrugi', email = 'nowyemail@drugi' WHERE username= 'drugi';
