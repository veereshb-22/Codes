-- Print all Data
`select * from worker;

-- Fetch Worker First name as <WORKER_NAME>
	select worker_firstname as WORKER_NAME 
		from Worker;

-- Print Name of Worker in lowercase 
	select upper(worker_firstname) 
		from Worker;

--Fetch Unique Department name
	select distinct worker_department 
		from Worker;

--Print 3 character of firstname in Worker column
	/*  if substring is 0,3 only two values
	if substring is 1,3 three values*/
	select substring(worker_firstname,0,3)
		from Worker;
	select substring(worker_firstname,1,3)
		from Worker;

-- Fetch position of 'a'  from firstname where firstname is Amitabh’
	select position( 'a' in worker_firstname ) as Postion_of_a
		from Worker where worker_firstname ='Amithab';

-- To remove space between the names 
	select rtrim(worker_firstname) 
		from worker;

--to remove space in department the names are  and unique value
	select distinct rtrim(worker_department)
		from worker;

-- to print unique department as well as their lenght
	select distinct worker_department ,length(worker_department)
		from Worker;

-- to replace 'a' with 'A' in firstname
	select replace(worker_firstname,'a','A') 
		from Worker;

-- Write first and last name workers into one column
	select (worker_firstname || ' '|| worker_lastname) as EmployeeName 
		from worker;
	select concat(worker_firstname, ' ', worker_lastname) as EMployeeName 
		from Worker;

--Worker details  in ascending order
	select * 
		from Worker 
		order by worker_firstname;

--Worker details  in Descending order
	select *
		from Worker
		order by worker_firstname desc;

-- Details of worker name starting with “Vipul” and “Satish”
	select * 
		from Worker
		where worker_firstname in('Vipul','Satish');

-- Details of worker name not  starting with “Vipul” and “Satish”
	select * 
		from Worker
		where worker_firstname not  in('Vipul','Satish');

-- Details of Worker whose depatment is Admin
	select * 
		from Worker 
		where worker_department='Admin';

--Details of worker firstname contains 'a'in it 
	select * 
		from worker
		where worker_firstname like '%a%';

--Details of worker firstname ends with 'a'in it 
	select * 
		from worker 
		where worker_firstname like '%a';

--Details of worker name ends with h in sixth posotion
	select * 
		from worker 
		where worker_firstname like '_____h';

--Details ofworker salary  lies between 100000 and 500000.
	select * 
		from worker 
		where salary between 100000 and 500000;

--Details of worker joined in Febraury 2014
	select * 
		from Worker 
		where  worker_dateofjoining between '2014-02-01' and '2014-02-28';

--Count Adim in workers 
	select worker_department ,count(*) 
		from Worker where worker_department='Admin' 
		group by worker_department;

-- Worker Details salary  >= 50000 and <= 100000.
	select * 
		from Worker 
		where salary>= 50000 and salary <= 100000;

--Dispaly number of worker in each depatment with desc order
	select  worker_department ,count(*) as Number_of_Workers 
		from Worker 
		group by worker_department;

--Display Employee who is a manger
	select w.*, t.title_workertitle 
		from Worker w,Title t 
		where worker_id=title_workerid and title_workertitle='Manager';


--fetch duplicate records  
	select title_workertitle, title_affectedfrom, count(*) 
		from Title
		group by title_workertitle, title_affectedfrom
		having count(*) > 1;
		select * from worker;

--details of worker in odd number of rows
	select *
		from Worker
		where mod (worker_id, 2) <> 0;

--details of worker in even number of rows
	select * 
		from Worker
		where mod (worker_id, 2) = 0;

--details of worker in clone
	select * into CloneWorker 
		from worker;
	select * 
		from CloneWorker;

-- use of intersection
	select * from Worker 
		intersect 
		select * from CloneWorker;

-- show current date and time
	select now();

-- Limit of table
	select * 
		from Worker salary limit 5;

	select worker_department, count(worker_department) as total 
		from worker
		group by worker_department order by 
		having count(worker_department)>0
		order by total

-- Wrokers having same salary 
	select distinct w.worker_id,w.worker_firstname, w.worker_lastname 
		from worker w,worker w1 
		where w.worker_id !=w1.worker_id order by w.worker_id;

--second largest salary
	select max(salary) from worker where salary not in(select max(salary) from Worker) 
		
--  Query to find 5th largest value without limit
	select salary 
		from Worker W1
		where 4 = (select  count( distinct ( W2.salary ) )
		from Worker W2
		where W2.salary >= W1.salary);

-- Query to take two rows same
	select * from Worker where worker_department='HR'
	union all
	select w.* from Worker w where w.worker_department='HR'
		
-- Number of department
	select worker_department, count(*) as NumberofWorker 
		from worker 
		group by worker_department ;       

-- Last Workerid
	select worker_id 
		from Worker
		where worker_id=(select max(worker_id) 
			from Worker)
	
-- To find nth element ir for 7 th element write 6 i.e(n-1)
	select  Salary
		from Worker W1
		where 6 = (select count(distinct ( W2.Salary ) )
		from Worker W2
		where W2.Salary >= W1.Salary);

--Worker with max salary
	select worker_department, max(salary) 
		from worker 
		group by worker_department;

-- Fetch maximum 3 salary worker
	select * from worker order by salary desc limit 3

-- Fetch last 3 least salary 
	select * from worker order by salary limit 3

-- Fetch Half of worker
	select *
		from Worker
		where worker_id <=(select count(*)/2 from Worker)
		order by worker_id;

--salaty paid to department 
	select worker_department,sum(salary)
		from worker
		group by worker_department
		
--Fetch highest paid worker
		select worker_firstname,max(salary) 
			from worker 
			where salary=(select max(w.salary) from worker w)
			group by worker_firstname
		
-- Operation
	update Worker set salary=salary+5000
		where salary <100000;
		select * from worker order by worker_id;
