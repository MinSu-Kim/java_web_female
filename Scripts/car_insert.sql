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
('V009', '익스플로러', 'gr', 'auto', 'B4', 'S6', 349000, 159400, 208300, 256400, 349000, 'diesel', 0, 2),
('V010', '레이','wh', 'auto', 'B2', 'S1' ,75000 ,42500, 53700, 59800, 75000,'gasolin', 0,11),
('V011', 'i30','bk', 'auto', 'B1','S2', 109000,61500,78800, 87400, 109000,'gasolin', 0,23),
('V012', 'SM6','wh', 'auto', 'B1', 'S3',184000,104200, 136900,163200,184000,'diesel', 0,54),
('V013', '제네시스EQ','gr', 'auto', 'B1','S4',208000 ,126100, 155000, 184400, 208000,'diesel', 0,23),
('V014', '티볼리 에어','wh', 'auto', 'B1', 'S4' ,201000 ,117400, 151000, 178800, 201000,'gasolin', 0,10), -- 쌍용
('V015', '모하비','wh', 'auto', 'B2','S4', 218000,110500,157800, 176400, 218000,'gasolin', 0,17),
('V016', '니로EV','wh', 'auto', 'B2', 'S5',264000,134200, 166900,203200,264000,'diesel', 0,20),
('V017', '솔라티','bk', 'auto', 'B1','S5',288000 ,151000, 195000, 224400, 288000,'diesel', 0,7),
('V018', '그랜드 스타렉스','bl', 'auto', 'B1', 'S6',305000, 196800, 211600,254000,305000 ,'gasolin', 0,20),
('V019', 'SM6','wh', 'auto', 'B1', 'S3',266000, 149000, 191500, 212800,266000, 'diesel', 0,21),
('V020', '아반떼MD','gr', 'stick', 'B1', 'S2' ,140000 ,77600, 91200, 118000, 140000,'lpg', 0,68),
('V021', '올 뉴 소울','wh', 'stick', 'B2','S2', 123000,65700,80200, 102400, 123000,'hybrid', 0,8);
			

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
insert into customer values ('C000', 'C000', password('rootroot'), '탈퇴계정', '00000', '대구', '010-0000-0000', '1988-04-18', 'abc@gmail.com' ,null , null, null, null),
							('C001', 'asd132', password('rootroot'), '김철수', '42189', '대구광역시 수성구  지산로 45', '010-0000-7777', '1988-04-18', 'abc@gmail.com' ,'E001' , '2종보통','G001', 1),
							('C002', 'qwer12', password('root1234'), '이영희', '41456','대구광역시 북구  태전로 7', '010-1111-6666', '1972-09-11', 'qwer12@naver.com' ,'E002' , '1종보통','G001', 3),
							('C003', 'zxcv0523', password('asdfqwer'), '박철민', '42770','대구광역시 달서구  월배로 16', '010-2222-5555', '1961-10-25', 'zxcv0523@naver.com' ,'E002' , '1종보통','G002', 7),
							('C004', 'gtshv512', password('asdf1234'), '이수민', '42900','대구광역시 달성군 하빈면 달구벌대로 77', '010-3333-4444', '1987-05-27', 'gtshv512@gmail.com' ,'E001' , '2종보통','G002', 9),
							('C005', 'gstjsva12', password('zxcv4567'), '나영석', '42677','대구광역시 달서구  당산로 36', '010-4444-3333', '1958-12-31', 'gstjsva12@daum.net' ,'E001' , '2종보통','G003', 21),
							('C006', 'aefvb238', password('qwer2573'), '강호동', '41238','대구광역시 동구  효목로 5 - 4', '010-5555-2222', '1999-11-04', 'aefvb238@daum.com' ,'E002' , '1종보통','G001', 4),
							('C007', 'fkufj12', password('dhtdhd5645'), '김민정', '41086','대구광역시 동구  금강로 8', '010-6666-1111', '1994-03-16', 'fkufj12@naver.com' ,'E001' , '2종보통','G002', 10),
							('C008', 'xbmhw325', password('aggarg54'), '김재영', '41529','대구광역시 북구  복현로 5', '010-1248-5454', '1977-01-02', 'xbmhw325@daum.com' ,'E002' , '1종보통','G001', 5),
							('C009', 'xzcdz',password('abafkr'), '김영희','41857', '대구광역시 서구  서대구로 9', '010-3638-2542', '1977-05-02', 'xzcdz@gmail.com' ,'E001' , '1종보통','G004', -1),
							('C010', 'tuyjjey78645',password('gburiab15'), '최수정','41406', '대구광역시 북구  구리로 17', '010-3638-7868', '1977-12-02', 'tuyjjey78645@naver.com' ,'E001' , '1종보통','G002', 7),
							('C011', 'trdhgnchc45',password('agareag55'), '강고은','42137', '대구광역시 수성구  희망로 91', '010-2545-3634', '1977-03-02', 'trdhgnchc45@daum.com' ,'E002' , '2종보통','G001', 4),
							('C012', 'stgrhs351',password('wefaf1231'), '이보람','41012', '대구광역시 동구  내동로 26 - 9', '010-1235-2528', '1977-06-02', 'stgrhs351@gmail.com' ,'E001' , '1종보통','G002', 8),
							('C013', 'tyjdty825',password('adgrea5213'), '박수정','42479', '대구광역시 남구  대명로 29', '010-2825-5456', '1977-11-02', 'tyjdty825@naver.com' ,'E001' , '2종보통','G003', 13),			
							('C014', 'tydjlv15o',password('tetrh15684'), '최성은','41934', '대구광역시 중구  약령길 76', '010-4587-1455', '1977-01-02', 'tydjlv15o@daum.com' ,'E002' , '1종보통','G002', 9),
							('C015', 'uktf4512',password('ikutl5648'), '최영민','42187', '대구광역시 수성구  지범로 21', '010-5575-3522', '1977-03-02', 'uktf4512@naver.com' ,'E001' , '2종보통','G001', 3),
							('C016', 'sdtsf3251',password('koyljm656'), '이단아','41706', '대구광역시 서구  달서천로 66', '010-1452-2563', '1977-08-02', 'sdtsf3251@daum.com' ,'E002' , '1종보통','G004', -1),
							('C017', 'retyu423',password('ertytr665'), '박대성','41044', '대구광역시 동구  해동로 9', '010-4785-5896', '1977-09-02', 'retyu423@naver.com' ,'E001' , '2종보통','G002', 6),
							('C018', 'hjrfkn5646',password('wert354'), '도주호','41594', '대구광역시 북구  침산로 31', '010-2575-6353', '1977-12-02', 'hjrfkn5646@naver.com' ,'E002' , '1종보통','G003', 20),
							('C019', 'uyjym231568',password('ukikmk544'), '도경수','41812', '대구광역시 서구  큰장로 35', '010-1456-4534', '1977-04-02', 'uyjym231568@gmail.com' ,'E001' , '1종보통','G001', 2),
							('C020', 'jtysgf891',password('ncyhs12513'), '박현빈','41039', '대구광역시 동구  팔공로 15', '010-1237-7653', '1977-07-02', 'jtysgf891@naver.com' ,'E002' , '2종보통','G002', 7),
							('C021', 'uyjtyd8564',password('qewrref45'), '박신혜','42443', '대구광역시 남구  대덕로 201', '010-8676-9686', '1977-10-02', 'uyjtyd8564@daum.com' ,'E002' , '1종보통','G001', 1),
							('C022', 'jtydjtyd564',password('ertwre354'), '백종원','41752', '대구광역시 서구  북비산로 48 - 2', '010-4538-8653', '1977-05-02', 'jtydjtyd564@gmail.com' ,'E001' , '1종보통','G001', 2),
							('C023', 'uytuil789',password('etryetr154'), '이만기','41444', '대구광역시 북구  관음동로 43', '010-1245-8653', '1977-06-02', 'uytuil789@gmail.com' ,'E001' , '2종보통','G003', 40),
							('C024', 'uuykgh789534',password('rtyur4564'), '박선영','42841', '대구광역시 달서구  앞산순환로 248 ', '010-5868-4511', '1977-01-02', 'uuykgh789534@gmail.com' ,'E002' , '1종보통','G001', 3),
							('C025', 'uyhjtyd44',password('tyuityu4564'), '김영희','41490', '대구광역시 북구  매천로 5', '010-1155-3555', '1977-01-02', 'uyhjtyd44@daum.com' ,'E001' , '1종보통','G002', 8),
							('C026', 'lkhkhl4564',password('yuioyi123'), '김선주','41252', '대구광역시 동구  화랑로 15', '010-7447-5565', '1977-06-02', 'lkhkhl4564@naver.com' ,'E001' , '2종보통','G002', 9),
							('C027', 'zxcvzxcv456456',password('zxcvz153'), '황성수','42407', '대구광역시 남구  양지로 61', '010-6846-2255', '1977-07-02', 'zxcvzxcv456456@gmail.com' ,'E002' , '1종보통','G004', -1),
							('C028', 'qwerqwer123',password('xcvbxvcb51'), '박지영','42729', '대구광역시 달서구  와룡로 27', '010-1253-1564', '1977-08-02', 'qwerqwer123@naver.com' ,'E001' , '2종보통','G001', 4),
							('C029', 'tuygfku5413',password('cvbncbv21'), '박성원','42743', '대구광역시 달서구  송현로 88 ', '010-7845-5124', '1977-01-02', 'tuygfku5413@daum.com' ,'E002' , '2종보통','G004', -1),
							('C030', 'tuikgh',password('vbnmv15615'), '곽도원','42250', '대구광역시 수성구  월드컵로 2 - 50', '010-2415-2635', '1977-01-02', 'tuikgh@naver.com' ,'E002' , '1종보통','G001', 5),
					    	('C031', 'ilyi7964',password('bnmnb894'), '강아름','41499', '대구광역시 북구  노원로 9', '010-8520-2580', '1977-01-02', 'ilyi7964@naver.com' ,'E001' , '2종보통','G001', 4),
							('C032', 'tuio78685',password('qweqre4586'), '윤여정','42446', '대구광역시 남구  봉덕로 48', '010-7542-9562', '1977-04-02', 'tuio78685@gmail.com' ,'E002' , '2종보통','G004', -1),
							('C033', 'gikl564',password('wertwe48'), '조여정','41067', '대구광역시 동구  혁신대로 244', '010-0235-3125', '1977-01-02', 'gikl564@gmail.com' ,'E001' , '1종보통','G002', 6),				
							('C034', 'gikg4586',password('dazfdf484'), '이류식','41846', '대구광역시 서구  평리로 172', '010-1235-0000', '1977-09-02', 'gikg4586@gmail.com' ,'E002' , '1종보통','G001', 3),
							('C035', 'cuki151',password('zcvzsdz484'), '김준수','41434', '대구광역시 북구  대천로 3 - 17', '010-8512-7586', '1977-11-02', 'cuki151@daum.com' ,'E002' , '2종보통','G002', 10),
							('C036', 'sthsf15',password('qqwef8632'), '이단아','41922', '대구광역시 중구  태평로 2', '010-0100-3535', '1977-04-02', 'sthsf15@naver.com' ,'E001' , '1종보통','G003', 25),
							('C037', 'q43et',password('hthnnh15'), '박대성','42824', '대구광역시 달서구  송현로 52', '010-3355-6688', '1977-11-02', 'q43et@gmail.com' ,'E001' , '2종보통','G001', 2),
							('C038', 'uargk5131',password('ndhdn687461'), '도주호','42144', '대구광역시 수성구  청솔로 6', '010-7788-9988', '1977-03-02', 'uargk5131@gmail.com' ,'E001' , '1종보통','G003', 17),
							('C039', 'trja51',password('dfFdcv151'), '도경수','42719', '대구광역시 달서구  성서공단로 174 ', '010-4455-1115', '1977-04-02', 'trja51@gmail.com' ,'E001' , '1종보통','G001', 1),
							('C040', 'yueret5531',password('zdvfzg8789'), '박현빈','41541', '대구광역시 북구  연암공원로 14', '010-6320-7514', '1977-09-02', 'yueret5531@gmail.com' ,'E002' , '2종보통','G002', 6),
							('C041', 'twrstn156',password('sgfnhfn123'), '박신혜','42704', '대구광역시 달서구  성서서로 132 ', '010-2288-0425', '1977-10-02', 'twrstn156@gmail.com' ,'E001' , '1종보통','G002', 7),
							('C042', 'wty4615',password('jkurkg451'), '백종원','42679', '대구광역시 달서구  야외음악당로 38 ', '010-1234-3664', '1977-11-02', 'wty4615@naver.com' ,'E001' , '1종보통','G001', 3),
							('C043', 'utsd5456',password('kufyjfy7251'), '이만기','41078', '대구광역시 동구  경안로 750', '010-8944-6932', '1977-03-02', 'utsd5456@daum.com' ,'E002' , '2종보통','G003', 13),
							('C044', 'ewfarga121',password('q3ewfzea'), '박선영','41751', '대구광역시 서구  새방로 129', '010-5649-0000', '1977-04-02', 'ewfarga121@naver.com' ,'E001' , '1종보통','G002', 8),
							('C045', 'vfbf1541',password('xgfbht1515'), '김영희','42603', '대구광역시 달서구  선원로 7', '010-5164-1511', '1977-10-02', 'vfbf1541@naver.com' ,'E002' , '1종보통', 'G001', 1);
							

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

