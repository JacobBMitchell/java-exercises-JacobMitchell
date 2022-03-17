use gravel_family;

-- Solve each task by writing a query below the task description.
-- Each task describes the expected result.
-- Unfortunately, tasks must be verified manually. 

-- Example: 
-- Count the number of customer in Toronto
-- Expected: 14
select count(*)
from customer
where city = 'Toronto';

-- How many employees have the last_name 'Soyle'?
-- Expected: 12
select count(*)
from employee
where last_name = 'soyle';

-- How many projects are there in the database?
-- Expected: 1121
select count(*)
from project;

-- What's the earliest project start_date?
-- Expected: 2017-09-23
select min(start_date)
from project;

-- What's the latest employee start_date?
-- Expected: 2020-08-25
select max(start_date)
from project;

-- Count customers per city.
-- Expected: 88 Rows
select city, count(*) people
from customer
group by city;

-- Count customers per postal_code.
-- Expected: 84 Rows
select postal_code, count(*) people
from customer
group by postal_code;

-- Count employees per last_name.
-- Expected: 3 Rows
select last_name, count(*) employees
from employee
group by last_name;

-- Count the number of projects per city.
-- Expected: 88 Rows
select c.city, count(*) projects
from customer c
inner join project p on p.customer_id = c.customer_id
group by c.city;


-- Count the number of projects per city.
-- Sort by the count descending and select the top 10 rows.
-- Expected: 10 Rows
select c.city, count(*) projects
from customer c
inner join project p on p.customer_id = c.customer_id
group by c.city
order by count(*) desc
limit 10;


-- Which postal_code has the most projects?
-- Expected: M3H
select c.postal_code, count(*) projects
from customer c
inner join project p on p.customer_id = c.customer_id
group by c.postal_code;

-- Count the number of projects per start_date year.
-- Expected: 4 Rows
select year(p.start_date)"Year" , count(*) '# of projects'
from project p
group by year(p.start_date);

-- Count the number of employees per project in the M3H postal_code.
-- Group by project_id, sort by count descending.
-- Expected: 39 Rows
select p.project_id, count(*)
from project p
inner join customer c on p.customer_id = c.customer_id
inner join project_employee pe on pe.project_id = p.project_id
inner join employee e on e.employee_id = pe.employee_id
where c.postal_code = "M3H"
group by p.project_id;


-- Calculate the total cost per project in the 'M3H' postal_code.
-- (Hint: sum a calculation)
-- Expected: 39 Rows
select *
from item;

select  p.project_id, sum(pi.quantity * i.price_per_unit) total
from project p 
inner join project_item pi on pi.project_id = p.project_id
left outer join item i on i.item_id = pi.item_id
inner join customer c on p.customer_id = c.customer_id
where c.postal_code = "M3H"
group by p.project_id;

-- What's the most expensive project in the 'M3H' postal_code?
-- Expected: 18828.00 48

-- How many projects did each employee work on?
-- Expected: 33 Rows
select e.first_name, e.last_name, count(*)
from employee e
left outer join project_employee pe on pe.employee_id = e.employee_id
inner join project p on p.project_id = pe.project_id
group by e.first_name, e.last_name;

-- How many employees worked on more than 140 projects?
-- Expected: 10 Rows
select e.first_name, e.last_name, count(*)
from employee e
left outer join project_employee pe on pe.employee_id = e.employee_id
inner join project p on p.project_id = pe.project_id
group by e.first_name, e.last_name
having count(*) > 140;

-- How many projects cost more than $20,000?
-- Expected: 55 Rows
select  p.project_id, sum(pi.quantity * i.price_per_unit) total
from project p 
inner join project_item pi on pi.project_id = p.project_id
left outer join item i on i.item_id = pi.item_id
inner join customer c on p.customer_id = c.customer_id
group by p.project_id
having sum(pi.quantity * i.price_per_unit) > 20000;

-- Across all projects, what are the total costs per item?
-- Select the item name and sum.
-- Sort by the sum desc;
-- Expected: 18 Rows
select i.name, sum(pit.quantity * i.price_per_unit) total
from project p
left outer join project_item pit on pit.project_id = p.project_id
inner join item i on i.item_id = pit.item_id
group by i.name
order by sum(pit.quantity * i.price_per_unit) desc;

-- Across all projects, what are the total costs per item category?
-- Select the category name and sum.
-- Sort by the sum desc;
-- Expected: 7 Rows
select c.name, sum(pit.quantity * i.price_per_unit) total
from project p
left outer join project_item pit on pit.project_id = p.project_id
inner join item i on i.item_id = pit.item_id
inner join category c on i.category_id = c.category_id
group by c.name
order by sum(pit.quantity * i.price_per_unit) desc;

-- What's the average 'Standard Labor' cost per city?
-- Expected: 88 Rows

-- Challenge: Which customer has the first project of 2019?
-- (Requires a subquery.)
-- Expected: Starkie 2019-01-01