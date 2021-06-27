-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: shoe_shop
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `colour_item_group`
--

DROP TABLE IF EXISTS `colour_item_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colour_item_group` (
  `colour_id` int NOT NULL,
  `item_group_id` int NOT NULL,
  PRIMARY KEY (`colour_id`,`item_group_id`),
  KEY `bbbb_idx` (`item_group_id`),
  CONSTRAINT `FK_COLOUR_ITEM_GROUP---COLOUR` FOREIGN KEY (`colour_id`) REFERENCES `colour` (`id`),
  CONSTRAINT `FK_COLOUR_ITEM_GROUP---ITEM_GROUP` FOREIGN KEY (`item_group_id`) REFERENCES `item_group` (`item_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colour_item_group`
--

LOCK TABLES `colour_item_group` WRITE;
/*!40000 ALTER TABLE `colour_item_group` DISABLE KEYS */;
INSERT INTO `colour_item_group` VALUES (1,1),(2,1),(3,1),(7,1),(1,2),(2,2),(3,2),(7,2),(1,3),(3,3),(7,3),(1,4),(2,4),(3,4),(5,4),(7,4),(1,5),(2,5),(3,5),(5,5),(7,5),(2,6),(4,6),(5,6),(7,6),(2,7),(4,7),(5,7),(7,7),(4,8),(5,8),(7,8),(4,9),(5,9),(7,9),(4,10),(5,10);
/*!40000 ALTER TABLE `colour_item_group` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-27 13:39:56