-- cartype이 경형인 차량들 S1
insert into rent values
('R047', '2018-03-03', '12:00:00', '2018-03-04', '12:00:00', 0, 74000, 'V001', 'C002', 'I000', 'EVT2', 5000),
('R048', '2018-03-03', '12:00:00', '2018-03-04', '12:00:00', 1, 75000, 'V010', 'C002', 'I000', 'EVT2', 0),
('R006', '2018-03-03', '12:00:00', '2018-03-04', '12:00:00', 0, 74000, 'V001', 'C003', 'I000', 'EVT2', 5000),
('R007', '2018-04-03', '12:00:00', '2018-04-04', '12:00:00', 0, 75000, 'V010', 'C002', 'I000', 'EVT2', 17000),
('R008', '2018-04-03', '12:00:00', '2018-04-04', '12:00:00', 0, 74000, 'V001', 'C002', 'I000', 'EVT2', 6000),
('R009', '2018-04-03', '12:00:00', '2018-04-04', '12:00:00', 0, 75000, 'V010', 'C004', 'I000', 'EVT2', 6000),
('R010', '2018-04-03', '12:00:00', '2018-04-04', '12:00:00', 0, 74000, 'V001', 'C001', 'I000', 'EVT2', 6000),
('R011', '2018-04-03', '12:00:00', '2018-04-04', '12:00:00', 1, 74000, 'V001', 'C002', 'I000', 'EVT2', 17000),
('R012', '2018-05-03', '12:00:00', '2018-05-04', '12:00:00', 0, 74000, 'V001', 'C005', 'I000', 'EVT2', 6000),
('R013', '2018-05-03', '12:00:00', '2018-05-04', '12:00:00', 0, 74000, 'V001', 'C002', 'I000', 'EVT2', 6000),
('R014', '2018-06-03', '12:00:00', '2018-06-14', '12:00:00', 0, 74000, 'V001', 'C007', 'I000', 'EVT2', 6000),
('R015', '2018-06-03', '12:00:00', '2018-06-12', '12:00:00', 0, 74000, 'V001', 'C002', 'I000', 'EVT2', 6000),
('R016', '2018-06-03', '12:00:00', '2018-06-05', '12:00:00', 1, 74000, 'V001', 'C009', 'I000', 'EVT2', 6000),
('R017', '2018-06-03', '12:00:00', '2018-06-21', '12:00:00', 0, 75000, 'V010', 'C002', 'I000', 'EVT2', 6000),
('R018', '2018-06-03', '12:00:00', '2018-06-05', '12:00:00', 0, 75000, 'V010', 'C009', 'I000', 'EVT2', 6000),
('R019', '2018-06-03', '12:00:00', '2018-06-08', '12:00:00', 0, 75000, 'V010', 'C002', 'I000', 'EVT2', 6000),
('R020', '2018-07-03', '12:00:00', '2018-07-10', '12:00:00', 1, 75000, 'V010', 'C002', 'I000', 'EVT2', 5000),
('R021', '2018-07-03', '12:00:00', '2018-07-05', '12:00:00', 1, 75000, 'V010', 'C002', 'I000', 'EVT2', 6000),
('R022', '2018-07-03', '12:00:00', '2018-07-06', '12:00:00', 0, 74000, 'V001', 'C001', 'I000', 'EVT2', 6000),
('R023', '2018-07-03', '12:00:00', '2018-07-07', '12:00:00', 0, 75000, 'V010', 'C002', 'I000', 'EVT2', 5000),
('R024', '2018-07-03', '12:00:00', '2018-07-08', '12:00:00', 0, 75000, 'V010', 'C003', 'I000', 'EVT2', 0),
('R025', '2018-07-03', '12:00:00', '2018-07-20', '12:00:00', 1, 75000, 'V010', 'C002', 'I000', 'EVT2', 6000),
('R026', '2018-07-03', '12:00:00', '2018-07-15', '12:00:00', 0, 75000, 'V010', 'C002', 'I000', 'EVT2', 6000),
('R027', '2018-08-03', '12:00:00', '2018-08-05', '12:00:00', 0, 74000, 'V001', 'C002', 'I000', 'EVT2', 6000),
('R028', '2018-08-03', '12:00:00', '2018-08-16', '12:00:00', 1, 75000, 'V010', 'C005', 'I000', 'EVT2', 0),
('R029', '2018-09-03', '12:00:00', '2018-09-05', '12:00:00', 0, 75000, 'V010', 'C002', 'I000', 'EVT2', 6000),
('R030', '2018-09-03', '12:00:00', '2018-09-05', '12:00:00', 0, 74000, 'V001', 'C002', 'I000', 'EVT2', 6000),
('R031', '2018-09-03', '12:00:00', '2018-09-20', '12:00:00', 1, 75000, 'V010', 'C006', 'I000', 'EVT2', 6000),
('R032', '2018-09-03', '12:00:00', '2018-09-08', '12:00:00', 0, 74000, 'V001', 'C002', 'I000', 'EVT2', 0),
('R033', '2018-10-03', '12:00:00', '2018-10-11', '12:00:00', 0, 75000, 'V010', 'C002', 'I000', 'EVT2', 5000),
('R034', '2018-10-03', '12:00:00', '2018-10-13', '12:00:00', 0, 75000, 'V010', 'C007', 'I000', 'EVT2', 6000),
('R035', '2018-10-03', '12:00:00', '2018-10-15', '12:00:00', 1, 74000, 'V001', 'C002', 'I000', 'EVT2', 6000),
('R036', '2018-10-03', '12:00:00', '2018-10-18', '12:00:00', 0, 75000, 'V010', 'C002', 'I000', 'EVT2', 5000),
('R037', '2018-11-03', '12:00:00', '2018-11-04', '12:00:00', 0, 75000, 'V010', 'C009', 'I000', 'EVT2', 0),
('R038', '2018-11-03', '12:00:00', '2018-11-08', '12:00:00', 1, 74000, 'V001', 'C002', 'I000', 'EVT2', 6000),
('R039', '2018-11-03', '12:00:00', '2018-11-13', '12:00:00', 0, 75000, 'V010', 'C010', 'I000', 'EVT2', 6000),
('R040', '2018-11-03', '12:00:00', '2018-11-17', '12:00:00', 0, 75000, 'V010', 'C002', 'I000', 'EVT2', 0),
('R041', '2018-11-03', '12:00:00', '2018-11-19', '12:00:00', 1, 74000, 'V001', 'C017', 'I000', 'EVT2', 6000),
('R042', '2018-11-03', '12:00:00', '2018-11-20', '12:00:00', 0, 75000, 'V010', 'C012', 'I000', 'EVT2', 17000),
('R043', '2018-11-03', '12:00:00', '2018-11-23', '12:00:00', 0, 74000, 'V001', 'C002', 'I000', 'EVT2', 6000),
('R044', '2018-12-03', '12:00:00', '2018-12-14', '12:00:00', 1, 74000, 'V001', 'C005', 'I000', 'EVT2', 6000),
('R045', '2018-12-03', '12:00:00', '2018-12-18', '12:00:00', 0, 74000, 'V001', 'C002', 'I000', 'EVT2', 5000),
('R046', '2018-12-03', '12:00:00', '2018-12-08', '12:00:00', 0, 74000, 'V001', 'C006', 'I000', 'EVT2', 0);

