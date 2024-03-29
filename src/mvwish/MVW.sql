show tables;

-- 유저 테이블
CREATE TABLE MVWuser(
	mid VARCHAR(20) NOT NULL PRIMARY KEY,
	password VARCHAR(20) NOT NULL,
	name VARCHAR(20) NOT NULL,
	age INT NOT NULL,
	gender CHAR(5) DEFAULT '표시 안함'
);

DESC MVWuser;
DROP TABLE MVWuser;

SELECT * FROM MVWuser;

DELETE FROM MVWuser WHERE age=12;

INSERT INTO MVWuser VALUES ('admin','1234','김한나', 27, '여자');

-- 영화 테이블
CREATE TABLE mvwmovie(
	idx INT NOT NULL auto_increment PRIMARY KEY,
	moviename VARCHAR(40) NOT NULL,
	runningtime VARCHAR(20) NOT NULL,
	genre VARCHAR(40) NOT NULL,
	score DOUBLE NOT NULL,
	img VARCHAR(30) NOT NULL
);

DESC mvwmovie;
DROP TABLE mvwmovie;

INSERT INTO MVWmovie VALUES (DEFAULT,'테스트 영화','2시간 13분', '판타지/액션/스릴러', 3.5, '/mvwish/images/logo.jpg');
SELECT * FROM mvwmovie;

-- 유저가 고른 영화 테이블
CREATE TABLE MVWuserlike(
	mid VARCHAR(20) NOT NULL,
	idx INT NOT NULL auto_increment,
	FOREIGN KEY (mid) REFERENCES MVWuser (mid),
	FOREIGN KEY (idx) REFERENCES mvwmovie (idx)
);

DESC MVWuserlike;
DROP TABLE MVWuserlike;

SELECT * FROM MVWuserlike;
