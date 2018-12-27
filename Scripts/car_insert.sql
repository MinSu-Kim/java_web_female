use proj_rentcar;
-- 브랜드 B+넘버링
INSERT INTO proj_rentcar.brand
(`no`, name)
values
('B1','hyundai'),
('B2', 'kia'),
('B3','bmw'),
('b4', '포드');


-- 차종 S+넘버링
INSERT INTO proj_rentcar.car_type
(code , type)
values
('S1','경형'),
('S2','소형'),
('S3','중형'),
('S4','대형'),
('S5','승합'),
('S6','suv');



-- 차연료
INSERT INTO proj_rentcar.fuel
(no,code)
values
(1,'gasolin'),
(2,'diesel'),
(3,'lpg'),
(4,'hybrid'),
(5,'electric');



-- 옵션
INSERT INTO proj_rentcar.car_option
(`no`, name, price)
values
(1, 'seat', 5000), -- 카시트
(4, 'driver', 80000), -- 후방센서
(2, 'blackbox', 6000), -- 블랙박스
(3, 'sunroof', 6000);



-- 차모델 C
INSERT INTO proj_rentcar.car_model
(car_code, name, color, gear, brand, cartype, basic_charge, hour6, hour10, hour12, hour_else, fuel_code, is_rent, rent_cnt)
values
('V001', '모닝','wh', 'auto', 'B2', 'S1' ,74000 ,41400, 53300, 59200, 74000,'gasolin', 0,10),
('V002', '아반떼AD','bk', 'auto', 'B1','S2', 108000,60500,77800, 86400, 108000,'gasolin', 0,17),
('V003', 'bmw2','bk', 'auto', 'B3', 'S2',204000,114200, 146900,163200,204000,'diesel', 0,20),
('V004', '프라이드','wh', 'stick', 'B2','S2',118000 ,66100, 85000, 94400, 118000,'lpg', 0,7),
('V005', 'LF쏘나타','wh', 'auto', 'B1', 'S3',155000, 86800, 111600,124000,155000 ,'gasolin', 0,60),
('V006', 'bmw3','wh', 'auto', 'B3', 'S3',266000, 149000, 191500, 212800,266000, 'diesel', 0,41),
('V007', '그랜저','wh', 'auto', 'B1', 'S4' ,210000 ,117600, 151200, 168000, 210000,'gasolin', 0,68),
('V008', '스포티지','bk', 'auto', 'B2','S5', 153000,85700,110200, 122400, 153000,'gasolin', 0,14),
('V010', '레이','wh', 'auto', 'B2', 'S1' ,75000 ,42500, 53700, 59800, 75000,'gasolin', 0,11),
('V011', 'i30','bk', 'auto', 'B1','S2', 109000,61500,78800, 87400, 109000,'gasolin', 0,23),
('V012', 'SM6','wh', 'auto', 'B1', 'S3',184000,104200, 136900,163200,184000,'diesel', 0,54),
('V013', '제네시스EQ','gr', 'auto', 'B1','S4',208000 ,126100, 155000, 184400, 208000,'diesel', 0,23);

INSERT INTO proj_rentcar.car_model
(car_code, name, color, gear, brand, cartype, basic_charge, hour6, hour10, hour12, hour_else, fuel_code, is_rent, rent_cnt)
values
('V009', '익스플로러', 'gr', 'auto', 'B4', 'S6', 349000, 159400, 208300, 256400, 349000, 'diesel', 1, 2);
			

-- 박수완데이터					


-- 직원 insert					
insert into employee values ('E001', '나매니저', '010-1234-1234', password('rootroot')),
							('E002', '너일반사원', '010-5678-5678', password('abcdef'));
						
-- 등급 insert 
-- 등급 수정 처음부터 5%는 이상함....0->5->10으로 수정
insert into grade values ('G001', '브론즈',0,5, 0),
						('G002', '실버',6,10, 5),
						('G003', '골드',11,99999, 10),
						('G004', '블랙리스트',-1,-1, 0);
