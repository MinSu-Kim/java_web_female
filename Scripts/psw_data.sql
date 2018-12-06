select * from customer;

select * from grade;  

select * from employee;

select * from title;

select * from level;

desc `level`;

-- 등급 insert
insert into grade values ('G0001', '브론즈', 5),
						('G0002', '실버', 10),
						('G0003', '골드', 20),
						('G0004', '블랙리스트', 0);
-- 직책 insert					
insert into title values ('T0001', '매니저', true),
						('T0002', '일반사원', false);

-- 직원 insert					
insert into employee values ('E0001', '홍길동1', '010-1234-1234', password('rootroot'), 'T0001'),
							('E0002', '홍길동2', '010-5678-5678', password('abcdef'), 'T0002');

-- 비밀번호 길이 확인
select length(password('root123345')) from dual;
-- 비밀번호가 같은지 확인
select password('rootroot') = password('rootroot1') from dual;

-- 고객 insert
insert into customer values ('C0001', 'asd132', password('rootroot'), '김철수', '대구 서구', '010-0000-7777', '1988-04-18', 'abc@gmail.com' ,'E0001' , '2종보통','G0001', 5),
							('C0002', 'qwer12', password('root1234'), '김영희', '서울 서구', '010-1111-6666', '1972-09-11', 'abc@naver.com' ,'E0002' , '1종보통','G0001', 3),
							('C0003', 'zxcv0523', password('asdfqwer'), '박철민', '부산 동구', '010-2222-5555', '1961-10-25', 'abc@gnaver.com' ,'E0002' , '1종보통','G0002', 8),
							('C0004', 'gtshv512', password('asdf1234'), '이수민', '대전 서구', '010-3333-4444', '1987-05-27', 'abc@gmail.com' ,'E0001' , '2종보통','G0002', 15),
							('C0005', 'gstjsva12', password('zxcv4567'), '나영석', '대구 수성구', '010-4444-3333', '1958-12-31', 'abc@daum.net' ,'E0001' , '2종보통','G0003', 21),
							('C0006', 'aefvb238', password('qwer2573'), '강호동', '대구 동구', '010-5555-2222', '1999-11-04', 'abc@daum.com' ,'E0002' , '1종보통','G0003', 30),
							('C0007', 'fkufj12', password('dhtdhd5645'), '김민정', '울산 서구', '010-6666-1111', '1994-03-16', 'abc@naver.com' ,'E0002' , '2종보통','G0004', 1),
							('C0008', 'xbmhw325',password('aggarg54'), '김재영', '서울 서초구', '010-7777-0000', '1977-01-02', 'abc@gmail.com' ,'E0001' , '1종보통','G0004', 2);

						
							