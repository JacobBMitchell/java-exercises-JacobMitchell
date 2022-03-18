drop database if exists music;
create database music;
use music;

create table artists (
id int primary key auto_increment,
first_name varchar(30) not null,
last_name varchar(30) not null,
alias varchar(30) null,
instrument varchar (25) not null,
constraint uni_alias unique(alias),
constraint uni_name unique(first_name, last_name)
);

create table albums (
id int primary key auto_increment,
`name` varchar(50) not null,
units int not null,
cost decimal(5,2) not null,
number_of_tracks int not null,
run_time time (0) not null,
release_date date not null,
constraint uni_name unique(`name`)
);

create table artists_albums (
artist_id int not null,
album_id int not null,
constraint pk_artists_albums primary key (artist_id, album_id),
constraint fk_artist foreign key(artist_id) references artists(id),
constraint fk_album foreign key(album_id) references albums(id)
);

create table tracks (
id int primary key auto_increment,
`name` varchar(50) not null,
track_length time (0) not null,
genre varchar(20) null,
album_id int not null,
constraint fk_album_track foreign key(album_id) references albums(id)
);

create table features (
artist_id int not null,
track_id int not null,
constraint pk_artists_track primary key (artist_id, track_id),
constraint fk_artist_feature foreign key(artist_id) references artists(id),
constraint fk_track_feature foreign key(track_id) references tracks(id)
);


create table writers(
id int primary key auto_increment,
`name` varchar(50) not null,
artist_id int null,
constraint uni_name_writer unique(`name`),
constraint fk_artist_writer foreign key (artist_id) references artists(id)
);

create table writer_track(
writer_id int not null,
track_id int not null,
constraint pk_writer_track primary key (writer_id, track_id),
constraint fk_writer_id foreign key(writer_id) references writers(id),
constraint fk_track_id foreign key(track_id) references tracks(id)
);

insert into artists(first_name,last_name, alias, instrument)
values  ('Beyonce', 'Knowles','Beyonce','Vocal'),
		('Shawn', 'Carter', 'Jay-Z', 'Vocal'),
        ('Frank', 'Ocean', 'Frank Ocean','Trumpet')
        ;

select *
from artists;



