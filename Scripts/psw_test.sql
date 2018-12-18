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

select * from grade;
select * from employee;
select * from title;

/*select *
from post 
where doro ='태전로7길'
order by building1, building2;*/
select * from employee;
select * from title;



select * from event;
select * from custom_event;
select * from customer;

select * from `level`;
select * from grade;

-- 대여횟수에 따른 등급조정은 대여횟수가 변경될때마다 고객의 level을 체크하여 변경되도록 
select c.code, c.rent_cnt, l.grade
from customer c, `level` l
where rent_cnt between l.g_losal and l.g_hisal

select c.code, c.rent_cnt, c.grade_code, 
      (select grade_code 
       from customer c join `level` l on c. )
from customer c;

-- 로그인 했을 경우 해당 월과 일치할 경우 해당 고객에게 생일 쿠폰 지급 중복지급불가(event_code와 custom_code가 기본키) duplicate 발생(중복)
insert into custom_event 
select 'EVT2', 'C005' , 0 from customer 
where month(dob) = month(sysdate()) and code='C005';




select c.code, Id, passwd, c.Name, address, phone, dob, email, emp_code, license, grade_code, rent_cnt, event_code, custom_code, is_use, e.code, e.name, rate from customer c join custom_event ce on c.code = ce.custom_code join event e on ce.event_code = e.code where c.code = 'C005'; 

select code, name, g_losal, g_hisal, rate from grade
		where code='G001';
	
select * from grade;	

select *from employee;

