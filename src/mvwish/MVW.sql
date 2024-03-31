-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: javaclass4
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mvwmovie`
--

DROP TABLE IF EXISTS `mvwmovie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mvwmovie` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `moviename` varchar(40) NOT NULL,
  `runningtime` varchar(20) NOT NULL,
  `genre` varchar(40) NOT NULL,
  `score` double NOT NULL,
  `img` varchar(30) NOT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mvwmovie`
--

LOCK TABLES `mvwmovie` WRITE;
/*!40000 ALTER TABLE `mvwmovie` DISABLE KEYS */;
INSERT INTO `mvwmovie` VALUES (1,'화이트칙스','1시간 48분','코미디, 액션, 범죄',8.69,'WC1.jpg'),(2,'파묘','2시간 14분','미스터리, 오컬트, 스릴러, 공포',7.99,'PM0.jpg'),(3,'퀸카로 살아남는 법','1시간 37분','코미디, 하이틴',8.23,'QS0.jpg'),(4,'웡카','1시간 56분','판타지, 뮤지컬, 코미디, 가족',8.23,'WC0.jpg'),(5,'하울의 움직이는 성','1시간 59분','애니메이션',9.35,'HU0.jpg'),(6,'악마는 프라다를 입는다','1시간 49분','코미디',8.7,'AP0.jpg'),(7,'장산범','1시간 40분','미스터리, 공포, 스릴러',7.42,'JS0.jpg'),(8,'내가 사랑했던 모든 남자들에게','1시간 39분','하이틴, 로맨스',8.45,'NS0.jpg'),(9,'존 윅 4','2시간 49분','액션, 범죄, 느와르, 복수',8.32,'JW0.jpg'),(10,'유미의 세포들 더 무비','1시간 33분','애니메이션',0,'YS0.jpg'),(13,'고질라 X 콩: 뉴 엠파이어','1시간 55분','액션, SF, 괴수',8.57,'GK0.jpg'),(14,'듄: 파트2','2시간 45분','액션, 판타지, SF, 어드벤처',9.11,'DP0.jpg'),(15,'서울의 봄','2시간 21분','시대극, 액션, 느와르, 스릴러',9.51,'SB0.jpg'),(16,'기생충','2시간 11분','스릴러, 서스펜스, 범죄, 가족',9.07,'GS0.jpg'),(17,'엘리멘탈','1시간 49분','애니메이션',8.92,'EL0.jpg'),(18,'마션','2시간 22분','SF, 모험, 재난',8.72,'MS0.jpg'),(19,'트와일라잇','2시간 1분','판타지, 로맨스',9.61,'TW0.jpg'),(20,'미녀는 괴로워','2시간 0분','로맨틱 코미디',8.79,'MG0.jpg'),(21,'라라랜드','2시간 7분','로맨스, 뮤지컬',8.92,'LL0.jpg'),(22,'써니','미정','미정',0,'미정.jpg');
/*!40000 ALTER TABLE `mvwmovie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mvwuser`
--

DROP TABLE IF EXISTS `mvwuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mvwuser` (
  `mid` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` char(5) DEFAULT '표시 안함',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mvwuser`
--

LOCK TABLES `mvwuser` WRITE;
/*!40000 ALTER TABLE `mvwuser` DISABLE KEYS */;
INSERT INTO `mvwuser` VALUES ('admin','1234','김한나',27,'여자'),('user1','1234','김민지',19,'여자');
/*!40000 ALTER TABLE `mvwuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mvwuserlike`
--

DROP TABLE IF EXISTS `mvwuserlike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mvwuserlike` (
  `mid` varchar(20) NOT NULL,
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idx`),
  KEY `mid` (`mid`),
  CONSTRAINT `mvwuserlike_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `mvwuser` (`mid`),
  CONSTRAINT `mvwuserlike_ibfk_2` FOREIGN KEY (`idx`) REFERENCES `mvwmovie` (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mvwuserlike`
--

LOCK TABLES `mvwuserlike` WRITE;
/*!40000 ALTER TABLE `mvwuserlike` DISABLE KEYS */;
INSERT INTO `mvwuserlike` VALUES ('user1',1),('user1',2),('user1',3),('user1',8),('user1',9);
/*!40000 ALTER TABLE `mvwuserlike` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-01  8:11:55
