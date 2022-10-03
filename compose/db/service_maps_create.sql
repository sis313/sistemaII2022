-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-09 18:22:16.22

-- -----------------------------------------------------
-- Schema service_maps
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS service_maps;

-- -----------------------------------------------------
-- Schema service_maps
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS service_maps DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE service_maps;

    -- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-11 18:08:32.7

-- tables
-- Table: booking
CREATE TABLE booking (
                         id_booking int NOT NULL AUTO_INCREMENT,
                         date date NOT NULL,
                         time time NOT NULL,
                         amount decimal(5,2) NOT NULL,
                         id_product int NOT NULL,
                         id_user int NOT NULL,
                         CONSTRAINT booking_pk PRIMARY KEY (id_booking)
);

-- Table: branch
CREATE TABLE branch (
                        id_branch int NOT NULL AUTO_INCREMENT,
                        address varchar(200) NOT NULL,
                        open_hour time NOT NULL,
                        close_hour time NOT NULL,
                        attention_days varchar(100) NOT NULL,
                        image blob NULL,
                        id_zone int NOT NULL,
                        id_location int NOT NULL,
                        id_business int NOT NULL,
                        create_date date NOT NULL,
                        update_date date NOT NULL,
                        status int NOT NULL,
                        CONSTRAINT branch_pk PRIMARY KEY (id_branch)
);

-- Table: business
CREATE TABLE business (
                          id_business int NOT NULL AUTO_INCREMENT,
                          name varchar(150) NOT NULL,
                          description varchar(250) NOT NULL,
                          id_type_business int NOT NULL,
                          id_user int NOT NULL,
                          create_date date NOT NULL,
                          update_date date NOT NULL,
                          status int NOT NULL,
                          CONSTRAINT business_pk PRIMARY KEY (id_business)
);

-- Table: city
CREATE TABLE city (
                      id_city int NOT NULL AUTO_INCREMENT,
                      name varchar(100) NOT NULL,
                      CONSTRAINT city_pk PRIMARY KEY (id_city)
);

-- Table: comment
CREATE TABLE comment (
                         id_comment int NOT NULL AUTO_INCREMENT,
                         message varchar(255) NOT NULL,
                         id_user int NOT NULL,
                         id_business int NOT NULL,
                         status int NOT NULL,
                         CONSTRAINT comment_pk PRIMARY KEY (id_comment)
);

-- Table: location
CREATE TABLE location (
                          id_location int NOT NULL AUTO_INCREMENT,
                          latitude float(10,10) NOT NULL,
    longitude float(10,10) NOT NULL,
    CONSTRAINT location_pk PRIMARY KEY (id_location)
);

-- Table: municipalities
CREATE TABLE municipalities (
                                id_municipalities int NOT NULL AUTO_INCREMENT,
                                name varchar(100) NOT NULL,
                                id_city int NOT NULL,
                                CONSTRAINT municipalities_pk PRIMARY KEY (id_municipalities)
);

-- Table: product
CREATE TABLE product (
                         id_product int NOT NULL AUTO_INCREMENT,
                         name varchar(50) NOT NULL,
                         description varchar(150) NOT NULL,
                         stock int NOT NULL,
                         price decimal(6,2) NOT NULL,
                         discount decimal(5,2) NOT NULL,
                         id_business int NOT NULL,
                         CONSTRAINT product_pk PRIMARY KEY (id_product)
);

-- Table: rating
CREATE TABLE rating (
                        id_rating int NOT NULL AUTO_INCREMENT,
                        score int NOT NULL,
                        favorite_status bool NOT NULL,
                        id_branch int NOT NULL,
                        id_user int NOT NULL,
                        CONSTRAINT rating_pk PRIMARY KEY (id_rating)
);

-- Table: type_business
CREATE TABLE type_business (
                               id_type_business int NOT NULL AUTO_INCREMENT,
                               name varchar(100) NOT NULL,
                               CONSTRAINT type_business_pk PRIMARY KEY (id_type_business)
);

-- Table: type_user
CREATE TABLE type_user (
                           id_type_user int NOT NULL AUTO_INCREMENT,
                           name varchar(25) NOT NULL,
                           CONSTRAINT type_user_pk PRIMARY KEY (id_type_user)
);

