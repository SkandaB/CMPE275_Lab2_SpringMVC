-- MySQL dump 10.13  Distrib 5.7.16, for osx10.12 (x86_64)
--
-- Host: localhost    Database: lab2_demo
-- ------------------------------------------------------
-- Server version	5.6.33

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
-- Current Database: `lab2_demo`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `lab2_demo` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `lab2_demo`;

--
-- Table structure for table `PHONE_DETAILS`
--

DROP TABLE IF EXISTS `PHONE_DETAILS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PHONE_DETAILS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NUMBER` varchar(10) DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `STREET` varchar(255) DEFAULT NULL,
  `ZIP_CODE` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NUMBER` (`NUMBER`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PHONE_DETAILS`
--

LOCK TABLES `PHONE_DETAILS` WRITE;
/*!40000 ALTER TABLE `PHONE_DETAILS` DISABLE KEYS */;
INSERT INTO `PHONE_DETAILS` VALUES (4,'Home','9876543210','San Jose','C.A.','420 S 3rd St, Apt 18','95112'),(5,'Cell','9876543216','Mysore','KARNATAKA','68, Sri Poorna','57009');
/*!40000 ALTER TABLE `PHONE_DETAILS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_DETAILS`
--

DROP TABLE IF EXISTS `USER_DETAILS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_DETAILS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `TITLE` varchar(255) DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `STREET` varchar(255) DEFAULT NULL,
  `ZIP_CODE` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_DETAILS`
--

LOCK TABLES `USER_DETAILS` WRITE;
/*!40000 ALTER TABLE `USER_DETAILS` DISABLE KEYS */;
INSERT INTO `USER_DETAILS` VALUES (19,'Skanda','Bhargav','','Bangalore','Karnataka','001, Aravind Residency, Harsha Layout, Yelechanahalli, Kanakapura road','56062'),(20,'Skanda','Bhargav','','Bangalore','Karnataka','001, Aravind Residency, Harsha Layout, Yelechanahalli, Kanakapura road','52341'),(21,'Skanda','Bhargav','','San Jose','C.A.','420 S 3rd St, Apt 18','13512'),(23,'Skanda','Bhargav','','San Jose','C.A.','420 S 3rd St, Apt 18','95112'),(24,'Skanda','Bhargav','','San Jose','California','One Washington Square','95112'),(25,'Skanda','Bhargav','','San Jose','California','One Washington Square','95112');
/*!40000 ALTER TABLE `USER_DETAILS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_PHONE`
--

DROP TABLE IF EXISTS `USER_PHONE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_PHONE` (
  `USER_ID` int(11) NOT NULL,
  `PHONE_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`,`PHONE_ID`),
  KEY `FK_USER_PHONE_PHONE_ID` (`PHONE_ID`),
  CONSTRAINT `FK_USER_PHONE_PHONE_ID` FOREIGN KEY (`PHONE_ID`) REFERENCES `PHONE_DETAILS` (`ID`),
  CONSTRAINT `FK_USER_PHONE_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `USER_DETAILS` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_PHONE`
--

LOCK TABLES `USER_PHONE` WRITE;
/*!40000 ALTER TABLE `USER_PHONE` DISABLE KEYS */;
/*!40000 ALTER TABLE `USER_PHONE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-19 12:02:30
