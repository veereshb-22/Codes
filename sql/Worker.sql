-- Creating a table
create table Worker(worker_id integer primary key,worker_firstname varchar(20) not null,
	worker_lastname varchar(20) not null ,salary integer, worker_dateofJoining timestamp not null,
	worker_department varchar(20));

--Insert data into table
insert into Worker values(001,'Monkia','Arora',100000,'2014-02-20 09:00:00','HR');
insert into Worker values(002,'Niharika','Verma',80000,'2014-06-11 09:00:00','Admin');
insert into Worker values(003,'Vishak','Singal',300000,'2024-02-20 09:00:00','HR');
insert into Worker values(004,'Amithab','Singh',500000,'2024-06-11 09:00:00','Admin');
insert into Worker values(005,'Vivek','Bhati',500000,'2014-02-20 08:00:00','Admin');
insert into Worker values(006,'Vipul','Diwan',200000,'2016-02-20 08:00:00','Account');
insert into Worker values(007,'Satish','Kumar',75000,'2015-02-20 08:00:00','Account');
insert into Worker values(008,'Geetika','Chaudan',90000,'2017-02-20 09:00:00','Admin');

