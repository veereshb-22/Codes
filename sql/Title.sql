-- Creating a table
create table Title(title_id varchar(20) primary key not null,title_workerid integer,
	title_workertitle varchar(20),title_affectedfrom timestamp);

--Insert data into table
insert into Title values('T01',1,'Manager','2016-02-20');
insert into Title values('T02',2,'Executive','2016-02-20');
insert into Title values('T03',8,'Executive','2016-06-11');
insert into Title values('T04',5,'Manager','2016-06-11');
insert into Title values('T05',4,'Asst.Manager','2016-06-11');
insert into Title values('T06',7,'Executive','2016-06-11');
insert into Title values('T07',6,'Lead','2016-06-11');
insert into Title values('T08',3,'Lead','2016-06-11');