drop database if exists memories_test;
create database memories_test;
use memories_test;

create table `memory`(
id int primary key auto_increment, 
`from` varchar(30) not null,
content varchar(300) not null,
sharable boolean not null
);

set delimiter //
create procedure set_good_known_state()
begin
truncate `memory`;
insert into `memory` (id,`from`,content,sharable)
values
(1,"Jacob", "I made this database",true),
(2,"Jodi", "Asked about result classes",true),
(3,"Julian","Tried to combine groups", false)
;
end //
set delimiter ;

call set_good_known_state();