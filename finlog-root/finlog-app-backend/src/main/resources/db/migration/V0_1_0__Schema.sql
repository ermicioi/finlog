CREATE TABLE users
  (
     id           IDENTITY NOT NULL,
     version      INT NOT NULL DEFAULT 0,
     created_time TIMESTAMP NOT NULL,
     updated_time TIMESTAMP NOT NULL,
     email        VARCHAR(255) NOT NULL,
     password     VARCHAR(255) NOT NULL
  );