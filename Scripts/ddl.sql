create database proj_rentCar;

-- 렌트카
DROP SCHEMA IF EXISTS proj_rentCar;

-- 차량관리
DROP SCHEMA IF EXISTS Car;

-- 렌트카
CREATE SCHEMA proj_rentCar;

-- 차량관리
CREATE SCHEMA Car;

-- 고객관리
CREATE TABLE proj_rentCar.customer (
	Code        VARCHAR(5)  NOT NULL COMMENT '고객코드', -- 고객코드
	Name        VARCHAR(20) NULL     COMMENT '고객이름', -- 고객이름
	address     VARCHAR(50) NULL     COMMENT '주소', -- 주소
	phone       VARCHAR(13) NULL     COMMENT '연락처', -- 연락처
	dob         DATE        NULL     COMMENT '생년월일', -- 생년월일
	email       VARCHAR(30) NULL     COMMENT '이메일', -- 이메일
	gradeCode   CHAR(5)     NULL     COMMENT '등급코드', -- 등급코드
	licenseCode VARCHAR(4)  NULL     COMMENT '면허코드' -- 면허코드
)
COMMENT '고객관리';

-- 고객관리
ALTER TABLE proj_rentCar.customer
	ADD CONSTRAINT PK_customer -- 고객관리 기본키
		PRIMARY KEY (
			Code -- 고객코드
		);

-- 면허
CREATE TABLE proj_rentCar.drive_license (
	licenseCode VARCHAR(4)  NOT NULL COMMENT '면허코드', -- 면허코드
	licenseType VARCHAR(20) NULL     COMMENT '면허종류' -- 면허종류
)
COMMENT '면허';

-- 면허
ALTER TABLE proj_rentCar.drive_license
	ADD CONSTRAINT PK_drive_license -- 면허 기본키
		PRIMARY KEY (
			licenseCode -- 면허코드
		);

-- 회원등급
CREATE TABLE proj_rentCar.customer_grade (
	gradeCode CHAR(5)     NOT NULL COMMENT '등급코드', -- 등급코드
	gradeName VARCHAR(20) NULL     COMMENT '등급이름' -- 등급이름
)
COMMENT '회원등급';

-- 회원등급
ALTER TABLE proj_rentCar.customer_grade
	ADD CONSTRAINT PK_customer_grade -- 회원등급 기본키
		PRIMARY KEY (
			gradeCode -- 등급코드
		);

-- 대여테이블
CREATE TABLE proj_rentCar.rent (
	rentCode      VARCHAR(10) NOT NULL COMMENT '대여코드', -- 대여코드
	startDate     DATE        NOT NULL COMMENT '시작날짜', -- 시작날짜
	startTime     TIME        NOT NULL COMMENT '시작시간', -- 시작시간
	endDate       DATE        NOT NULL COMMENT '반납날짜', -- 반납날짜
	endTime       TIME        NOT NULL COMMENT '반납시간', -- 반납시간
	isReturn      BOOLEAN     NOT NULL COMMENT '반납여부', -- 반납여부
	rentPrice     INT         NULL     COMMENT '렌트비용', -- 렌트비용
	carCode       VARCHAR(5)  NOT NULL COMMENT '차코드', -- 차코드
	Code          VARCHAR(5)  NOT NULL COMMENT '고객코드', -- 고객코드
	insuranceCode VARCHAR(5)  NOT NULL COMMENT '보험코드' -- 보험코드
)
COMMENT '대여테이블';

-- 대여테이블
ALTER TABLE proj_rentCar.rent
	ADD CONSTRAINT PK_rent -- 대여테이블 기본키
		PRIMARY KEY (
			rentCode -- 대여코드
		);

-- 차종
CREATE TABLE proj_rentCar.carKind (
	COL VARCHAR(4) NOT NULL COMMENT '차종' -- 차종
)
COMMENT '차종';

-- 차종
ALTER TABLE proj_rentCar.carKind
	ADD CONSTRAINT PK_carKind -- 차종 기본키
		PRIMARY KEY (
			COL -- 차종
		);

-- 차
CREATE TABLE proj_rentCar.car (
	carCode   VARCHAR(5) NOT NULL COMMENT '차코드', -- 차코드
	carColor  CHAR(2)    NOT NULL COMMENT '색상', -- 색상
	priceCode VARCHAR(5) NOT NULL COMMENT '비용코드', -- 비용코드
	gear      CHAR(2)    NOT NULL COMMENT '오토/', -- 조작방식
	fuelCode  VARCHAR(5) NOT NULL COMMENT '연료코드', -- 연료코드
	brandCode VARCHAR(5) NOT NULL COMMENT '브랜드코드' -- 브랜드코드
)
COMMENT '차';

