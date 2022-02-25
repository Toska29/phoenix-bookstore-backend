create database bookstore_database;

create User 'bookstore_user2'@'localhost' identified by 'pass_123';
grant all privileges on bookstore_database.* to 'bookstore_user2'@'localhost';
flush privileges;