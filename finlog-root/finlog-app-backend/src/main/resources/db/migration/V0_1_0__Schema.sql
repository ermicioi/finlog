CREATE TABLE users
  (
     id           IDENTITY NOT NULL,
     version      INT NOT NULL DEFAULT 0,
     created_time TIMESTAMP NOT NULL,
     updated_time TIMESTAMP NOT NULL,
     email        VARCHAR(255) NOT NULL,
     password     VARCHAR(255) NOT NULL,
     first_name     VARCHAR(255) NULL,
     last_name     VARCHAR(255) NULL
  );

INSERT INTO users (created_time, updated_time, email, password, first_name, last_name) VALUES
    (now(), now(), 'root@root.com', 'rootpass', 'John', 'Doe')