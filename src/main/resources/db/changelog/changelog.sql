--liquibase formatted sql
--changeset Dhrutimaya:9090.v1 splitStatements:true;
CREATE TABLE IF NOT EXISTS credential_master (
  id bigint NOT NULL AUTO_INCREMENT,
  email varchar(100) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  phone_no varchar(20) DEFAULT NULL,
  user_id bigint DEFAULT NULL,
  user_type_id int DEFAULT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS user_data (
  id bigint NOT NULL AUTO_INCREMENT,
  email varchar(100) DEFAULT NULL,
  phone_no varchar(20) DEFAULT NULL,
  user_name varchar(255) DEFAULT NULL,
  is_active bit(1) DEFAULT NULL,
  PRIMARY KEY (id)
);

--changeset Manoranjan:22928
CREATE TABLE IF NOT EXISTS parent_product (
  id bigint NOT NULL AUTO_INCREMENT,
  product_name varchar(200),
  image_url text,
  PRIMARY KEY (id)
);
--changeset Dhrutimaya:9090.v2
CREATE TABLE IF NOT EXISTS sub_product (
  id bigint NOT NULL AUTO_INCREMENT,
  sub_product_name varchar(200),
  image_url text,
  parent_product_id int,
  PRIMARY KEY (id)
);
--changeset Dhrutimaya:9090.v3
CREATE TABLE IF NOT EXISTS product (
  id bigint NOT NULL AUTO_INCREMENT,
  product_name varchar(200),
  model_name varchar(200),
  price double,
  image_url text,
  is_active tinyint(1),
  available_stock int,
  sub_product_id INT,
  PRIMARY KEY (id)
);

--changeset Manoranjan:181919
create table if not exists state(
id int auto_increment primary key,
state_name varchar(30)
);

--changeset Manoranjan:1819190
create table if not exists city(
id int auto_increment primary key,
state_id int ,
city_name varchar(30)
);

--changeset Manoranjan:181919002
create table if not exists user_address_map(
id int auto_increment primary key,
city_id int,
state_id int,
address varchar(255),
user_id int,
phone varchar(10),
name varchar(30),
near_by_loaction_address varchar(100),
pincode int
);


