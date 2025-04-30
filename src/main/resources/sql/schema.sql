
CREATE DATABASE IF NOT EXISTS stock;
USE stock;
DELETE FROM categories;
DROP TABLE IF EXISTS stocks;
DROP TABLE IF EXISTS categories;
CREATE TABLE IF NOT EXISTS categories (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(50) NOT NULL UNIQUE,
                           description VARCHAR(90) NOT NULL
);