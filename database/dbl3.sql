-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbl3
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency` (
  `idcurrency` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(400) NOT NULL,
  `network` varchar(45) NOT NULL,
  `abreviation` varchar(45) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`idcurrency`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES (1,'bitcoin','la criptomoneda de los estados unidos','0x151212','B',100),(2,'etereum','la criptomoneda de peru','0x162515','E',150),(3,'dogecoin','la moneda de elon','0x121652','D',200);
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `idtransaction` int NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `tx_id` varchar(80) NOT NULL,
  `amount` double NOT NULL,
  `network_fee` double NOT NULL,
  `block` int NOT NULL,
  `status` varchar(45) NOT NULL,
  `user_iduser` int NOT NULL,
  `wallet_idwallet` int NOT NULL,
  `currency` varchar(45) NOT NULL,
  PRIMARY KEY (`idtransaction`),
  KEY `fk_transaction_user1_idx` (`user_iduser`),
  KEY `fk_transaction_wallet1_idx` (`wallet_idwallet`),
  CONSTRAINT `fk_transaction_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`),
  CONSTRAINT `fk_transaction_wallet1` FOREIGN KEY (`wallet_idwallet`) REFERENCES `wallet` (`idwallet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'se dio una transaccion exitosa','0x3245678',20,0.11,12345,'success',1,1,'bitcoin'),(2,'se dio una transaccion exitosa','0x3243567',20,0.1,54321,'success',2,2,'etereum'),(3,'se dio una transaccion exitosa','0x4567988',10,0.12,55423,'success',3,3,'dogecoin'),(4,'se dio una transaccion exitosa','0x3478121',15,0.09,90898,'success',1,1,'bitcoin'),(5,'se dio una transaccion exitosa','0x3456789',12,0.01,11212,'success',2,2,'bitcoin');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `iduser` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Danicho','a20180805@pucp.edu.pe','12345678'),(2,'CalebCa','a20175555@pucp.edu.pe','qwerty'),(3,'StuardoLu','micorreo@gmail.com','12345670');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wallet` (
  `idwallet` int NOT NULL,
  `address` varchar(45) NOT NULL,
  `user_iduser` int NOT NULL,
  `total_usd` varchar(45) NOT NULL,
  PRIMARY KEY (`idwallet`),
  KEY `fk_wallet_user_idx` (`user_iduser`),
  CONSTRAINT `fk_wallet_user` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet`
--

LOCK TABLES `wallet` WRITE;
/*!40000 ALTER TABLE `wallet` DISABLE KEYS */;
INSERT INTO `wallet` VALUES (1,'0x2134567890',1,'6000'),(2,'0x653712653',2,'5000'),(3,'0x126312356',3,'3560'),(4,'0x1863232929',1,'45');
/*!40000 ALTER TABLE `wallet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet_has_currency`
--

DROP TABLE IF EXISTS `wallet_has_currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wallet_has_currency` (
  `wallet_idwallet` int NOT NULL,
  `purchase_price` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `currency_idcurrency` int NOT NULL,
  PRIMARY KEY (`wallet_idwallet`,`currency_idcurrency`),
  KEY `fk_wallet_has_currency_currency1_idx` (`currency_idcurrency`),
  KEY `fk_wallet_has_currency_wallet1_idx` (`wallet_idwallet`),
  CONSTRAINT `fk_wallet_has_currency_currency1` FOREIGN KEY (`currency_idcurrency`) REFERENCES `currency` (`idcurrency`),
  CONSTRAINT `fk_wallet_has_currency_wallet1` FOREIGN KEY (`wallet_idwallet`) REFERENCES `wallet` (`idwallet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet_has_currency`
--

LOCK TABLES `wallet_has_currency` WRITE;
/*!40000 ALTER TABLE `wallet_has_currency` DISABLE KEYS */;
INSERT INTO `wallet_has_currency` VALUES (1,5000,2,1),(2,4000,3,3),(3,1000,10,1),(4,500,6,2);
/*!40000 ALTER TABLE `wallet_has_currency` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-13 21:39:05
