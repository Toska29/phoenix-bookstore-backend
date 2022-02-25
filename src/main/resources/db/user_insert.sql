set foreign_key_checks = 0;

truncate table app_user;

insert into app_user(id, first_name, last_name, email, password)
values(5005, 'John', 'Ogbe', 'johnogbe@gmail.com', 'mypassword');


set foreign_key_checks = 1;