-- 차
ALTER TABLE proj_rentCar.car
	ADD CONSTRAINT PK_car -- 차 기본키
		PRIMARY KEY (
			carCode -- 차코드
		);

-- 연료
CREATE TABLE proj_rentCar.fuel (
	fuelCode VARCHAR(5) NOT NULL COMMENT '연료코드' -- 연료코드
)
COMMENT '연료';

-- 연료
ALTER TABLE proj_rentCar.fuel
	ADD CONSTRAINT PK_fuel -- 연료 기본키
		PRIMARY KEY (
			fuelCode -- 연료코드
		);

-- 브랜드
CREATE TABLE proj_rentCar.brand (
	brandCode VARCHAR(5)  NOT NULL COMMENT '브랜드코드', -- 브랜드코드
	country   VARCHAR(20) NULL     COMMENT '생산국가' -- 생산국가
)
COMMENT '브랜드';

-- 브랜드
ALTER TABLE proj_rentCar.brand
	ADD CONSTRAINT PK_brand -- 브랜드 기본키
		PRIMARY KEY (
			brandCode -- 브랜드코드
		);

-- 시간당 렌트비용
CREATE TABLE proj_rentCar.price (
	priceCode      VARCHAR(5) NOT NULL COMMENT '비용코드', -- 비용코드
	sixTime        DATE       NULL     COMMENT '6시간', -- 6시간
	twelveTime     DATE       NULL     COMMENT '12시간', -- 12시간
	twentyfourTime DATE       NULL     COMMENT '24시간' -- 24시간
)
COMMENT '시간당 렌트비용';

-- 시간당 렌트비용
ALTER TABLE proj_rentCar.price
	ADD CONSTRAINT PK_price -- 시간당 렌트비용 기본키
		PRIMARY KEY (
			priceCode -- 비용코드
		);

-- 보험
CREATE TABLE proj_rentCar.insurance (
	insuranceCode VARCHAR(5) NOT NULL COMMENT '보험코드', -- 보험코드
	insuranceType VARCHAR(5) NULL     COMMENT '종류' -- 종류
)
COMMENT '보험';

-- 보험
ALTER TABLE proj_rentCar.insurance
	ADD CONSTRAINT PK_insurance -- 보험 기본키
		PRIMARY KEY (
			insuranceCode -- 보험코드
		);

-- 고객관리
ALTER TABLE proj_rentCar.customer
	ADD CONSTRAINT FK_customer_grade_TO_customer -- 회원등급 -> 고객관리
		FOREIGN KEY (
			gradeCode -- 등급코드
		)
		REFERENCES proj_rentCar.customer_grade ( -- 회원등급
			gradeCode -- 등급코드
		);

-- 고객관리
ALTER TABLE proj_rentCar.customer
	ADD CONSTRAINT FK_drive_license_TO_customer -- 면허 -> 고객관리
		FOREIGN KEY (
			licenseCode -- 면허코드
		)
		REFERENCES proj_rentCar.drive_license ( -- 면허
			licenseCode -- 면허코드
		);

-- 대여테이블
ALTER TABLE proj_rentCar.rent
	ADD CONSTRAINT FK_car_TO_rent -- 차 -> 대여테이블
		FOREIGN KEY (
			carCode -- 차코드
		)
		REFERENCES proj_rentCar.car ( -- 차
			carCode -- 차코드
		);

-- 대여테이블
ALTER TABLE proj_rentCar.rent
	ADD CONSTRAINT FK_customer_TO_rent -- 고객관리 -> 대여테이블
		FOREIGN KEY (
			Code -- 고객코드
		)
		REFERENCES proj_rentCar.customer ( -- 고객관리
			Code -- 고객코드
		);

-- 대여테이블
ALTER TABLE proj_rentCar.rent
	ADD CONSTRAINT FK_insurance_TO_rent -- 보험 -> 대여테이블
		FOREIGN KEY (
			insuranceCode -- 보험코드
		)
		REFERENCES proj_rentCar.insurance ( -- 보험
			insuranceCode -- 보험코드
		);

-- 차
ALTER TABLE proj_rentCar.car
	ADD CONSTRAINT FK_price_TO_car -- 시간당 렌트비용 -> 차
		FOREIGN KEY (
			priceCode -- 비용코드
		)
		REFERENCES proj_rentCar.price ( -- 시간당 렌트비용
			priceCode -- 비용코드
		);