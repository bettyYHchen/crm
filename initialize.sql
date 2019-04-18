-- CREATE DATABASE crm_db;
USE crm_db;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS crm_user;
CREATE TABLE IF NOT EXISTS course (
    id BIGINT NOT NULL AUTO_INCREMENT,
    course_public_id VARCHAR(255),
    course_title VARCHAR(255),
    course_batch_name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS crm_user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO crm_user (user_name, password,role)
  VALUES ('dummy','dummy','team');
  
INSERT INTO crm_user (user_name, password,role)
  VALUES ('admin','admin','admin');
  
INSERT INTO crm_user (user_name, password,role)
  VALUES ('admin1','admin1','admin');
  




