-- 렌트카
DROP SCHEMA IF EXISTS proj_rentCar;

-- 차량관리
DROP SCHEMA IF EXISTS Car;

-- 렌트카
CREATE SCHEMA proj_rentCar;

-- 차량관리
CREATE SCHEMA Car;

-- 고객
CREATE TABLE proj_rentCar.customer (
	code         VARCHAR(5)  NOT NULL COMMENT '고객코드', -- 고객코드
	id           VARCHAR(40) NOT NULL COMMENT '아이디', -- 아이디
	passwd       VARCHAR(40) NOT NULL COMMENT '비밀번호', -- 비밀번호
	name         VARCHAR(20) NOT NULL COMMENT '고객이름', -- 고객이름
	address      VARCHAR(50) NOT NULL COMMENT '주소', -- 주소
	phone        VARCHAR(13) NOT NULL COMMENT '연락처', -- 연락처
	dob          DATE        NOT NULL COMMENT '생년월일', -- 생년월일
	email        VARCHAR(30) NOT NULL COMMENT '이메일', -- 이메일
	grade_code   CHAR(5)     NOT NULL COMMENT '등급코드', -- 등급코드
	license_code VARCHAR(4)  NOT NULL COMMENT '면허코드', -- 면허코드
	emp_code     VARCHAR(5)  NOT NULL COMMENT '직원코드', -- 직원코드
	blacklist    BOOLEAN     NOT NULL COMMENT '블랙리스트여부' -- 블랙리스트여부
)
COMMENT '고객';

-- 고객
ALTER TABLE proj_rentCar.customer
	ADD CONSTRAINT PK_customer -- 고객 기본키
		PRIMARY KEY (
			code -- 고객코드
		);

-- 면허
CREATE TABLE proj_rentCar.drive_license (
	license_code VARCHAR(4)  NOT NULL COMMENT '면허코드', -- 면허코드
	license_type VARCHAR(20) NOT NULL COMMENT '면허종류' -- 면허종류
)
COMMENT '면허';

-- 면허
ALTER TABLE proj_rentCar.drive_license
	ADD CONSTRAINT PK_drive_license -- 면허 기본키
		PRIMARY KEY (
			license_code -- 면허코드
		);

-- 회원등급
CREATE TABLE proj_rentCar.customer_grade (
	grade_code CHAR(5)     NOT NULL COMMENT '등급코드', -- 등급코드
	grade_name VARCHAR(20) NOT NULL COMMENT '등급이름' -- 등급이름
)
COMMENT '회원등급';

-- 회원등급
ALTER TABLE proj_rentCar.customer_grade
	ADD CONSTRAINT PK_customer_grade -- 회원등급 기본키
		PRIMARY KEY (
			grade_code -- 등급코드
		);

-- 차량대여
CREATE TABLE proj_rentCar.rent (
	rent_code      VARCHAR(10) NOT NULL COMMENT '대여코드', -- 대여코드
	start_date     DATE        NOT NULL COMMENT '시작날짜', -- 시작날짜
	start_time     TIME        NOT NULL COMMENT '시작시간', -- 시작시간
	end_date       DATE        NOT NULL COMMENT '반납날짜', -- 반납날짜
	end_time       TIME        NOT NULL COMMENT '반납시간', -- 반납시간
	is_return      BOOLEAN     NOT NULL COMMENT '반납여부', -- 반납여부
	rent_price     INT         NOT NULL COMMENT '렌트비용', -- 렌트비용
	car_code       VARCHAR(5)  NOT NULL COMMENT '차코드', -- 차코드
	code           VARCHAR(5)  NOT NULL COMMENT '고객코드', -- 고객코드
	insurance_code VARCHAR(5)  NOT NULL COMMENT '보험코드' -- 보험코드
)
COMMENT '차량대여';

-- 차량대여
ALTER TABLE proj_rentCar.rent
	ADD CONSTRAINT PK_rent -- 차량대여 기본키
		PRIMARY KEY (
			rent_code -- 대여코드
		);

-- 차종
CREATE TABLE proj_rentCar.carKind (
	car_kind VARCHAR(4) NOT NULL COMMENT '차종' -- 차종
)
COMMENT '차종';

-- 차종
ALTER TABLE proj_rentCar.carKind
	ADD CONSTRAINT PK_carKind -- 차종 기본키
		PRIMARY KEY (
			car_kind -- 차종
		);

-- 차
CREATE TABLE proj_rentCar.car (
	car_code   VARCHAR(5) NOT NULL COMMENT '차코드', -- 차코드
	car_color  CHAR(2)    NOT NULL COMMENT '색상', -- 색상
	gear       CHAR(2)    NOT NULL COMMENT '오토/', -- 조작방식
	fuel_code  VARCHAR(5) NOT NULL COMMENT '연료코드', -- 연료코드
	brand_code VARCHAR(5) NOT NULL COMMENT '브랜드코드' -- 브랜드코드
)
COMMENT '차';

