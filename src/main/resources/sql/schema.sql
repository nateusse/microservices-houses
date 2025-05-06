CREATE DATABASE IF NOT EXISTS stock;
USE stock;

DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS cities;
DROP TABLE IF EXISTS departments;


CREATE TABLE categories (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(50) NOT NULL UNIQUE,
                           description VARCHAR(90) NOT NULL
);

CREATE TABLE departments (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(50) NOT NULL UNIQUE,
                             description VARCHAR(120) NOT NULL
);

CREATE TABLE cities (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(50) NOT NULL UNIQUE,
                        description VARCHAR(120) NOT NULL,
                        id_department INT NOT NULL,
                        FOREIGN KEY (id_department) REFERENCES departments(id)
);

CREATE TABLE locations (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           neighborhood VARCHAR(50) NOT NULL,
                           id_city INT NOT NULL,
                           FOREIGN KEY (id_city) REFERENCES cities(id)
);
