use `rcttc-schema`;
-- select * from theater;

select distinct t.`name` theater_name, p.play_name, v.show_date
from viewing v 
inner join play p on v.play_id = p.play_id
inner join theater t on v.theater_id = t.theater_id
where v.show_date > '2021-10-01' and v.show_date < '2021-12-31';

select * from customer;

select * from customer
where email like '%.com';

select distinct t.`name` theater_name, p.play_name, v.show_date, v.price
from viewing v 
inner join play p on v.play_id = p.play_id
inner join theater t on v.theater_id = t.theater_id
order by price asc
limit 3;

select distinct c.first_name, c.last_name, t.`name` theater_name, p.play_name, v.show_date
from viewing v 
inner join play p on v.play_id = p.play_id
inner join theater t on v.theater_id = t.theater_id
inner join customer c on v.customer_id = c.customer_id;

select distinct c.first_name, c.last_name, t.`name` theater_name, p.play_name, v.seat
from viewing v 
inner join play p on v.play_id = p.play_id
inner join theater t on v.theater_id = t.theater_id
inner join customer c on v.customer_id = c.customer_id;

select first_name, last_name, address
from customer
where address is null or address = '';

select distinct c.first_name 'customer_first',
 c.last_name 'customer_last',
 c.email 'customer_email',
 c.phone 'customer_phone',
 c.address 'customer_address',
 v.seat,
 p.play_name 'show',
 v.price 'ticket_price',
 v.show_date 'date',
 t.`name` theater,
 t.address theater_address,
 t.phone theater_phone,
 t.email theater_email
from viewing v 
inner join play p on v.play_id = p.play_id
inner join theater t on v.theater_id = t.theater_id
inner join customer c on v.customer_id = c.customer_id;

select c.first_name, c.last_name, sum(v.price)
from viewing v 
inner join customer c on v.customer_id = c.customer_id
group by c.first_name, c.last_name;

select t.`name`, v.show_date, p.play_name, sum(v.price)
from viewing v 
inner join play p on v.play_id = p.play_id
inner join theater t on v.theater_id = t.theater_id
group by t.`name`, v.show_date, p.play_name;

select t.`name`, sum(v.price)
from viewing v 
inner join play p on v.play_id = p.play_id
inner join theater t on v.theater_id = t.theater_id
group by t.`name`;

select c.first_name, c.last_name, sum(v.price)
from viewing v 
inner join customer c on v.customer_id = c.customer_id
group by c.first_name, c.last_name
order by sum(v.price) desc
limit 1;