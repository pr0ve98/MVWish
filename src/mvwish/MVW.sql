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

INSERT INTO MVWmovie VALUES (DEFAULT,'웡카','1시간 56분', '판타지, 뮤지컬, 코미디, 가족', 8.23, 'WC0.jpg');
INSERT INTO MVWmovie VALUES (DEFAULT,'파묘','2시간 14분', '미스터리, 스릴러, 공포, 서스펜스, 퇴마, 오컬트', 7.99, 'PM0.jpg');
INSERT INTO MVWmovie VALUES (DEFAULT,'퀸카로 살아남는 법','1시간 37분', '코미디, 드라마, 하이틴', 8.23, 'QS0.jpg');
INSERT INTO MVWmovie VALUES (DEFAULT,'하울의 움직이는 성','1시간 59분', '애니메이션, 판타지', 9.35, 'HU0.jpg');
SELECT * FROM mvwmovie;

-- 유저가 고른 영화 테이블
CREATE TABLE MVWuserlike(
	mid VARCHAR(20) NOT NULL,
	idx INT NOT NULL auto_increment PRIMARY KEY,
	FOREIGN KEY (mid) REFERENCES MVWuser (mid),
	FOREIGN KEY (idx) REFERENCES mvwmovie (idx)
);

DESC MVWuserlike;
DROP TABLE MVWuserlike;

SELECT * FROM MVWuserlike;
