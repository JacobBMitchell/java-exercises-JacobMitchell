use bowls;

select
	customer.last_name,
    `order`.order_id,
    item.name
from customer
inner join `order` on customer.customer_id = `order`.customer_id
inner join order_item on `order`.order_id = order_item.order_id
inner join item on order_item.item_id = item.item_id
where date(order_date) = '2020-07-28';

select
	c.last_name,
    o.order_id,
    i.name
from customer c 
inner join `order` o on c.customer_id = o.customer_id
inner join order_item oi on o.order_id = oi.order_id
inner join item i on oi.item_id = i.item_id
where date(o.order_date) = '2020-07-28';
