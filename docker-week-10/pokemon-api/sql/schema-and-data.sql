drop database if exists pokedex;
create database pokedex;
use pokedex;

create table poke_type (
	poke_type_id int primary key auto_increment,
	name varchar(25) not null unique
);

create table pokemon (
	dex_number int primary key,
	name varchar(50) not null unique,
	primary_poke_type_id int not null,
	secondary_poke_type_id int not null,
	constraint fk_primary_poke_type_id
		foreign key (primary_poke_type_id)
		references poke_type(poke_type_id),
	constraint fk_secondary_poke_type_id
		foreign key (secondary_poke_type_id)
		references poke_type(poke_type_id)
);

insert into poke_type values
	(1, 'Grass'),
    (2, 'Poison'),
    (3, 'Fire'),
    (4, 'Flying'),
    (5, 'Water'),
    (6, 'Bug');
    
insert into pokemon values 
	(1, 'Bulbasaur', 1, 2),
    (2, 'Ivysaur', 1, 2),
    (3, 'Venusaur', 1, 2),
    (4, 'Charmander', 3, 3),
    (5, 'Charmeleon', 3, 3),
    (6, 'Charizard', 3, 4),
    (7, 'Squirtle', 5, 5),
    (8, 'Wartortle', 5, 5),
    (9, 'Blastoise', 5, 5),
    (10, 'Caterpie', 6, 6);