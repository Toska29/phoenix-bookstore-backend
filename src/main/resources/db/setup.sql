create database bookshelf_db;

create user 'mav_user'@'localhost' identified by 'pass_123';
grant all privileges on bookshelf_db. * to 'mav_user'@'localhost';
flush privileges ;

