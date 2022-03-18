drop database if exists `rcttc-schema`;
create database `rcttc-schema`;
use `rcttc-schema`;

create table customer (
customer_id int primary key auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
email varchar (60) not null unique,
phone char(12) null unique, -- 555-555-5555
address varchar (100) null,
constraint uni_name_customer unique(first_name,last_name)
);

create table theater (
theater_id int primary key auto_increment,
`name` varchar(20) not null unique,
address varchar(100) not null,
phone char(14) not null, -- (651) 555-5555
email varchar(50) not null
);

create table play(
play_id int primary key auto_increment,
play varchar(30) not null
);

create table viewing (
customer_id int not null,
theater_id int not null,
play_id int not null,
show_date date not null,
seat char(2) not null,
price decimal(4,2) not null,
constraint date_seat_theater_viewing primary key(show_date,seat,theater_id),
constraint fk_customer_id_viewing foreign key (customer_id) references customer(customer_id),
constraint fk_theater_id_viewing foreign key (theater_id) references theater(theater_id),
constraint fk_play_id_viewing foreign key (play_id) references play(play_id)
);