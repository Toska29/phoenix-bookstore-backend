create database bookshelves_db;

create user 'muqtar'@'localhost' identified by 'pass_123';
grant all privileges on bookshelves_db. * to 'muqtar'@'localhost';
flush privileges ;
