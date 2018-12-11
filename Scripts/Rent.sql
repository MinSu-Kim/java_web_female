
-- Insurance
select * from insurance;

-- S1: 경차, S2: 소형, S3: 중형, S4: 대형, S5: 승합, S6: SUV
select * from car_type;

-- I000 : 보험가입X, S7: 외제차
insert into insurance values
('I000', 'S0', 0), ('I001', 'S1', 6500), ('I002', 'S2', 6500),
('I003', 'S3', 11000), ('I004', 'S4', 22000), ('I005', 'S5', 22100),
('I006', 'S6', 14000), ('I007', 'S7', 45000);

select * from rent;

-- 대여코드, 대여 시작 날짜/시간, 대여 반납 날짜/시간, 반납여부(0: 반납X/false), 대여비용, 차량코드, 고객코드, 보험코드, 이벤트할인율, 옵션비용 
insert into rent values
('R001', '2018-12-01', '12:00:00', '2018-12-02', '12:00:00', 0, 74000, 'V001', 'C001', 'I000', null, 0);

select * from customer where name = '김영희';

insert into c