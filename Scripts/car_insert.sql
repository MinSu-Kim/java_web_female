
-- 브랜드 B+넘버링
INSERT INTO proj_rentcar.brand
(`no`, name)
values
("B1",'hyundai'),
("B2", 'kia'),
("B3",'bmw');



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
(code)
values
('gasolin'),
('diesel'),
('lpg'),
('hybrid'),
('electric');



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
('V001', '모닝','wh', 'auto', 'B2', 'S1' ,74000 ,41400, 53300, 59200, 74000,'gasolin', 0,0),
('V002', '아반떼AD','bk', 'auto', 'B1','S2', 108000,60500,77800, 86400, 108000,'gasolin', 0,0),
('V003', 'bmw2','bk', 'auto', 'B3', 'S2',204000,114200, 146900,163200,204000,'diesel', 0,0),
('V004', '프라이드','wh', 'stick', 'B2','S2',118000 ,66100, 85000, 94400, 118000,'lpg', 0,0),
('V005', 'LF쏘나타','wh', 'auto', 'B1', 'S3',155000, 86800, 111600,124000,155000 ,'gasolin', 0,0),
('V006', 'bmw3','wh', 'auto', 'B3', 'S3',266000, 149000, 191500, 212800,266000, 'diesel', 0,0);

INSERT INTO proj_rentcar.car_model
(car_code, name, color, gear, brand, cartype, basic_charge, hour6, hour10, hour12, hour_else, fuel_code, is_rent, rent_cnt)
values
('V007', '그랜저','wh', 'auto', 'B1', 'S4' ,210000 ,117600, 151200, 168000, 210000,'gasolin', 0,0),
('V008', '스포티지','bk', 'auto', 'B2','S5', 153000,85700,110200, 122400, 153000,'gasolin', 0,0);




INSERT INTO proj_rentcar.add_option
(option_id, car_code)
values
(1, 'V001'),
(1, 'V002'),
(2, 'V002'),
(1, 'V003'),
(2, 'V003'),
(3, 'V003');













