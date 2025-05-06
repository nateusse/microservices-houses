CREATE DATABASE IF NOT EXISTS stock;
USE stock;

DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(50) NOT NULL UNIQUE,
                           description VARCHAR(90) NOT NULL
);