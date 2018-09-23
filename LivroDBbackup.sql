-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: livrosdb
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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor` (
  `cod` int(45) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sobrenome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'joão','silva'),(2,'pedro','lopes'),(3,'Carlos','Pereira'),(4,'Zé','ninguem'),(5,'André','Dantas');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livro`
--

DROP TABLE IF EXISTS `livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livro` (
  `cod` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `ano` varchar(4) DEFAULT NULL,
  `resenha` varchar(255) NOT NULL,
  `imagem` blob,
  `data_cadastro` datetime NOT NULL,
  `cod_nota` int(11) DEFAULT NULL,
  `cod_autor` int(11) NOT NULL,
  PRIMARY KEY (`cod`),
  KEY `cod_nota` (`cod_nota`),
  CONSTRAINT `livro_ibfk_1` FOREIGN KEY (`cod_nota`) REFERENCES `nota_usuario` (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livro`
--

LOCK TABLES `livro` WRITE;
/*!40000 ALTER TABLE `livro` DISABLE KEYS */;
INSERT INTO `livro` VALUES (1,'Livro um','1990','Lorem ipsum dolor sit amet, vim te verear appareat senserit.d',NULL,'2018-09-23 20:38:12',NULL,1),(2,'Livro dois','1991','Lorem ipsum dolor sit amet, vim te verear appareat senserit',NULL,'2018-09-23 20:01:25',NULL,1),(3,'Outro livro','1999','Lorem ipsum dolor sit amet, vim te verear appareat senserit. ',NULL,'2018-09-23 20:03:59',NULL,2),(4,'O livro','2000','Lorem ipsum dolor sit amet, vim te verear appareat senserit. ',NULL,'2018-09-23 20:27:39',NULL,4),(5,'O Livro 2','2001','Lorêm ipsúm dolor sit amet, mundi némórê patriôque àt nec.',NULL,'2018-09-23 20:08:25',NULL,4),(6,'The Livro','2010','Lorêm ipsúm dolor sit amet, mundi némórê patriôque àt nec.',NULL,'2018-09-23 20:08:25',NULL,5),(7,'Livro A','1888','Lorêm ipsúm dolor sit amet, mundi némórê patriôque àt nec',NULL,'2018-09-23 20:08:25',NULL,3),(8,'Livro B','1889','Lorêm ipsúm dolor sit amet, mundi némórê patriôque àt nec',NULL,'2018-09-23 20:08:25',NULL,3),(9,'Livro de contos','2009','Lorêm ipsúm dolor sit amet, mundi némórê patriôque àt nec',NULL,'2018-09-23 20:08:25',NULL,2),(10,'Ultimo livro','2018','Lorêm ipsúm dolor sit amet, mundi némórê patriôque àt nec, d.',NULL,'2018-09-23 20:27:39',NULL,1);
/*!40000 ALTER TABLE `livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livro_autor`
--

DROP TABLE IF EXISTS `livro_autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livro_autor` (
  `cod_livro` int(11) NOT NULL,
  `cod_autor` int(11) NOT NULL,
  PRIMARY KEY (`cod_livro`,`cod_autor`),
  KEY `cod_autor` (`cod_autor`),
  CONSTRAINT `livro_autor_ibfk_1` FOREIGN KEY (`cod_livro`) REFERENCES `livro` (`cod`),
  CONSTRAINT `livro_autor_ibfk_2` FOREIGN KEY (`cod_autor`) REFERENCES `autor` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livro_autor`
--

LOCK TABLES `livro_autor` WRITE;
/*!40000 ALTER TABLE `livro_autor` DISABLE KEYS */;
/*!40000 ALTER TABLE `livro_autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota_usuario`
--

DROP TABLE IF EXISTS `nota_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota_usuario` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `nota` int(10) NOT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_usuario`
--

LOCK TABLES `nota_usuario` WRITE;
/*!40000 ALTER TABLE `nota_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-23 20:53:09
