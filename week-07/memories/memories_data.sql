drop database if exists memories;
create database memories;
use memories;

create table `memory`(
id int primary key auto_increment, 
`from` varchar(30) not null,
content varchar(300) not null,
sharable boolean not null
);