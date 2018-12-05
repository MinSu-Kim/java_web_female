-- 렌트카
DROP SCHEMA IF EXISTS proj_rentCar;

-- 렌트카
CREATE SCHEMA proj_rentCar;

-- 고객
CREATE TABLE proj_rentCar.customer (
	code       VARCHAR(5)  NOT NULL COMMENT '고객코드', -- 고객코드
	Id         VARCHAR(40) NOT NULL COMMENT '아이디', -- 아이디
	passwd     VARCHAR(40) NOT NULL COMMENT '비밀번호', -- 비밀번호
	Name       VARCHAR(20) NOT NULL COMMENT '고객이름', -- 고객이름
	address    VARCHAR(50) NOT NULL COMMENT '주소', -- 주소
	phone      VARCHAR(13) NOT NULL COMMENT '연락처', -- 연락처
	dob        DATE        NOT NULL COMMENT '생년월일', -- 생년월일
	email      VARCHAR(30) NOT NULL COMMENT '이메일', -- 이메일
	emp_code   VARCHAR(5)  NOT NULL COMMENT '직원코드', -- 직원코드
	license    VARCHAR(4)  NOT NULL COMMENT '면허종류', -- 면허종류
	grade_code CHAR(5)     NOT NULL COMMENT '등급코드' -- 등급코드
)
COMMENT '고객';

-- 고객
ALTER TABLE proj_rentCar.customer
	ADD CONSTRAINT PK_customer -- 고객 기본키
		PRIMARY KEY (
			code -- 고객코드
		);

-- 회원등급
CREATE TABLE proj_rentCar.grade (
	code CHAR(5)     NOT NULL COMMENT '등급코드', -- 등급코드
	name VARCHAR(20) NOT NULL COMMENT '등급이름' -- 등급이름
)
COMMENT '회원등급';

-- 회원등급
ALTER TABLE proj_rentCar.grade
	ADD CONSTRAINT PK_grade -- 회원등급 기본키
		PRIMARY KEY (
			code -- 등급코드
		);

-- 차량대여
CREATE TABLE proj_rentCar.rent (
	code           VARCHAR(10) NOT NULL COMMENT '대여코드', -- 대여코드
	start_date     DATE        NOT NULL COMMENT '시작날짜', -- 시작날짜
	start_time     TIME        NOT NULL COMMENT '시작시간', -- 시작시간
	end_date       DATE        NOT NULL COMMENT '반납날짜', -- 반납날짜
	end_time       TIME        NOT NULL COMMENT '반납시간', -- 반납시간
	is_return      BOOLEAN     NOT NULL COMMENT '반납여부', -- 반납여부
	price          INT         NOT NULL COMMENT '렌트비용', -- 렌트비용
	car_code       VARCHAR(5)  NOT NULL COMMENT '차코드', -- 차코드
	costomer_code  VARCHAR(5)  NOT NULL COMMENT '고객코드', -- 고객코드
	insurance_code VARCHAR(5)  NOT NULL COMMENT '보험코드' -- 보험코드
)
COMMENT '차량대여';

-- 차량대여
ALTER TABLE proj_rentCar.rent
	ADD CONSTRAINT PK_rent -- 차량대여 기본키
		PRIMARY KEY (
			code -- 대여코드
		);

-- 차종(소 중 대)
CREATE TABLE proj_rentCar.car_type (
	code       VARCHAR(4)  NOT NULL COMMENT '차종', -- 차종
	brand_code VARCHAR(5)  NOT NULL COMMENT '브랜드코드', -- 브랜드코드
	name       VARCHAR(20) NOT NULL COMMENT '차종명' -- 차종명
)
COMMENT '차종(소 중 대)';

-- 차종(소 중 대)
ALTER TABLE proj_rentCar.car_type
	ADD CONSTRAINT PK_car_type -- 차종(소 중 대) 기본키
		PRIMARY KEY (
			code -- 차종
		);