-- Table: user
CREATE TABLE user (
                      id_user int NOT NULL AUTO_INCREMENT,
                      name varchar(200) NOT NULL,
                      email varchar(150) NOT NULL,
                      nickname varchar(20) NOT NULL,
                      password varchar(100) NOT NULL,
                      id_type_user int NOT NULL,
                      create_date date NOT NULL,
                      update_date date NOT NULL,
                      status varchar(10) NOT NULL,
                      CONSTRAINT user_pk PRIMARY KEY (id_user)
);

-- Table: verification_token
CREATE TABLE verification_token (
                                    id_verification_token int NOT NULL AUTO_INCREMENT,
                                    token varchar(200) NOT NULL,
                                    created_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                    expiry_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                    id_user int NOT NULL,
                                    CONSTRAINT verification_token_pk PRIMARY KEY (id_verification_token)
);

-- Table: zone
CREATE TABLE zone (
                      id_zone int NOT NULL AUTO_INCREMENT,
                      name varchar(100) NOT NULL,
                      id_municipalities int NOT NULL,
                      CONSTRAINT zone_pk PRIMARY KEY (id_zone)
);

-- foreign keys
-- Reference: booking_product (table: booking)
ALTER TABLE booking ADD CONSTRAINT booking_product FOREIGN KEY booking_product (id_product)
    REFERENCES product (id_product);

-- Reference: booking_user (table: booking)
ALTER TABLE booking ADD CONSTRAINT booking_user FOREIGN KEY booking_user (id_user)
    REFERENCES user (id_user);

-- Reference: branch_business (table: branch)
ALTER TABLE branch ADD CONSTRAINT branch_business FOREIGN KEY branch_business (id_business)
    REFERENCES business (id_business);

-- Reference: branch_location (table: branch)
ALTER TABLE branch ADD CONSTRAINT branch_location FOREIGN KEY branch_location (id_location)
    REFERENCES location (id_location);

-- Reference: branch_zone (table: branch)
ALTER TABLE branch ADD CONSTRAINT branch_zone FOREIGN KEY branch_zone (id_zone)
    REFERENCES zone (id_zone);

-- Reference: business_type_business (table: business)
ALTER TABLE business ADD CONSTRAINT business_type_business FOREIGN KEY business_type_business (id_type_business)
    REFERENCES type_business (id_type_business);

-- Reference: business_user (table: business)
ALTER TABLE business ADD CONSTRAINT business_user FOREIGN KEY business_user (id_user)
    REFERENCES user (id_user);

-- Reference: comment_business (table: comment)
ALTER TABLE comment ADD CONSTRAINT comment_business FOREIGN KEY comment_business (id_business)
    REFERENCES business (id_business);

-- Reference: comment_user (table: comment)
ALTER TABLE comment ADD CONSTRAINT comment_user FOREIGN KEY comment_user (id_user)
    REFERENCES user (id_user);

-- Reference: municipalities_city (table: municipalities)
ALTER TABLE municipalities ADD CONSTRAINT municipalities_city FOREIGN KEY municipalities_city (id_city)
    REFERENCES city (id_city);

-- Reference: product_business (table: product)
ALTER TABLE product ADD CONSTRAINT product_business FOREIGN KEY product_business (id_business)
    REFERENCES business (id_business);

-- Reference: rating_branch (table: rating)
ALTER TABLE rating ADD CONSTRAINT rating_branch FOREIGN KEY rating_branch (id_branch)
    REFERENCES branch (id_branch);

-- Reference: rating_user (table: rating)
ALTER TABLE rating ADD CONSTRAINT rating_user FOREIGN KEY rating_user (id_user)
    REFERENCES user (id_user);

-- Reference: user_type_user (table: user)
ALTER TABLE user ADD CONSTRAINT user_type_user FOREIGN KEY user_type_user (id_type_user)
    REFERENCES type_user (id_type_user);

-- Reference: verification_token_user (table: verification_token)
ALTER TABLE verification_token ADD CONSTRAINT verification_token_user FOREIGN KEY verification_token_user (id_user)
    REFERENCES user (id_user);

-- Reference: zone_municipalities (table: zone)
ALTER TABLE zone ADD CONSTRAINT zone_municipalities FOREIGN KEY zone_municipalities (id_municipalities)
    REFERENCES municipalities (id_municipalities);

INSERT Into type_user (name) VALUES ('ADMIN');
INSERT Into type_user (name) VALUES ('USER');
-- End of file.