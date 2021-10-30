CREATE TABLE user (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  firstname varchar(255) DEFAULT NULL,
  mobile_no varchar(255) DEFAULT NULL,
  is_active tinyint DEFAULT NULL,
  is_deleted tinyint DEFAULT NULL,
  created_at timestamp NULL DEFAULT NULL,
  modified_at timestamp NULL DEFAULT NULL,
  lastname varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE spare_parts (
  id int NOT NULL AUTO_INCREMENT,
  parts_name varchar(255) DEFAULT NULL,
  parts_description varchar(255) DEFAULT NULL,
  is_active tinyint DEFAULT NULL,
  is_deleted tinyint DEFAULT NULL,
  created_at timestamp NULL DEFAULT NULL,
  modified_at timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id),
  spare_parts_type_id_fk int NOT NULL
  );



CREATE TABLE spare_parts_type (
  id int NOT NULL AUTO_INCREMENT,
  parts_type_name varchar(255) DEFAULT NULL,
  parts_type_description varchar(255) DEFAULT NULL,
  is_active tinyint DEFAULT NULL,
  is_deleted tinyint DEFAULT NULL,
  created_at timestamp NULL DEFAULT NULL,
  modified_at timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE orderdetails (
  id int NOT NULL AUTO_INCREMENT,
  is_active tinyint DEFAULT NULL,
  is_deleted tinyint DEFAULT NULL,
  created_at timestamp NULL DEFAULT NULL,
  modified_at timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id),
  user_id_fk int NOT NULL,
  spare_parts_id_fk int NOT NULL
  );


ALTER TABLE orderdetails
add foreign key (user_id_fk) references user(id),
add foreign key (spare_parts_id_fk) references spare_parts(id);

alter table spare_parts
add foreign key (spare_parts_type_id_fk) references spare_parts_type(id);