-- 차(모델)
CREATE TABLE proj_rentCar.car_model (
	car_code        VARCHAR(5) NOT NULL COMMENT '차코드', -- 차코드
	color           CHAR(2)    NOT NULL COMMENT '색상', -- 색상
	gear            CHAR(2)    NOT NULL COMMENT '오토/', -- 조작방식
	fuel_code       VARCHAR(5) NOT NULL COMMENT '연료코드', -- 연료코드
	brand_code      VARCHAR(5) NOT NULL COMMENT '브랜드코드', -- 브랜드코드
	cartype_code    VARCHAR(4) NOT NULL COMMENT '차종', -- 차종
	six_hour        INTEGER    NOT NULL COMMENT '6시간비용', -- 6시간비용
	twelve_hour     INTEGER    NOT NULL COMMENT '12시간비용', -- 12시간비용
	twentyfour_hour INTEGER    NOT NULL COMMENT '24시간비용' -- 24시간비용
)
COMMENT '차(모델)';

-- 차(모델)
ALTER TABLE proj_rentCar.car_model
	ADD CONSTRAINT PK_car_model -- 차(모델) 기본키
		PRIMARY KEY (
			car_code -- 차코드
		);

-- 연료
CREATE TABLE proj_rentCar.fuel (
	code     VARCHAR(5) NOT NULL COMMENT '연료코드', -- 연료코드
	car_code VARCHAR(5) NOT NULL COMMENT '차코드' -- 차코드
)
COMMENT '연료';

-- 연료
ALTER TABLE proj_rentCar.fuel
	ADD CONSTRAINT PK_fuel -- 연료 기본키
		PRIMARY KEY (
			code -- 연료코드
		);

-- 브랜드
CREATE TABLE proj_rentCar.brand (
	code VARCHAR(5)  NOT NULL COMMENT '브랜드코드', -- 브랜드코드
	name VARCHAR(20) NOT NULL COMMENT '브랜드명' -- 브랜드명
)
COMMENT '브랜드';

-- 브랜드
ALTER TABLE proj_rentCar.brand
	ADD CONSTRAINT PK_brand -- 브랜드 기본키
		PRIMARY KEY (
			code -- 브랜드코드
		);

-- 보험
CREATE TABLE proj_rentCar.insurance (
	code VARCHAR(5) NOT NULL COMMENT '보험코드', -- 보험코드
	type VARCHAR(5) NOT NULL COMMENT '종류' -- 종류
)
COMMENT '보험';

-- 보험
ALTER TABLE proj_rentCar.insurance
	ADD CONSTRAINT PK_insurance -- 보험 기본키
		PRIMARY KEY (
			code -- 보험코드
		);

-- 직원
CREATE TABLE proj_rentCar.employee (
	code   VARCHAR(5)  NOT NULL COMMENT '직원코드', -- 직원코드
	name   VARCHAR(40) NOT NULL COMMENT '직원명', -- 직원명
	phone  VARCHAR(13) NOT NULL COMMENT '연락처', -- 연락처
	passwd VARCHAR(40) NOT NULL COMMENT '비밀번호' -- 비밀번호
)
COMMENT '직원';

-- 직원
ALTER TABLE proj_rentCar.employee
	ADD CONSTRAINT PK_employee -- 직원 기본키
		PRIMARY KEY (
			code -- 직원코드
		);

-- 적용된 이벤트
CREATE TABLE proj_rentCar.event_apply (
	code       VARCHAR(10) NOT NULL COMMENT '대여코드', -- 대여코드
	event_code CHAR(5)     NOT NULL COMMENT '이벤트코드' -- 이벤트코드
)
COMMENT '적용된 이벤트';

