select code, name, t_grant as tGrant from title where code='T001';


-- 3이면 브론즈, 7이면 실버, 11이상은 골드 	
select c.Name, l.grade, c.rent_cnt
from customer c , level l 
where c.rent_cnt between l.g_losal and l.g_hisal 
and c.code = 'C008';

select code, name, phone, passwd, t_code as tCode from employee where code = 'E001';

SELECT * FROM post;

select zipcode, sido, sigungu, eupmyeon, doro, building1, building2
from post;

select code, name, rate from grade
		where code='G001';
select *
from customer;

insert into customer(code, Id, passwd, Name, address, phone, dob, email)
		values('c015','psw2701', password('aggarg54'), '박수완', '대구', '010-1234-5656', '1977-01-02', 'psw2701@naver.com');

desc customer;

select * from employee;

select c.code, id, passwd, c.name, address, phone, dob, email, event_code, is_use, e.name, e.rate
from customer c join custom_event ce on c.code=ce.custom_code join event e on ce.event_code=e.code;

select code, Id, Name, address, phone, dob, email, emp_code, license, grade_code, rent_cnt
from customer
where Id = 'asd132' and passwd = password('rootroot');

select code, name, phone, passwd, t_code as tCode 
from employee
where code='E001';

select c.code, Id, c.Name, address, phone, dob, email, emp_code, license, grade_code, rent_cnt, is_use, e.name, e.rate
from customer c join custom_event ce on c.code = ce.custom_code join event e on ce.event_code = e.code
where id = 'asd132' and passwd =password('rootroot');


select code, name, phone, passwd, t_code as tCode 
from employee
where code='E001' and passwd = password('rootroot');

select event_code, custom_code, is_use, code, name, rate 
from custom_event ce join event e on ce.event_code = e.code
where custom_code='C001';

select c.code, Id, passwd, c.Name, address, phone, dob, email, emp_code, license, grade_code, rent_cnt,
       event_code, custom_code, is_use, e.code, e.name, rate 
from customer c join custom_event ce on c.code = ce.custom_code join event e on ce.event_code = e.code
where c.code = 'C001';

select * from custom_event;

select * from event;

select event_code, custom_code, is_use, code, name, rate 
from custom_event ce join event e on ce.event_code = e.code
where custom_code='C001';

select *
from customer c join custom_event ce on c.code = ce.custom_code
where c.code = 'C001';

-- 비밀번호 길이 확인
select length(password('root123345')) from dual;

-- 비밀번호가 같은지 확인
select password('rootroot') = password('rootroot1') from dual;

select * from event;
select * from custom_event;
select * from customer;


desc customer;

select * from grade;

select * from `level`;
select * from grade;


/*
DROP PROCEDURE IF EXISTS update_customer_grade;
DELIMITER $$
CREATE PROCEDURE update_customer_grade (in custom_code char(4))   
begin
    declare gcode char(4);   
   
    update customer
    set rent_cnt = rent_cnt + 1
    where code=custom_code;
   
    select g.code into gcode
	from customer c , grade g
	where (rent_cnt between g.g_losal and g.g_hisal) and c.code=custom_code;

	update customer
	set grade_code = gcode
	where code = custom_code;
end $$
DELIMITER ;
*/

call update_customer_grade('C007');

select grade_code, rent_cnt
from customer
where code = 'C007';
/*
select g.code
from customer c , grade g
where (rent_cnt between g.g_losal and g.g_hisal) and c.code='C007';

update customer
set grade_code = '아래 select 한값'
where code = 'C007' -- '고객코드';
*/


select grade_code from customer where code='C007';

select * from grade;

insert into grade(code, name, g_losal, g_hisal, rate) values('G007', 'xxx', g_losal=?, g_hisal=?, ?)

desc grade;

select g.name, g.code
from customer c , grade g
where (rent_cnt between g.g_losal and g.g_hisal) and c.code='C007';


select c.code, Id, c.Name, address, phone, dob, email, emp_code, license, grade_code, rent_cnt, is_use, e.name, e.rate
from customer c join custom_event ce on c.code = ce.custom_code join event e on ce.event_code = e.code
where id = 'asd132' and passwd =password('rootroot');

delete from custom_event
where custom_code = 'C009';

delete from customer
where code = 'C009';

select * from custom_event
where custom_code = 'C005';

start transaction;
delete from custom_event
where custom_code = 'C008';
delete from customer
where code = 'C008';
COMMIT;



delete from customer
where code = 'C008';

select * from customer;

select * from event;

select * from custom_event;

delete from custom_event
where custom_code='C017';


select c.code, Id,c.Name, zip_code ,address, phone, dob, email, emp_code,	license, grade_code, g.name as gname, rent_cnt
from customer c join grade g on c.grade_code = g.code;

select * from customer;

update customer
		set code='C011', Id='swan2701', passwd=password('rootroot'), name='안녕', address='대구', 
		phone='010-5152-5468', dob='2018-12-13', email='acdv@naver.com', emp_code='E001', license='1종보통', grade_code='G001', 
		rent_cnt=2 
		where code='C011';


drop trigger tri_customer_delete;

delimiter $
create trigger tri_customer_delete
before delete on customer 
for each row
begin
	update rent
	set costomer_code = 'C000'
	where costomer_code = old.code;

	delete from custom_event
	where custom_code = old.code;
end
delimiter ;

select code, costomer_code from rent;

select * from custom_event
where custom_code = 'C001';

delete  from customer
where code = 'C001';

update rent
	set costomer_code = 'C000'
	where costomer_code ='C001';
	
select * from customer;

select  Id
from customer c 
where c.phone = '010-0000-7777'
and c.email = 'abc@gmail.com';

update customer c
set passwd = password('root1234')
where c.phone = '010-0000-7777' and c.email = 'abc@gmail.com';

select  Id
from customer c 
where c.phone = '010-0000-7777' and c.email ='abc@gmail.com';