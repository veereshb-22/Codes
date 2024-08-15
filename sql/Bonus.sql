-- Creating a table
create table Bonus(bonus_id varchar(20) primary key,bonus_workerid integer,
	bonus_bonusdate timestamp,bonus_bonusamount integer,foreign key(bonus_workerid)
	references Worker(worker_id));

--Insert data into table
insert into Bonus values('B01',1,'2016-02-20',5000);
insert into Bonus values('B02',2,'2016-06-11',3000);
insert into Bonus values('B03',3,'2016-02-20',4000);
insert into Bonus values('B04',1,'2016-02-20',4500);
insert into Bonus values('B05',2,'2016-06-11',3500);
