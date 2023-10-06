DROP DATABASE IF EXISTS Strikers;

CREATE DATABASE Strikers;

USE Strikers;

CREATE TABLE strikes (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
power VARCHAR(255) NOT NULL,
speed VARCHAR(255) NOT NULL,
strike_type VARCHAR(255) NOT NULL,
video_url_fighter VARCHAR(255) NOT NULL,
video_url_tutorial VARCHAR(255) NOT NULL,

PRIMARY KEY(id)
);

CREATE TABLE fighters (
id INT NOT NULL AUTO_INCREMENT,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
age INT NOT NULL,
gym VARCHAR(255) NOT NULL,
discipline VARCHAR(255) NOT NULL,
location VARCHAR(255) NOT NULL,
profile_picture VARCHAR(255) NOT NULL,
strike1_id INT NOT NULL,
strike2_id INT NOT NULL,
strike3_id INT NOT NULL,
strike4_id INT NOT NULL,

FOREIGN KEY (`strike1_id`) REFERENCES `strikes` (`id`),
FOREIGN KEY (`strike2_id`) REFERENCES `strikes` (`id`),
FOREIGN KEY (`strike3_id`) REFERENCES `strikes` (`id`),
FOREIGN KEY (`strike4_id`) REFERENCES `strikes` (`id`),
PRIMARY KEY(id)
);