-- 고객 insert
insert into customer values ('C001', 'asd132', password('rootroot'), '김철수', '41456', '대구 서구', '010-0000-7777', '1988-04-18', 'abc@gmail.com' ,'E001' , '2종보통','G001', 1),
							('C002', 'qwer12', password('root1234'), '김영희', '25356','서울 서구', '010-1111-6666', '1972-09-11', 'qwer12@naver.com' ,'E002' , '1종보통','G001', 3),
							('C003', 'zxcv0523', password('asdfqwer'), '박철민', '15245','부산 동구', '010-2222-5555', '1961-10-25', 'zxcv0523@naver.com' ,'E002' , '1종보통','G002', 7),
							('C004', 'gtshv512', password('asdf1234'), '이수민', '84562','대전 서구', '010-3333-4444', '1987-05-27', 'gtshv512@gmail.com' ,'E001' , '2종보통','G002', 9),
							('C005', 'gstjsva12', password('zxcv4567'), '나영석', '75425','대구 수성구', '010-4444-3333', '1958-12-31', 'gstjsva12@daum.net' ,'E001' , '2종보통','G003', 21),
							('C006', 'aefvb238', password('qwer2573'), '강호동', '62589','대구 동구', '010-5555-2222', '1999-11-04', 'aefvb238@daum.com' ,'E002' , '1종보통','G001', 4),
							('C007', 'fkufj12', password('dhtdhd5645'), '김민정', '13265','울산 서구', '010-6666-1111', '1994-03-16', 'fkufj12@naver.com' ,'E002' , '2종보통','G004', -1),
							('C008', 'xbmhw325', password('aggarg54'), '김재영', '95625','서울 서초구', '010-7777-0000', '1977-01-02', 'xbmhw325@gmail.com' ,'E001' , '1종보통','G004', -1);
						
insert into customer values ('C000', 'C000', password('rootroot'), '탈퇴계정', '00000', '대구', '010-0000-0000', '1988-04-18', 'abc@gmail.com' ,null , null,null, null);
insert into customer values
('C009', 'xbmhw325',password('aggarg54'), '김영희','45236', '서울 서초구', '010-7777-0000', '1977-01-02', 'abc@gmail.com' ,'E001' , '1종보통','G004', -1);


-- event insert
insert into event values('EVT1', '첫가입', 3),
						('EVT2', '생일축하', 5);
					
insert into custom_event values
('EVT1','C001',0),
('EVT2','C001',0);

insert into custom_event values
('EVT1','C002',0),
('EVT1','C003',0),
('EVT1','C004',0),
('EVT1','C005',0),
('EVT2','C005',0),
('EVT1','C006',0),
('EVT2','C006',0),
('EVT1','C007',0),
('EVT1','C008',0),
('EVT1','C009',0);


-- 김보민

-- I000 : 보험가입X, S7: 외제차
insert into insurance values
('I000', 'S0', 0), ('I001', 'S1', 6500), ('I002', 'S2', 6500),
('I003', 'S3', 11000), ('I004', 'S4', 22000), ('I005', 'S5', 22100),
('I006', 'S6', 14000), ('I007', 'S7', 45000);

-- 대여코드, 대여 시작 날짜/시간, 대여 반납 날짜/시간, 반납여부(0: 반납X/false), 대여비용, 차량코드, 고객코드, 보험코드, 이벤트할인율, 옵션비용 
insert into rent values
('R001', '2018-12-01', '12:00:00', '2018-12-02', '12:00:00', 0, 74000, 'V001', 'C001', 'I000', 'EVT2', 5000);

insert into rent values
('R002', '2018-12-03', '12:00:00', '2018-12-04', '12:00:00', 0, 108000, 'V002', 'C002', 'I000', 'EVT2', 6000),
('R003', '2018-12-05', '12:00:00', '2018-12-06', '12:00:00', 0, 204000, 'V003', 'C003', 'I000', 'EVT1', 17000);

-- 렌트카옵션
INSERT INTO proj_rentcar.rentcar_options(option_id, code)
values (1, 'R001'), (2, 'R002'), (1, 'R003'), (2, 'R003'),(3, 'R003');

-- 보험있는 차량
INSERT INTO rent VALUES
('R004', '2018-12-18', '12:00:00', '2018-12-19', '12:00:00', 0, 210000, 'V007', 'C004', 'I004', 'EVT2', 11000);

-- 할인이 적용된 차량
insert into rent values
('R005', '2018-12-21', '12:00:00', '2018-12-20', '12:00:00', 0, 108000, 'V002', 'C005', 'I000', 'EVT2', 5000);


-- triger 적용 고객삭제시 외래키 무결성 위배를 해결하기 위해 렌트 고객코드를 C000로 변경하고 고객이 가지고 있는 이벤트를 삭제

drop trigger if exists tri_customer_delete;

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