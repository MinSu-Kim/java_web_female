desc department;
desc employee;


drop table employee;


CREATE TABLE `employee` (
  `empno` int(11) NOT NULL,
  `empname` varchar(20) NOT NULL,
  `title` varchar(10) DEFAULT NULL,
  `manager` int(11) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `dno` int(11) DEFAULT 1,
  PRIMARY KEY (`empno`),
  foreign key (dno) references department(deptno)
);

delimiter $
create trigger tri_department_delete
before delete on department
for each row 
begin 
	update employee
	set dno = 1
	where dno = old.deptno ;
end $
delimiter ;



drop trigger tri_department_delete;

insert into employee values (1, 'aa', 'xx', null, 1234, 2);

select * from employee;

delete from department
where deptno = 2;

select * from cus