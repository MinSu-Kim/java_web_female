use proj_rentcar;

select * from customer;

select * from grade;  

select * from employee;

select * from title;

select * from level;

select * from event;

desc `level`;


-- 등급 insert 
insert into grade values ('G001', '브론즈', 5),
						('G002', '실버', 10),
						('G003', '골드', 20),
						('G004', '블랙리스트', 0);
					
					
					
-- 직책 insert					
insert into title values ('T001', '매니저', true),
						('T002', '일반사원', false);

-- 직원 insert					
insert into employee values ('E001', '나매니저', '010-1234-1234', password('rootroot'), 'T001'),
							('E002', '너일반사원', '010-5678-5678', password('abcdef'), 'T002');
						

-- 비밀번호 길이 확인
select length(password('root123345')) from dual;

-- 비밀번호가 같은지 확인
select password('rootroot') = password('rootroot1') from dual;

-- 고객 insert
insert into customer values ('C001', 'asd132', password('rootroot'), '김철수', '대구 서구', '010-0000-7777', '1988-04-18', 'abc@gmail.com' ,'E001' , '2종보통','G001', 1),
							('C002', 'qwer12', password('root1234'), '김영희', '서울 서구', '010-1111-6666', '1972-09-11', 'abc@naver.com' ,'E002' , '1종보통','G001', 3),
							('C003', 'zxcv0523', password('asdfqwer'), '박철민', '부산 동구', '010-2222-5555', '1961-10-25', 'abc@gnaver.com' ,'E002' , '1종보통','G002', 7),
							('C004', 'gtshv512', password('asdf1234'), '이수민', '대전 서구', '010-3333-4444', '1987-05-27', 'abc@gmail.com' ,'E001' , '2종보통','G002', 9),
							('C005', 'gstjsva12', password('zxcv4567'), '나영석', '대구 수성구', '010-4444-3333', '1958-12-31', 'abc@daum.net' ,'E001' , '2종보통','G003', 21),
							('C006', 'aefvb238', password('qwer2573'), '강호동', '대구 동구', '010-5555-2222', '1999-11-04', 'abc@daum.com' ,'E002' , '1종보통','G003', 30),
							('C007', 'fkufj12', password('dhtdhd5645'), '김민정', '울산 서구', '010-6666-1111', '1994-03-16', 'abc@naver.com' ,'E002' , '2종보통','G004', -1),
							('C008', 'xbmhw325', password('aggarg54'), '김재영', '서울 서초구', '010-7777-0000', '1977-01-02', 'abc@gmail.com' ,'E001' , '1종보통','G004', -1);
insert into customer values
('C009', 'xbmhw325',password('aggarg54'), '김영희', '서울 서초구', '010-7777-0000', '1977-01-02', 'abc@gmail.com' ,'E001' , '1종보통','G004', -1);
-- 회원등급기준 insert					 
insert into level values ('브론즈',0,5),
							('실버',6,10),
							('골드',11,99999),
							('블랙리스트',-1,-1);	

insert into event values('EVT1', '첫가입', 3),
						('EVT2', '생일축하', 5);


						