-- Insurance
select * from insurance;

-- S1: 寃쎌감, S2: �냼�삎, S3: 以묓삎, S4: ���삎, S5: �듅�빀, S6: SUV
select * from car_type;
select * from car_option;

-- I000 : 蹂댄뿕媛��엯X, S7: �쇅�젣李�
/*insert into insurance values
('I000', 'S0', 0), ('I001', 'S1', 6500), ('I002', 'S2', 6500),
('I003', 'S3', 11000), ('I004', 'S4', 22000), ('I005', 'S5', 22100),
('I006', 'S6', 14000), ('I007', 'S7', 45000);*/

select * from rent;

-- ���뿬肄붾뱶, ���뿬 �떆�옉 �궇吏�/�떆媛�, ���뿬 諛섎궔 �궇吏�/�떆媛�, 諛섎궔�뿬遺�(0: 諛섎궔X/false), ���뿬鍮꾩슜, 李⑤웾肄붾뱶, 怨좉컼肄붾뱶, 蹂댄뿕肄붾뱶, �씠踰ㅽ듃�븷�씤�쑉, �샃�뀡鍮꾩슜 
/*
insert into rent values
('R001', '2018-12-01', '12:00:00', '2018-12-02', '12:00:00', 0, 74000, 'V001', 'C001', 'I000', null, 5000);

insert into rent values
('R002', '2018-12-03', '12:00:00', '2018-12-04', '12:00:00', 0, 108000, 'V002', 'C002', 'I000', null, 6000),
('R003', '2018-12-05', '12:00:00', '2018-12-06', '12:00:00', 0, 204000, 'V003', 'C003', 'I000', null, 17000);
*/

select * from customer where name = '源��쁺�씗';
select * from car_model;

-- �젋�듃移댁샃�뀡
/*INSERT INTO proj_rentcar.rentcar_options(option_id, code)
values (1, 'R001'), (2, 'R002'), (1, 'R003'), (2, 'R003'),(3, 'R003');*/

select * from rentcar_options;
select * from car_option;
select * from car_model;

-- 議곗씤
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

-- �쉶�썝 �냼�쑀 �씠踰ㅽ듃
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

    /*怨좉컼 �씠踰ㅽ듃 �궗�슜�쑀臾대�� �궗�슜�쑝濡� 蹂�寃쏀븯湲� 異붽� */
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

select * from rent;
select concat('R', LPAD(count(*)+1,3,'0')) from rent;

call update_customer_grade('C007');