-- cartype이 소형인 차량들 S2
insert into rent values
('R049', '2018-03-03', '12:00:00', '2018-03-06', '12:00:00', 0, 108000, 'V002', 'C002', 'I000', 'EVT2', 11000),
('R050', '2018-03-03', '12:00:00', '2018-03-08', '12:00:00', 0, 204000, 'V003', 'C045', 'I000', 'EVT2', 6000),
('R051', '2018-04-03', '12:00:00', '2018-04-10', '12:00:00', 0, 118000, 'V004', 'C002', 'I000', 'EVT2', 0),
('R052', '2018-04-03', '12:00:00', '2018-04-14', '12:00:00', 0, 108000, 'V002', 'C003', 'I000', 'EVT2', 6000),
('R053', '2018-04-03', '12:00:00', '2018-04-24', '12:00:00', 0, 109000, 'V011', 'C021', 'I000', 'EVT2', 6000),
('R054', '2018-05-03', '12:00:00', '2018-05-05', '12:00:00', 0, 204000, 'V003', 'C002', 'I000', 'EVT2', 11000),
('R055', '2018-05-03', '12:00:00', '2018-05-15', '12:00:00', 0, 108000, 'V002', 'C002', 'I000', 'EVT2', 0),
('R056', '2018-05-03', '12:00:00', '2018-05-27', '12:00:00', 0, 109000, 'V011', 'C006', 'I000', 'EVT2', 6000),
('R057', '2018-06-03', '12:00:00', '2018-06-06', '12:00:00', 0, 204000, 'V003', 'C002', 'I000', 'EVT2', 6000),
('R058', '2018-06-03', '12:00:00', '2018-06-14', '12:00:00', 0, 123000, 'V021', 'C027', 'I000', 'EVT2', 17000),
('R059', '2018-06-03', '12:00:00', '2018-06-21', '12:00:00', 0, 118000, 'V004', 'C002', 'I000', 'EVT2', 6000),
('R060', '2018-06-03', '12:00:00', '2018-06-23', '12:00:00', 0, 108000, 'V002', 'C010', 'I000', 'EVT2', 6000),
('R061', '2018-07-03', '12:00:00', '2018-07-04', '12:00:00', 0, 109000, 'V011', 'C006', 'I000', 'EVT2', 5000),
('R062', '2018-07-03', '12:00:00', '2018-07-05', '12:00:00', 0, 204000, 'V003', 'C002', 'I000', 'EVT2', 17000),
('R063', '2018-07-03', '12:00:00', '2018-07-07', '12:00:00', 0, 108000, 'V002', 'C028', 'I000', 'EVT2', 6000),
('R064', '2018-08-03', '12:00:00', '2018-08-10', '12:00:00', 0, 118000, 'V004', 'C002', 'I000', 'EVT2', 6000),
('R065', '2018-08-03', '12:00:00', '2018-08-12', '12:00:00', 0, 204000, 'V003', 'C013', 'I000', 'EVT2', 17000),
('R066', '2018-08-03', '12:00:00', '2018-08-15', '12:00:00', 0, 123000, 'V021', 'C002', 'I000', 'EVT2', 6000),
('R067', '2018-08-03', '12:00:00', '2018-08-20', '12:00:00', 0, 109000, 'V011', 'C030', 'I000', 'EVT2', 6000),
('R068', '2018-09-03', '12:00:00', '2018-09-07', '12:00:00', 0, 118000, 'V004', 'C002', 'I000', 'EVT2', 5000),
('R069', '2018-09-03', '12:00:00', '2018-09-10', '12:00:00', 0, 204000, 'V003', 'C015', 'I000', 'EVT2', 6000),
('R070', '2018-10-03', '12:00:00', '2018-10-08', '12:00:00', 0, 123000, 'V021', 'C002', 'I000', 'EVT2', 11000),
('R071', '2018-10-03', '12:00:00', '2018-10-15', '12:00:00', 0, 108000, 'V002', 'C031', 'I000', 'EVT2', 6000),
('R072', '2018-10-03', '12:00:00', '2018-10-12', '12:00:00', 0, 204000, 'V003', 'C022', 'I000', 'EVT2', 6000),
('R073', '2018-10-03', '12:00:00', '2018-10-10', '12:00:00', 0, 123000, 'V021', 'C016', 'I000', 'EVT2', 6000),
('R074', '2018-10-03', '12:00:00', '2018-10-07', '12:00:00', 0, 118000, 'V004', 'C002', 'I000', 'EVT2', 6000),
('R075', '2018-11-20', '12:00:00', '2018-11-24', '12:00:00', 0, 123000, 'V021', 'C005', 'I000', 'EVT2', 17000),
('R076', '2018-11-05', '12:00:00', '2018-11-10', '12:00:00', 0, 204000, 'V003', 'C002', 'I000', 'EVT2', 6000),
('R077', '2018-11-06', '12:00:00', '2018-11-07', '12:00:00', 0, 123000, 'V021', 'C008', 'I000', 'EVT2', 11000),
('R078', '2018-11-02', '12:00:00', '2018-11-05', '12:00:00', 0, 118000, 'V004', 'C002', 'I000', 'EVT2', 6000),
('R079', '2018-12-03', '12:00:00', '2018-12-04', '12:00:00', 0, 204000, 'V003', 'C032', 'I000', 'EVT2', 17000),
('R080', '2018-12-04', '12:00:00', '2018-12-05', '12:00:00', 0, 123000, 'V021', 'C009', 'I000', 'EVT2', 6000),
('R081', '2018-12-01', '12:00:00', '2018-12-06', '12:00:00', 0, 123000, 'V021', 'C002', 'I000', 'EVT2', 5000),
('R082', '2018-12-08', '12:00:00', '2018-12-10', '12:00:00', 0, 109000, 'V011', 'C004', 'I000', 'EVT2', 6000),
('R083', '2018-12-24', '12:00:00', '2018-12-25', '12:00:00', 0, 118000, 'V004', 'C020', 'I000', 'EVT2', 17000),
('R084', '2018-12-20', '12:00:00', '2018-12-28', '12:00:00', 0, 204000, 'V003', 'C002', 'I000', 'EVT2', 6000);