-- 차
ALTER TABLE proj_rentCar.car
	ADD CONSTRAINT PK_car -- 차 기본키
		PRIMARY KEY (
			car_code -- 차코드
		);

-- 연료
CREATE TABLE proj_rentCar.fuel (
	fuel_code VARCHAR(5) NOT NULL COMMENT '연료코드' -- 연료코드
)
COMMENT '연료';

-- 연료
ALTER TABLE proj_rentCar.fuel
	ADD CONSTRAINT PK_fuel -- 연료 기본키
		PRIMARY KEY (
			fuel_code -- 연료코드
		);

-- 브랜드
CREATE TABLE proj_rentCar.brand (
	brand_code VARCHAR(5)  NOT NULL COMMENT '브랜드코드', -- 브랜드코드
	country    VARCHAR(20) NOT NULL COMMENT '생산국가' -- 생산국가
)
COMMENT '브랜드';

-- 브랜드
ALTER TABLE proj_rentCar.brand
	ADD CONSTRAINT PK_brand -- 브랜드 기본키
		PRIMARY KEY (
			brand_code -- 브랜드코드
		);

-- 시간당 렌트비용
CREATE TABLE proj_rentCar.price (
	price_code      VARCHAR(5) NOT NULL COMMENT '비용코드', -- 비용코드
	six_time        DATE       NULL     COMMENT '6시간', -- 6시간
	twelve_time     DATE       NULL     COMMENT '12시간', -- 12시간
	twentyfour_time DATE       NULL     COMMENT '24시간' -- 24시간
)
COMMENT '시간당 렌트비용';

-- 시간당 렌트비용
ALTER TABLE proj_rentCar.price
	ADD CONSTRAINT PK_price -- 시간당 렌트비용 기본키
		PRIMARY KEY (
			price_code -- 비용코드
		);

-- 보험
CREATE TABLE proj_rentCar.insurance (
	insurance_code VARCHAR(5) NOT NULL COMMENT '보험코드', -- 보험코드
	insurance_type VARCHAR(5) NOT NULL COMMENT '종류' -- 종류
)
COMMENT '보험';

-- 보험
ALTER TABLE proj_rentCar.insurance
	ADD CONSTRAINT PK_insurance -- 보험 기본키
		PRIMARY KEY (
			insurance_code -- 보험코드
		);

-- 직원
CREATE TABLE proj_rentCar.employee (
	emp_code   VARCHAR(5)  NOT NULL COMMENT '직원코드', -- 직원코드
	emp_name   VARCHAR(40) NOT NULL COMMENT '직원명', -- 직원명
	emp_phone  VARCHAR(13) NOT NULL COMMENT '연락처', -- 연락처
	emp_id     VARCHAR(40) NOT NULL COMMENT '아이디', -- 아이디
	emp_passwd VARCHAR(40) NOT NULL COMMENT '비밀번호' -- 비밀번호
)
COMMENT '직원';

-- 직원
ALTER TABLE proj_rentCar.employee
	ADD CONSTRAINT PK_employee -- 직원 기본키
		PRIMARY KEY (
			emp_code -- 직원코드
		);

-- 이벤트
CREATE TABLE proj_rentCar.event (
	rent_code     VARCHAR(10) NOT NULL COMMENT '대여코드', -- 대여코드
	event         VARCHAR(20) NOT NULL COMMENT '이벤트명', -- 이벤트명
	discount_rate INTEGER     NOT NULL COMMENT '할인율' -- 할인율
)
COMMENT '이벤트';

-- 고객
ALTER TABLE proj_rentCar.customer
	ADD CONSTRAINT FK_employee_TO_customer -- 직원 -> 고객
		FOREIGN KEY (
			emp_code -- 직원코드
		)
		REFERENCES proj_rentCar.employee ( -- 직원
			emp_code -- 직원코드
		);

-- 차량대여
ALTER TABLE proj_rentCar.rent
	ADD CONSTRAINT FK_car_TO_rent -- 차 -> 차량대여
		FOREIGN KEY (
			car_code -- 차코드
		)
		REFERENCES proj_rentCar.car ( -- 차
			car_code -- 차코드
		);

-- 차량대여
ALTER TABLE proj_rentCar.rent
	ADD CONSTRAINT FK_customer_TO_rent -- 고객 -> 차량대여
		FOREIGN KEY (
			code -- 고객코드
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
			insurance_code -- 보험코드
		);

-- 이벤트
ALTER TABLE proj_rentCar.event
	ADD CONSTRAINT FK_rent_TO_event -- 차량대여 -> 이벤트
		FOREIGN KEY (
			rent_code -- 대여코드
		)
		REFERENCES proj_rentCar.rent ( -- 차량대여
			rent_code -- 대여코드
		);