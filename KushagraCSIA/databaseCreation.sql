CREATE DATABASE IF NOT EXISTS driving_school;

Use driving_school;
DROP TABLE IF EXISTS Users;

CREATE TABLE Users (
LastName varchar(255) not null default '',
FirstName varchar(255) not null default '',
email varchar(255) not null default ''
);

INSERT INTO Users 
VALUES ('Sharma','Shruti', 'shruti@gmail.com'),('Sharma','Kush', 'kush@gmail.com');

Select * from Users;