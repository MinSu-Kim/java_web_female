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


-- rent insert 후 동작

-- 1. customer에 대여횟수 1 증가
-- CustomerMapper.updateCustomerRentCnt(Customer customer);
update customer
set rent_cnt = rent_cnt + 1
where code=custom_code;


-- 2. customer의 대여횟수에 따른 등급 조정
-- 	CustomerMapper.selectGradeCustomer(Customer customer);
select g.code from customer c , grade g where (rent_cnt between g.g_losal and g.g_hisal) and c.code='C005';

-- CustomerMapper.updateCustomerGrade(Customer customer); 
update customer set grade_code = gcode where code = custom_code;



-- 3. 해당 대여된 자동차(car_model에서 대여중으로 변경)
-- CarModelMapper.updateCarModelRent(CarModel carModel)
update car_model set is_rent = 1, rent_cnt = rent_cnt + 1 where car_code = carCode;



-- 4. 고객 이벤트 사용유무(가장 높은 것으로) 고객이 가지고 있는 이벤트 , 등급에 따른 이벤트 e_code = EVT1, EVT2, G002, G003
-- CustomEventMapper.updateSetUse(Rent rent)
update custom_event set is_use = 1
where custom_code = 'C005' and event_code = 'EVT1';


-- 5. rent 정보 추가
-- Rent 클래스에서 int e_rate 를 String eCode;로 수정(고객이벤트 및 등급에 따른 이벤트적용인지 구분)
-- eCode에 저장되는  정보는 EVT1(첫가입 3%) EVT2(생일 5%), 
--               등급에 따를 경우 G001(0%), G002(5%), G003(10%) 
-- eCode 변경에 따라 RentPanel에서 setSelectedCustomer()부분과 getTotalRentPrice() 수정 
-- RentMapper.insertRent() 에서 e_rate-> eCode로 수정하고 RentMapperImpl에서 1~5번 트랜잭션 적용