-- cartype이 중형인 차량들 S3
insert into rent values
('R085', '2018-03-03', '12:00:00', '2018-03-06', '12:00:00', 0, 155000, 'V005', 'C003', 'I000', 'EVT2', 6000),
('R086', '2018-03-03', '12:00:00', '2018-03-10', '12:00:00', 0, 266000, 'V006', 'C020', 'I000', 'EVT2', 11000),
('R087', '2018-04-03', '12:00:00', '2018-04-10', '12:00:00', 0, 184000, 'V012', 'C002', 'I000', 'EVT2', 5000),
('R088', '2018-04-14', '12:00:00', '2018-04-15', '12:00:00', 0, 266000, 'V019', 'C002', 'I000', 'EVT2', 11000),
('R089', '2018-04-18', '12:00:00', '2018-04-20', '12:00:00', 0, 266000, 'V006', 'C018', 'I000', 'EVT2', 6000),
('R090', '2018-04-25', '12:00:00', '2018-04-29', '12:00:00', 0, 266000, 'V019', 'C002', 'I000', 'EVT2', 11000),
('R091', '2018-05-03', '12:00:00', '2018-05-06', '12:00:00', 0, 155000, 'V005', 'C003', 'I000', 'EVT2', 6000),
('R092', '2018-05-10', '12:00:00', '2018-05-13', '12:00:00', 0, 266000, 'V019', 'C020', 'I000', 'EVT2', 0),
('R093', '2018-05-15', '12:00:00', '2018-05-18', '12:00:00', 0, 266000, 'V006', 'C002', 'I000', 'EVT2', 6000),
('R094', '2018-05-17', '12:00:00', '2018-05-20', '12:00:00', 0, 184000, 'V012', 'C018', 'I000', 'EVT2', 5000),
('R095', '2018-05-26', '12:00:00', '2018-05-27', '12:00:00', 0, 108000, 'V019', 'C020', 'I000', 'EVT2', 11000),
('R096', '2018-05-28', '12:00:00', '2018-05-31', '12:00:00', 0, 155000, 'V005', 'C003', 'I000', 'EVT2', 6000),
('R097', '2018-06-03', '12:00:00', '2018-06-06', '12:00:00', 0, 184000, 'V012', 'C002', 'I000', 'EVT2', 0),
('R098', '2018-06-06', '12:00:00', '2018-06-14', '12:00:00', 0, 266000, 'V019', 'C002', 'I000', 'EVT2', 11000),
('R099', '2018-07-01', '12:00:00', '2018-07-06', '12:00:00', 0, 266000, 'V006', 'C020', 'I000', 'EVT2', 5000),
('R100', '2018-07-08', '12:00:00', '2018-07-10', '12:00:00', 0, 184000, 'V012', 'C002', 'I000', 'EVT2', 11000),
('R101', '2018-07-11', '12:00:00', '2018-07-15', '12:00:00', 0, 155000, 'V005', 'C002', 'I000', 'EVT2', 0),
('R102', '2018-07-20', '12:00:00', '2018-07-22', '12:00:00', 0, 266000, 'V019', 'C018', 'I000', 'EVT2', 11000),
('R103', '2018-07-27', '12:00:00', '2018-07-29', '12:00:00', 0, 266000, 'V019', 'C020', 'I000', 'EVT2', 6000),
('R104', '2018-08-10', '12:00:00', '2018-08-14', '12:00:00', 0, 266000, 'V006', 'C020', 'I000', 'EVT2', 11000),
('R105', '2018-08-13', '12:00:00', '2018-08-16', '12:00:00', 0, 266000, 'V019', 'C002', 'I000', 'EVT2', 6000),
('R106', '2018-08-17', '12:00:00', '2018-08-20', '12:00:00', 0, 184000, 'V012', 'C002', 'I000', 'EVT2', 11000),
('R107', '2018-08-25', '12:00:00', '2018-08-30', '12:00:00', 0, 184000, 'V012', 'C018', 'I000', 'EVT2', 5000),
('R108', '2018-09-01', '12:00:00', '2018-09-06', '12:00:00', 0, 266000, 'V019', 'C003', 'I000', 'EVT2', 0),
('R109', '2018-09-12', '12:00:00', '2018-09-15', '12:00:00', 0, 266000, 'V006', 'C020', 'I000', 'EVT2', 11000),
('R110', '2018-09-17', '12:00:00', '2018-09-19', '12:00:00', 0, 266000, 'V006', 'C002', 'I000', 'EVT2', 5000),
('R111', '2018-09-20', '12:00:00', '2018-09-22', '12:00:00', 0, 155000, 'V005', 'C003', 'I000', 'EVT2', 11000),
('R112', '2018-09-26', '12:00:00', '2018-09-30', '12:00:00', 0, 155000, 'V005', 'C018', 'I000', 'EVT2', 0),
('R113', '2018-10-03', '12:00:00', '2018-10-06', '12:00:00', 0, 155000, 'V005', 'C002', 'I000', 'EVT2', 6000),
('R114', '2018-10-15', '12:00:00', '2018-10-20', '12:00:00', 0, 155000, 'V005', 'C002', 'I000', 'EVT2', 11000),
('R115', '2018-11-03', '12:00:00', '2018-11-05', '12:00:00', 0, 184000, 'V012', 'C020', 'I000', 'EVT2', 0),
('R116', '2018-11-08', '12:00:00', '2018-11-13', '12:00:00', 0, 155000, 'V005', 'C002', 'I000', 'EVT2', 5000),
('R117', '2018-11-12', '12:00:00', '2018-11-15', '12:00:00', 0, 184000, 'V012', 'C018', 'I000', 'EVT2', 5000),
('R118', '2018-11-17', '12:00:00', '2018-11-20', '12:00:00', 0, 155000, 'V005', 'C020', 'I000', 'EVT2', 0),
('R119', '2018-11-20', '12:00:00', '2018-11-23', '12:00:00', 0, 266000, 'V006', 'C002', 'I000', 'EVT2', 5000),
('R120', '2018-12-03', '12:00:00', '2018-12-06', '12:00:00', 0, 266000, 'V006', 'C011', 'I000', 'EVT2', 11000);


