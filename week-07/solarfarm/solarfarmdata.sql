drop database if exists solar_farm;

create database solar_farm;
use solar_farm;

create table panels( 
panel_id int primary key auto_increment,
section varchar(50) not null,
`row` int not null,
`col` int not null,
`year` year not null,
material varchar(70) not null,
tracking boolean not null,
constraint uq_row_col_section unique(`row`,`col`,section)
);



