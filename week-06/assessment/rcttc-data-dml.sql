use `rcttc-schema`;

select * from `rcttc-data`;

set sql_safe_updates = 0;
delete from `rcttc-data`
where customer_last = 'Egle of Germany' and customer_first = 'Liv';
set sql_safe_updates = 1;

select distinct customer_first, customer_last, customer_email, customer_phone, customer_address
from `rcttc-data`;

insert into customer (first_name, last_name, email, phone, address)
select distinct customer_first, customer_last, customer_email, customer_phone, customer_address
from `rcttc-data`;

select * from customer;


select distinct theater, theater_address, theater_phone, theater_email
from `rcttc-data`;

insert into theater (`name`,address,phone,email)
select distinct theater, theater_address, theater_phone, theater_email
from `rcttc-data`;

select * from theater;


select distinct `show`
from `rcttc-data`;

insert into play (play_name)
select distinct `show`
from `rcttc-data`;

select * from play;


select 
	c.customer_id,
    t.theater_id,
	p.play_id,
    d.`date`,
    d.seat,
    d.ticket_price
from `rcttc-data` d
left outer join customer c on d.customer_first = c.first_name and d.customer_last = c.last_name
left outer join theater t on d.theater = t.`name`
left outer join play p on d.`show` = p.play_name;

insert into viewing (customer_id, theater_id, play_id, show_date, seat, price)
select 
	c.customer_id,
    t.theater_id,
	p.play_id,
    d.`date`,
    d.seat,
    d.ticket_price
from `rcttc-data` d
left outer join customer c on d.customer_first = c.first_name and d.customer_last = c.last_name
left outer join theater t on d.theater = t.`name`
left outer join play p on d.`show` = p.play_name;

select * from viewing;

-- select * from viewing
-- where theater_id = (select theater_id from theater where `name` = "Little Fitz") 
-- and show_date = '2021-03-01';

update viewing set
price = 22.25
where theater_id = (select theater_id from theater where `name` = "Little Fitz") 
and show_date = '2021-03-01';

update customer set
phone = '1-801-EAT-CAKE'
where first_name = 'Jammie' and last_name = 'Swindles';

select * from viewing
where theater_id = (select theater_id from theater where `name` = "Little Fitz") 
and show_date = '2021-03-01';

update viewing set
customer_id = 39
where theater_id = (select theater_id from theater where `name` = "Little Fitz") 
and show_date = '2021-03-01'
and seat = 'A2';

update viewing set
customer_id = 36
where theater_id = (select theater_id from theater where `name` = "Little Fitz") 
and show_date = '2021-03-01'
and seat = 'A4';

update viewing set
customer_id = 37
where theater_id = (select theater_id from theater where `name` = "Little Fitz") 
and show_date = '2021-03-01'
and seat = 'B4';

update viewing set
customer_id = 38
where theater_id = (select theater_id from theater where `name` = "Little Fitz") 
and show_date = '2021-03-01'
and seat = 'C2';

select * from viewing 
where theater_id = (select theater_id from theater where `name` = "10 Pin"); 

delete from viewing
where customer_id = 7 and theater_id = 1;

delete from viewing
where customer_id = 8 and theater_id = 1;

delete from viewing
where customer_id = 10 and theater_id = 1;

delete from viewing
where customer_id = 15 and theater_id = 1;

delete from viewing
where customer_id = 18 and theater_id = 1;

delete from viewing
where customer_id = 19 and theater_id = 1;

delete from viewing
where customer_id = 22 and theater_id = 1;

delete from viewing
where customer_id = 25 and theater_id = 1;

delete from viewing
where customer_id = 26 and theater_id = 1;

drop table `rcttc-data`;