-- cartype이 대형인 차량들 S4
insert into rent values
('R121', '2018-03-20', '12:00:00', '2018-03-22', '12:00:00', 0, 210000, 'V007', 'C003', 'I000', 'EVT2', 6000),
('R122', '2018-03-25', '12:00:00', '2018-03-28', '12:00:00', 0, 208000, 'V013', 'C005', 'I000', 'EVT2', 5000),
('R123', '2018-04-10', '12:00:00', '2018-04-12', '12:00:00', 0, 208000, 'V013', 'C013', 'I000', 'EVT2', 0),
('R124', '2018-04-15', '12:00:00', '2018-04-22', '12:00:00', 0, 201000, 'V014', 'C011', 'I000', 'EVT2', 16000),
('R125', '2018-05-01', '12:00:00', '2018-05-06', '12:00:00', 0, 208000, 'V013', 'C005', 'I000', 'EVT2', 5000),
('R126', '2018-05-16', '12:00:00', '2018-05-20', '12:00:00', 0, 210000, 'V007', 'C013', 'I000', 'EVT2', 0),
('R127', '2018-05-22', '12:00:00', '2018-05-24', '12:00:00', 0, 201000, 'V014', 'C011', 'I000', 'EVT2', 11000),
('R128', '2018-06-03', '12:00:00', '2018-06-06', '12:00:00', 0, 208000, 'V013', 'C005', 'I000', 'EVT2', 0),
('R129', '2018-07-01', '12:00:00', '2018-07-02', '12:00:00', 0, 208000, 'V013', 'C013', 'I000', 'EVT2', 11000),
('R130', '2018-07-18', '12:00:00', '2018-07-20', '12:00:00', 0, 201000, 'V014', 'C011', 'I000', 'EVT2', 0),
('R131', '2018-08-03', '12:00:00', '2018-08-06', '12:00:00', 0, 208000, 'V013', 'C005', 'I000', 'EVT2', 11000),
('R132', '2018-09-13', '12:00:00', '2018-09-16', '12:00:00', 0, 210000, 'V007', 'C011', 'I000', 'EVT2', 11000),
('R133', '2018-09-17', '12:00:00', '2018-09-20', '12:00:00', 0, 201000, 'V014', 'C005', 'I000', 'EVT2', 16000),
('R134', '2018-09-20', '12:00:00', '2018-09-22', '12:00:00', 0, 210000, 'V007', 'C013', 'I000', 'EVT2', 0),
('R135', '2018-09-26', '12:00:00', '2018-09-29', '12:00:00', 0, 210000, 'V007', 'C011', 'I000', 'EVT2', 5000),
('R136', '2018-10-01', '12:00:00', '2018-10-06', '12:00:00', 0, 208000, 'V013', 'C005', 'I000', 'EVT2', 11000),
('R137', '2018-10-07', '12:00:00', '2018-10-10', '12:00:00', 0, 201000, 'V014', 'C007', 'I000', 'EVT2', 0),
('R138', '2018-10-16', '12:00:00', '2018-10-18', '12:00:00', 0, 210000, 'V007', 'C011', 'I000', 'EVT2', 11000),
('R139', '2018-10-23', '12:00:00', '2018-10-25', '12:00:00', 0, 201000, 'V014', 'C005', 'I000', 'EVT2', 0),
('R140', '2018-10-28', '12:00:00', '2018-10-30', '12:00:00', 0, 208000, 'V013', 'C007', 'I000', 'EVT2', 11000),
('R141', '2018-11-01', '12:00:00', '2018-11-03', '12:00:00', 0, 208000, 'V013', 'C013', 'I000', 'EVT2', 16000),
('R142', '2018-11-05', '12:00:00', '2018-11-06', '12:00:00', 0, 210000, 'V007', 'C005', 'I000', 'EVT2', 0),
('R143', '2018-11-16', '12:00:00', '2018-11-17', '12:00:00', 0, 218000, 'V015', 'C011', 'I000', 'EVT2', 11000),
('R144', '2018-11-22', '12:00:00', '2018-11-24', '12:00:00', 0, 218000, 'V015', 'C011', 'I000', 'EVT2', 5000),
('R145', '2018-11-26', '12:00:00', '2018-11-29', '12:00:00', 0, 218000, 'V015', 'C013', 'I000', 'EVT2', 0),
('R146', '2018-12-01', '12:00:00', '2018-12-03', '12:00:00', 0, 208000, 'V013', 'C011', 'I000', 'EVT2', 11000),
('R147', '2018-12-14', '12:00:00', '2018-12-16', '12:00:00', 0, 218000, 'V015', 'C011', 'I000', 'EVT2', 0),
('R148', '2018-12-17', '12:00:00', '2018-12-19', '12:00:00', 0, 201000, 'V014', 'C007', 'I000', 'EVT2', 11000),
('R149', '2018-12-22', '12:00:00', '2018-12-24', '12:00:00', 0, 218000, 'V015', 'C007', 'I000', 'EVT2', 5000),
('R150', '2018-12-25', '12:00:00', '2018-12-27', '12:00:00', 0, 201000, 'V014', 'C011', 'I000', 'EVT2', 16000);

