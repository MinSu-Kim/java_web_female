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


select *
from customer;

insert into customer(code, Id, passwd, Name, address, phone, dob, email)
		values('c015','psw2701', password('aggarg54'), '박수완', '대구', '010-1234-5656', '1977-01-02', 'psw2701@naver.com');

desc customer;

select * from custom_event;

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

