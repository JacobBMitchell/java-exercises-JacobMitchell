drop database if exists solar_farm_test;

create database solar_farm_test;
use solar_farm_test;

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

set delimiter //
create procedure set_good_known_state()
begin
truncate panels;
insert into panels (panel_id,section,`row`,`col`,`year`,material,tracking)
values
(1,"The Ridge", 2,3,2019,"POLY_SI",1),
(2,"The Hills", 3,4,2020,"MONO_SI",1),
(3,"The Narrows", 2,1,1998,"A_SI",1),
(4,"The Meadow", 6,4,2000,"CIGS",0)
;
end //
set delimiter ;

call set_good_known_state();