-- cartype이 승합인 차량 S5
insert into rent values
('R151', '2018-03-20', '12:00:00', '2018-03-22', '12:00:00', 0, 153000, 'V008', 'C011', 'I000', 'EVT2', 11000),
('R152', '2018-03-24', '12:00:00', '2018-03-26', '12:00:00', 0, 264000, 'V016', 'C002', 'I000', 'EVT2', 0),
('R153', '2018-04-10', '12:00:00', '2018-04-13', '12:00:00', 0, 288000, 'V017', 'C003', 'I000', 'EVT2', 6000),
('R154', '2018-04-12', '12:00:00', '2018-04-16', '12:00:00', 0, 288000, 'V017', 'C037', 'I000', 'EVT2', 0),
('R155', '2018-05-05', '12:00:00', '2018-05-18', '12:00:00', 0, 153000, 'V008', 'C002', 'I000', 'EVT2', 6000),
('R156', '2018-05-15', '12:00:00', '2018-05-17', '12:00:00', 0, 288000, 'V017', 'C037', 'I000', 'EVT2', 11000),
('R157', '2018-05-18', '12:00:00', '2018-05-22', '12:00:00', 0, 264000, 'V016', 'C011', 'I000', 'EVT2', 6000),
('R158', '2018-05-20', '12:00:00', '2018-03-24', '12:00:00', 0, 153000, 'V008', 'C003', 'I000', 'EVT2', 0),
('R159', '2018-06-14', '12:00:00', '2018-06-16', '12:00:00', 0, 288000, 'V017', 'C002', 'I000', 'EVT2', 6000),
('R160', '2018-06-21', '12:00:00', '2018-06-27', '12:00:00', 0, 153000, 'V008', 'C037', 'I000', 'EVT2', 11000),
('R161', '2018-06-23', '12:00:00', '2018-06-25', '12:00:00', 0, 264000, 'V016', 'C011', 'I000', 'EVT2', 6000),
('R162', '2018-06-27', '12:00:00', '2018-06-26', '12:00:00', 0, 288000, 'V017', 'C003', 'I000', 'EVT2', 0),
('R163', '2018-06-29', '12:00:00', '2018-06-30', '12:00:00', 0, 264000, 'V016', 'C037', 'I000', 'EVT2', 6000),
('R164', '2018-07-17', '12:00:00', '2018-07-21', '12:00:00', 0, 153000, 'V008', 'C003', 'I000', 'EVT2', 0),
('R165', '2018-07-23', '12:00:00', '2018-07-27', '12:00:00', 0, 288000, 'V017', 'C002', 'I000', 'EVT2', 11000),
('R166', '2018-08-13', '12:00:00', '2018-08-15', '12:00:00', 0, 153000, 'V008', 'C037', 'I000', 'EVT2', 6000),
('R167', '2018-09-17', '12:00:00', '2018-09-19', '12:00:00', 0, 288000, 'V017', 'C011', 'I000', 'EVT2', 0),
('R168', '2018-10-16', '12:00:00', '2018-10-22', '12:00:00', 0, 264000, 'V016', 'C042', 'I000', 'EVT2', 6000),
('R169', '2018-11-03', '12:00:00', '2018-11-05', '12:00:00', 0, 153000, 'V008', 'C003', 'I000', 'EVT2', 11000),
('R170', '2018-11-11', '12:00:00', '2018-11-13', '12:00:00', 0, 288000, 'V017', 'C042', 'I000', 'EVT2', 6000),
('R171', '2018-11-15', '12:00:00', '2018-11-19', '12:00:00', 0, 153000, 'V008', 'C037', 'I000', 'EVT2', 6000),
('R172', '2018-11-18', '12:00:00', '2018-11-20', '12:00:00', 0, 264000, 'V016', 'C011', 'I000', 'EVT2', 0),
('R173', '2018-11-27', '12:00:00', '2018-11-30', '12:00:00', 0, 264000, 'V016', 'C003', 'I000', 'EVT2', 6000);