-- 이벤트
CREATE TABLE proj_rentCar.event (
	code CHAR(5)     NOT NULL COMMENT '이벤트코드', -- 이벤트코드
	name VARCHAR(20) NOT NULL COMMENT '이벤트명', -- 이벤트명
	rate INTEGER     NOT NULL COMMENT '할인율' -- 할인율
)
COMMENT '이벤트';

-- 이벤트
ALTER TABLE proj_rentCar.event
	ADD CONSTRAINT PK_event -- 이벤트 기본키
		PRIMARY KEY (
			code -- 이벤트코드
		);

-- 고객
ALTER TABLE proj_rentCar.customer
	ADD CONSTRAINT FK_employee_TO_customer -- 직원 -> 고객
		FOREIGN KEY (
			emp_code -- 직원코드
		)
		REFERENCES proj_rentCar.employee ( -- 직원
			code -- 직원코드
		);

-- 고객
ALTER TABLE proj_rentCar.customer
	ADD CONSTRAINT FK_grade_TO_customer -- 회원등급 -> 고객
		FOREIGN KEY (
			grade_code -- 등급코드
		)
		REFERENCES proj_rentCar.grade ( -- 회원등급
			code -- 등급코드
		);

-- 차량대여
ALTER TABLE proj_rentCar.rent
	ADD CONSTRAINT FK_car_model_TO_rent -- 차(모델) -> 차량대여
		FOREIGN KEY (
			car_code -- 차코드
		)
		REFERENCES proj_rentCar.car_model ( -- 차(모델)
			car_code -- 차코드
		);

-- 차량대여
ALTER TABLE proj_rentCar.rent
	ADD CONSTRAINT FK_customer_TO_rent -- 고객 -> 차량대여
		FOREIGN KEY (
			costomer_code -- 고객코드
		)
		REFERENCES proj_rentCar.customer ( -- 고객
			code -- 고객코드
		);

-- 차량대여
ALTER TABLE proj_rentCar.rent
	ADD CONSTRAINT FK_insurance_TO_rent -- 보험 -> 차량대여
		FOREIGN KEY (
			insurance_code -- 보험코드
		)
		REFERENCES proj_rentCar.insurance ( -- 보험
			code -- 보험코드
		);

-- 차종(소 중 대)
ALTER TABLE proj_rentCar.car_type
	ADD CONSTRAINT FK_brand_TO_car_type -- 브랜드 -> 차종(소 중 대)
		FOREIGN KEY (
			brand_code -- 브랜드코드
		)
		REFERENCES proj_rentCar.brand ( -- 브랜드
			code -- 브랜드코드
		);

-- 차(모델)
ALTER TABLE proj_rentCar.car_model
	ADD CONSTRAINT FK_car_type_TO_car_model -- 차종(소 중 대) -> 차(모델)
		FOREIGN KEY (
			cartype_code -- 차종
		)
		REFERENCES proj_rentCar.car_type ( -- 차종(소 중 대)
			code -- 차종
		);

-- 연료
ALTER TABLE proj_rentCar.fuel
	ADD CONSTRAINT FK_car_model_TO_fuel -- 차(모델) -> 연료
		FOREIGN KEY (
			car_code -- 차코드
		)
		REFERENCES proj_rentCar.car_model ( -- 차(모델)
			car_code -- 차코드
		);

-- 적용된 이벤트
ALTER TABLE proj_rentCar.event_apply
	ADD CONSTRAINT FK_rent_TO_event_apply -- 차량대여 -> 적용된 이벤트
		FOREIGN KEY (
			code -- 대여코드
		)
		REFERENCES proj_rentCar.rent ( -- 차량대여
			code -- 대여코드
		);

-- 적용된 이벤트
ALTER TABLE proj_rentCar.event_apply
	ADD CONSTRAINT FK_event_TO_event_apply -- 이벤트 -> 적용된 이벤트
		FOREIGN KEY (
			event_code -- 이벤트코드
		)
		REFERENCES proj_rentCar.event ( -- 이벤트
			code -- 이벤트코드
		);