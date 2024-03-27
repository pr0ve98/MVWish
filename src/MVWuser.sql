show tables;

CREATE TABLE MVWuser(
	mid VARCHAR(20) NOT NULL PRIMARY KEY,
	password VARCHAR(20) NOT NULL,
	name VARCHAR(20) NOT NULL,
	age INT NOT NULL,
	gender CHAR(5) DEFAULT '표시 안함'
);

DESC MVWuser;
DROP FROM MVWuser;

SELECT * FROM MVWuser;

INSERT INTO MVWuser VALUES ('admin','1234','김한나', 27, '여자');