-- cartype이 SUV인 차량 S6
insert into rent values
('R174', '2018-03-20', '12:00:00', '2018-03-22', '12:00:00', 0, 349000, 'V009', 'C039', 'I000', 'EVT2', 0),
('R175', '2018-04-15', '12:00:00', '2018-04-19', '12:00:00', 0, 305000, 'V018', 'C033', 'I000', 'EVT2', 5000),
('R176', '2018-04-20', '12:00:00', '2018-04-22', '12:00:00', 0, 305000, 'V018', 'C042', 'I000', 'EVT2', 11000),
('R177', '2018-05-20', '12:00:00', '2018-05-22', '12:00:00', 0, 349000, 'V009', 'C011', 'I000', 'EVT2', 6000),
('R178', '2018-05-25', '12:00:00', '2018-05-27', '12:00:00', 0, 305000, 'V018', 'C039', 'I000', 'EVT2', 0),
('R179', '2018-06-20', '12:00:00', '2018-06-25', '12:00:00', 0, 349000, 'V009', 'C011', 'I000', 'EVT2', 11000),
('R180', '2018-07-20', '12:00:00', '2018-07-24', '12:00:00', 0, 305000, 'V018', 'C033', 'I000', 'EVT2', 5000),
('R181', '2018-08-08', '12:00:00', '2018-08-12', '12:00:00', 0, 349000, 'V009', 'C042', 'I000', 'EVT2', 11000),
('R182', '2018-08-13', '12:00:00', '2018-08-15', '12:00:00', 0, 305000, 'V018', 'C011', 'I000', 'EVT2', 6000),
('R183', '2018-08-15', '12:00:00', '2018-08-18', '12:00:00', 0, 349000, 'V009', 'C042', 'I000', 'EVT2', 0),
('R184', '2018-09-20', '12:00:00', '2018-09-22', '12:00:00', 0, 305000, 'V018', 'C011', 'I000', 'EVT2', 11000),
('R185', '2018-09-25', '12:00:00', '2018-09-27', '12:00:00', 0, 349000, 'V009', 'C039', 'I000', 'EVT2', 5000),
('R186', '2018-10-10', '12:00:00', '2018-10-12', '12:00:00', 0, 305000, 'V018', 'C011', 'I000', 'EVT2', 6000),
('R187', '2018-10-14', '12:00:00', '2018-10-18', '12:00:00', 0, 349000, 'V009', 'C042', 'I000', 'EVT2', 0),
('R188', '2018-10-18', '12:00:00', '2018-10-22', '12:00:00', 0, 305000, 'V018', 'C011', 'I000', 'EVT2', 11000),
('R189', '2018-11-11', '12:00:00', '2018-11-13', '12:00:00', 0, 349000, 'V009', 'C039', 'I000', 'EVT2', 5000),
('R190', '2018-11-25', '12:00:00', '2018-11-28', '12:00:00', 0, 305000, 'V018', 'C011', 'I000', 'EVT2', 0),
('R191', '2018-12-08', '12:00:00', '2018-12-11', '12:00:00', 0, 349000, 'V009', 'C033', 'I000', 'EVT2', 0),
('R192', '2018-12-12', '12:00:00', '2018-12-14', '12:00:00', 0, 305000, 'V018', 'C039', 'I000', 'EVT2', 0),
('R193', '2018-12-20', '12:00:00', '2018-12-24', '12:00:00', 0, 349000, 'V009', 'C011', 'I000', 'EVT2', 6000);





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