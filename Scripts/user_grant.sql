CREATE USER 'user_rentCar'@'%';
ALTER USER 'user_rentCar'@'%'
IDENTIFIED BY 'rootroot' ;
GRANT Alter ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Create ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Create view ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Delete ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Drop ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Grant option ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Index ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Insert ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT References ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Select ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Show view ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Trigger ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Update ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Alter routine ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Create routine ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Create temporary tables ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Execute ON proj_rentcar.* TO 'user_rentCar'@'%';
GRANT Lock tables ON proj_rentcar.* TO 'user_rentCar'@'%';
FLUSH PRIVILEGES;


CREATE USER 'user_rentCar'@'localhost';
ALTER USER 'user_rentCar'@'localhost'
IDENTIFIED BY 'rootroot' ;
GRANT Alter ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Create ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Create view ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Delete ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Drop ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Grant option ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Index ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Insert ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT References ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Select ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Show view ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Trigger ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Update ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Alter routine ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Create routine ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Create temporary tables ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Execute ON proj_rentcar.* TO 'user_rentCar'@'localhost';
GRANT Lock tables ON proj_rentcar.* TO 'user_rentCar'@'localhost';
FLUSH PRIVILEGES;
