CREATE DATABASE  IF NOT EXISTS `hnc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hnc`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: hnc
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `families`
--

DROP TABLE IF EXISTS `families`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `families` (
  `familyID` int(11) NOT NULL AUTO_INCREMENT,
  `lName` varchar(45) DEFAULT NULL,
  `streetAdd1` varchar(45) DEFAULT NULL,
  `streetAdd2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `county` varchar(45) DEFAULT NULL,
  `region` varchar(35) DEFAULT NULL,
  `homePhone` varchar(45) DEFAULT NULL,
  `cellPhone` varchar(45) DEFAULT NULL,
  `email1` varchar(45) DEFAULT NULL,
  `email2` varchar(45) DEFAULT NULL,
  `bleedDisorder` varchar(45) DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL,
  `hope` tinyint(1) DEFAULT '0',
  `teens` tinyint(1) DEFAULT '0',
  `soar` tinyint(1) DEFAULT '0',
  `bloodBrotherhood` tinyint(1) DEFAULT '0',
  `latinUnion` tinyint(1) DEFAULT '0',
  `inhibitors` tinyint(1) DEFAULT '0',
  `advocacy` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`familyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='this table is for storage of families';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `families`
--

LOCK TABLES `families` WRITE;
/*!40000 ALTER TABLE `families` DISABLE KEYS */;
INSERT INTO `families` VALUES (0,'Empty Family',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `families` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `members` (
  `memId` mediumint(6) NOT NULL AUTO_INCREMENT,
  `familyID` mediumint(11) DEFAULT NULL,
  `lName` varchar(45) NOT NULL,
  `fName` varchar(45) NOT NULL,
  `email1` varchar(45) DEFAULT NULL,
  `email2` varchar(45) DEFAULT NULL,
  `streetAdd1` varchar(45) DEFAULT NULL,
  `streetAdd2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `county` varchar(45) DEFAULT NULL,
  `region` varchar(35) DEFAULT NULL,
  `homePhone` varchar(45) DEFAULT NULL,
  `cellPhone` varchar(45) DEFAULT NULL,
  `bleedDisorder` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `joinDate` varchar(45) DEFAULT NULL,
  `updatedDate` varchar(45) DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL,
  `badAdd` varchar(45) DEFAULT NULL,
  `organization` varchar(45) DEFAULT NULL,
  `industry` tinyint(1) DEFAULT '0',
  `hope` tinyint(1) DEFAULT '0',
  `teens` tinyint(1) DEFAULT '0',
  `latinUnion` tinyint(1) DEFAULT '0',
  `soar` tinyint(1) DEFAULT '0',
  `bloodBrotherhood` tinyint(1) DEFAULT '0',
  `inhibitors` tinyint(1) DEFAULT '0',
  `advocacy` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`memId`),
  KEY `familyID_idx` (`familyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='table for individual member information';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hnc'
--

--
-- Dumping routines for database 'hnc'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-15  0:11:09
