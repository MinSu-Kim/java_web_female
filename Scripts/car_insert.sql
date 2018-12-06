INSERT INTO proj_rentcar.brand
(`no`, name)
values
(1,'hyundai');

INSERT INTO proj_rentcar.brand
(`no`, name)
values
(2, 'kia'),
(3,'bmw');

-- 차종
INSERT INTO proj_rentcar.car_type
(code, brand_code, name)
values
('hy01', 1,'경형'),
('hy02',1,'소형'),
('hy03',1,'중형'),
('hy04',1,'대형'),
('hy05',1,'승합'),
('hy06',1,'suv');

INSERT INTO proj_rentcar.car_type
(code, brand_code, name)
values
('ki01', 2, '경형'), -- 기아
('ki02', 2, '소형'),
('ki03', 2, '중형'),
('ki04', 2, '대형'),
('ki05', 2, '승합'),
('ki06', 2, 'suv'),
('Bm01', 3, '경형'), -- bmw
('Bm02', 3, '소형'),
('Bm03', 3, '중형'),
('Bm04', 3, '대형'),
('Bm05', 3, '승합'),
('Bm06', 3, 'suv');


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



-- 차모델
-- s수동 a 자동 ,hy01:carType,ga연료 ,bk색상
INSERT INTO proj_rentcar.car_model
(car_code, name, color, gear, cartype_code, one_hour, six_hour, twelve_hour, twentyfour_hour, fuel_code, is_rent)
values
('a-ki01gawh', '모닝','wh', 'auto', 'ki01', 3200 ,13100, 18700, 23400, 'gasolin', 0),
('a-hy02gabk', 'i20','bk', 'auto', 'hy02', 3400, 13700, 19500, 24400, 'gasolin', 0),
('a-bm02debk', 'bmw2','bk', 'auto', 'bm02', 4500, 18200, 26100, 32600, 'diesel', 0);

INSERT INTO proj_rentcar.car_model
(car_code, name, color, gear, cartype_code, one_hour, six_hour, twelve_hour, twentyfour_hour, fuel_code, is_rent)
values
('s-ki02lpwh', '프라이드s','wh', 'stick', 'ki02', 3400 ,13700, 19500, 24400, 'lpg', 0),
('a-hy02gawh', '쏘나타','wh', 'auto', 'hy02', 4500, 18200, 26100, 32600, 'gasolin', 0),
('a-bm02dewh', 'bmw3','wh', 'auto', 'bm02', 5700, 22800, 32600, 40800, 'diesel', 0);



INSERT INTO proj_rentcar.add_option
(option_id, car_code)
values
(1, 'a-ki01gawh'),
(1, 'a-hy02gabk'),
(2, 'a-hy02gabk'),
(1, 'a-bm02debk'),
(2, 'a-bm02debk'),
(3, 'a-bm02debk');





