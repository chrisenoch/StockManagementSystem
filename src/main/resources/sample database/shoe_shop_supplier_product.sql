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
-- Table structure for table `supplier_product`
--

DROP TABLE IF EXISTS `supplier_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier_product` (
  `supplier_id` int NOT NULL,
  `product_id` varchar(20) NOT NULL,
  PRIMARY KEY (`supplier_id`,`product_id`),
  KEY `FK_SHOP_SUPPLIER_PRODUCT---SHOE_idx` (`product_id`),
  KEY `CC_idx` (`supplier_id`),
  CONSTRAINT `FK_SHOP_SUPPLIER_PRODUCT---SHOE` FOREIGN KEY (`product_id`) REFERENCES `shoe` (`product_id`),
  CONSTRAINT `FK_SHOP_SUPPLIER_PRODUCT--SUPPLIER` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_product`
--

LOCK TABLES `supplier_product` WRITE;
/*!40000 ALTER TABLE `supplier_product` DISABLE KEYS */;
INSERT INTO `supplier_product` VALUES (1,'1'),(1,'2'),(1,'3'),(1,'4'),(1,'410'),(1,'411'),(1,'412'),(1,'413'),(1,'414'),(1,'415'),(1,'416'),(1,'417'),(1,'418'),(1,'419'),(1,'420'),(1,'454'),(1,'455'),(1,'456'),(1,'457'),(1,'458'),(1,'459'),(1,'460'),(1,'461'),(1,'462'),(1,'463'),(1,'464'),(1,'465'),(1,'466'),(1,'467'),(1,'468'),(1,'469'),(1,'470'),(1,'472'),(1,'473'),(1,'474'),(1,'475'),(1,'476'),(1,'477'),(1,'478'),(1,'479'),(1,'480'),(1,'481'),(1,'482'),(1,'483'),(1,'484'),(1,'485'),(1,'486'),(1,'5'),(1,'6'),(1,'7'),(1,'8'),(1,'9'),(2,'10'),(2,'11'),(2,'12'),(2,'13'),(2,'14'),(2,'15'),(2,'16'),(2,'17'),(2,'18'),(2,'19'),(2,'20'),(2,'21'),(2,'22'),(2,'23'),(2,'234'),(2,'235'),(2,'237'),(2,'238'),(2,'239'),(2,'24'),(2,'240'),(2,'241'),(2,'242'),(2,'243'),(2,'244'),(2,'25'),(2,'255'),(2,'256'),(2,'257'),(2,'258'),(2,'259'),(2,'26'),(2,'260'),(2,'261'),(2,'262'),(2,'263'),(2,'264'),(2,'265'),(2,'266'),(2,'267'),(2,'268'),(2,'269'),(2,'27'),(2,'270'),(2,'271'),(2,'272'),(2,'273'),(2,'274'),(2,'275'),(2,'276'),(2,'277'),(2,'278'),(2,'279'),(2,'28'),(2,'280'),(2,'281'),(2,'282'),(2,'283'),(2,'284'),(2,'285'),(2,'286'),(2,'287'),(2,'288'),(2,'289'),(2,'29'),(2,'290'),(2,'291'),(2,'292'),(2,'293'),(2,'294'),(2,'295'),(2,'296'),(2,'297'),(2,'298'),(2,'299'),(2,'30'),(2,'300'),(2,'301'),(2,'302'),(2,'303'),(2,'304'),(2,'305'),(2,'306'),(2,'307'),(2,'308'),(2,'309'),(2,'31'),(2,'310'),(2,'311'),(2,'312'),(2,'313'),(2,'314'),(2,'315'),(2,'316'),(2,'317'),(2,'318'),(2,'319'),(2,'32'),(2,'320'),(2,'321'),(2,'322'),(2,'323'),(2,'324'),(2,'325'),(2,'326'),(2,'327'),(2,'328'),(2,'329'),(2,'33'),(2,'330'),(2,'331'),(2,'332'),(2,'333'),(2,'334'),(2,'335'),(2,'336'),(2,'337'),(2,'338'),(2,'339'),(2,'340'),(2,'341'),(2,'342'),(2,'343'),(2,'344'),(2,'345'),(2,'346'),(2,'347'),(2,'348'),(2,'349'),(2,'350'),(2,'351'),(2,'352'),(2,'353'),(2,'354'),(2,'355'),(2,'356'),(2,'357'),(2,'358'),(2,'359'),(2,'360'),(2,'361'),(2,'362'),(2,'363'),(2,'364'),(2,'365'),(2,'366'),(2,'367'),(2,'368'),(2,'369'),(2,'370'),(2,'371'),(2,'372'),(2,'373'),(2,'374'),(2,'375'),(2,'376'),(2,'388'),(2,'389'),(2,'390'),(2,'391'),(2,'392'),(2,'393'),(2,'394'),(2,'395'),(2,'396'),(2,'397'),(2,'398'),(2,'399'),(2,'400'),(2,'401'),(2,'402'),(2,'403'),(2,'404'),(2,'406'),(2,'407'),(2,'408'),(2,'409'),(2,'421'),(2,'422'),(2,'423'),(2,'424'),(2,'425'),(2,'426'),(2,'427'),(2,'428'),(2,'429'),(2,'430'),(2,'431'),(2,'432'),(2,'433'),(2,'434'),(2,'435'),(2,'436'),(2,'437'),(2,'438'),(2,'439'),(2,'440'),(2,'441'),(2,'442'),(2,'443'),(2,'444'),(2,'445'),(2,'446'),(2,'447'),(2,'448'),(2,'449'),(2,'450'),(2,'451'),(2,'452'),(2,'453'),(2,'531'),(2,'532'),(2,'533'),(2,'534'),(2,'535'),(2,'536'),(2,'537'),(2,'538'),(2,'539'),(2,'540'),(2,'541'),(2,'542'),(2,'543'),(2,'544'),(2,'545'),(2,'546'),(2,'547'),(2,'548'),(2,'549'),(2,'550'),(2,'551'),(2,'552'),(2,'553'),(2,'554'),(2,'555'),(2,'556'),(2,'557'),(2,'558'),(2,'559'),(2,'560'),(2,'561'),(2,'562'),(2,'563'),(2,'564'),(2,'565'),(2,'566'),(2,'567'),(2,'568'),(2,'569'),(2,'570'),(2,'571'),(2,'572'),(2,'573'),(2,'574'),(3,'377'),(3,'378'),(3,'379'),(3,'380'),(3,'381'),(3,'382'),(3,'383'),(3,'384'),(3,'385'),(3,'386'),(3,'387'),(3,'487'),(3,'488'),(3,'489'),(3,'490'),(3,'491'),(3,'492'),(3,'493'),(3,'494'),(3,'495'),(3,'496'),(3,'497'),(3,'498'),(3,'499'),(3,'500'),(3,'501'),(3,'502'),(3,'503'),(3,'504'),(3,'505'),(3,'506'),(3,'507'),(3,'508'),(3,'509'),(3,'510'),(3,'511'),(3,'512'),(3,'513'),(3,'514'),(3,'515'),(3,'516'),(3,'517'),(3,'518'),(3,'519'),(3,'520'),(3,'521'),(3,'522'),(3,'523'),(3,'524'),(3,'525'),(3,'526'),(3,'527'),(3,'528'),(3,'529'),(3,'530');
/*!40000 ALTER TABLE `supplier_product` ENABLE KEYS */;
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