-- Insurance
select * from insurance;

-- S1: 경차, S2: 소형, S3: 중형, S4: 대형, S5: 승합, S6: SUV
select * from car_type;
select * from car_option;

-- I000 : 보험가입X, S7: 외제차
/*insert into insurance values
('I000', 'S0', 0), ('I001', 'S1', 6500), ('I002', 'S2', 6500),
('I003', 'S3', 11000), ('I004', 'S4', 22000), ('I005', 'S5', 22100),
('I006', 'S6', 14000), ('I007', 'S7', 45000);*/

select * from rent;

-- 대여코드, 대여 시작 날짜/시간, 대여 반납 날짜/시간, 반납여부(0: 반납X/false), 대여비용, 차량코드, 고객코드, 보험코드, 이벤트할인율, 옵션비용 
/*
insert into rent values
('R001', '2018-12-01', '12:00:00', '2018-12-02', '12:00:00', 0, 74000, 'V001', 'C001', 'I000', null, 5000);

insert into rent values
('R002', '2018-12-03', '12:00:00', '2018-12-04', '12:00:00', 0, 108000, 'V002', 'C002', 'I000', null, 6000),
('R003', '2018-12-05', '12:00:00', '2018-12-06', '12:00:00', 0, 204000, 'V003', 'C003', 'I000', null, 17000);
*/

select * from customer where name = '김영희';
select * from car_model;

-- 렌트카옵션
/*INSERT INTO proj_rentcar.rentcar_options(option_id, code)
values (1, 'R001'), (2, 'R002'), (1, 'R003'), (2, 'R003'),(3, 'R003');*/

select * from rentcar_options;
select * from car_option;
select * from car_model;

-- 조인
select cm.name, color, gear, b.name, cartype, basic_charge, fuel_code, co.name, price
from car_model cm join brand b join rentcar_options ro join car_option co
on cm.brand = b.no and cm.car_code = ro.code and ro.option_id = co.no
where cartype = 'S2';

select cm.name, color, gear, b.name, cartype, basic_charge, fuel_code
from car_model cm join brand b on cm.brand = b.no
where cartype = 'S2';

select no, name, price from car_option;

select * from event;
select * from rent;

-- 회원 소유 이벤트
select concat('R', LPAD(count(*)+1,3,'0')) from rent;

from custom_event ce join event e on ce.event_code = e.code
where custom_code = 'C005';



-- 
DROP PROCEDURE proj_rentcar.update_customer_grade;

DELIMITER $$
CREATE PROCEDURE update_customer_grade (in custom_code char(4), in rent_code char(4))   
begin
    declare gcode char(4);
	declare ecode char(4);

   
    update customer
    set rent_cnt = rent_cnt + 1
    where code=custom_code;
   
    select g.code into gcode
	from customer c , grade g
	where (rent_cnt between g.g_losal and g.g_hisal) and c.code=custom_code;

	update customer
	set grade_code = gcode
	where code = custom_code;

    /*고객 이벤트 사용유무를 사용으로 변경하기 추가 */
	select rent.e_rate into ecode
	from rent where code = rent_code;

	update custom_event
	set is_use = 1
	where event_code = ecode and custom_code = custom_code;

end $$
DELIMITER ;

select rent_cnt, grade_code from customer where code = 'C001';
select * from custom_event where custom_code = 'C001';

call update_customer_grade('C001', 'R001');

select rent_cnt, grade_code from customer where code = 'C001';
select * from custom_event where custom_code = 'C001';


select c.code, ce.custom_code, ce.event_code
from customer c join custom_event ce on c.code = ce.custom_code 
where c.code = 'C001' and event_code='EVT1';

select costomer_code, rent.e_rate 
from rent where code = 'R001';

update custom_event
set is_use = 1
where event_code = 'EVT1' and custom_code = 'C001';

