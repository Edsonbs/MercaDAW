-- MariaDB dump 10.19-11.3.2-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: MercaDAW
-- ------------------------------------------------------
-- Server version	11.3.2-MariaDB-1:11.3.2+maria~ubu2204

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary table structure for view `CLIENTES_VIEW`
--

DROP TABLE IF EXISTS `CLIENTES_VIEW`;
/*!50001 DROP VIEW IF EXISTS `CLIENTES_VIEW`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `CLIENTES_VIEW` AS SELECT
 1 AS `ID`,
  1 AS `CODIGO_POSTAL`,
  1 AS `CORREO_ELECTRONICO` */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `COMPRA_VIEW`
--

DROP TABLE IF EXISTS `COMPRA_VIEW`;
/*!50001 DROP VIEW IF EXISTS `COMPRA_VIEW`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `COMPRA_VIEW` AS SELECT
 1 AS `CLIENTES_ID`,
  1 AS `PRODUCTOS_ID`,
  1 AS `ID_COMPRA`,
  1 AS `CANTIDAD`,
  1 AS `FECHA_COMPRA` */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `EMPLEADOS_VIEW`
--

DROP TABLE IF EXISTS `EMPLEADOS_VIEW`;
/*!50001 DROP VIEW IF EXISTS `EMPLEADOS_VIEW`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `EMPLEADOS_VIEW` AS SELECT
 1 AS `ID`,
  1 AS `NOMBRE`,
  1 AS `APELLIDOS`,
  1 AS `CATEGORIA` */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `PRODUCTOS_VIEW`
--

DROP TABLE IF EXISTS `PRODUCTOS_VIEW`;
/*!50001 DROP VIEW IF EXISTS `PRODUCTOS_VIEW`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `PRODUCTOS_VIEW` AS SELECT
 1 AS `ID`,
  1 AS `NOMBRE`,
  1 AS `MARCA`,
  1 AS `CATEGORIA`,
  1 AS `PRECIO_EN_EUROS`,
  1 AS `IVA`,
  1 AS `ALTURA_EN_METROS`,
  1 AS `ANCHURA_EN_METROS`,
  1 AS `PESO_EN_KG`,
  1 AS `NUMERO_ELEMENTOS`,
  1 AS `DESCRIPCION` */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `STOCK_VIEW`
--

DROP TABLE IF EXISTS `STOCK_VIEW`;
/*!50001 DROP VIEW IF EXISTS `STOCK_VIEW`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `STOCK_VIEW` AS SELECT
 1 AS `PRODUCTOS_ID`,
  1 AS `CANTIDAD` */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id` int(5) NOT NULL,
  `codigo_postal` int(5) DEFAULT NULL,
  `correo_electronico` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES
(1,28001,'juan.perez1@example.com'),
(2,28001,'maria.garcia2@example.com'),
(3,28002,'luis.martinez3@example.com'),
(4,28002,'ana.lopez4@example.com'),
(5,28003,'jose.sanchez5@example.com'),
(6,28003,'carmen.fernandez6@example.com'),
(7,28004,'david.gonzalez7@example.com'),
(8,28004,'laura.rodriguez8@example.com'),
(9,28005,'javier.hernandez9@example.com'),
(10,28005,'elena.diaz10@example.com'),
(11,28006,'sergio.ruiz11@example.com'),
(12,28006,'isabel.morales12@example.com'),
(13,28007,'carlos.romero13@example.com'),
(14,28007,'alicia.torres14@example.com'),
(15,28008,'pablo.gimenez15@example.com'),
(16,28008,'sonia.martin16@example.com'),
(17,28001,'fernando.vazquez17@example.com'),
(18,28001,'laura.garcia18@example.com'),
(19,28002,'jorge.perez19@example.com'),
(20,28002,'luisa.sanchez20@example.com'),
(21,28003,'mario.fernandez21@example.com'),
(22,28003,'eva.martinez22@example.com'),
(23,28004,'miguel.lopez23@example.com'),
(24,28004,'rosa.gomez24@example.com'),
(25,28005,'alberto.ruiz25@example.com');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `clientes_id` int(5) NOT NULL,
  `productos_id` int(5) NOT NULL,
  `id_compra` int(10) DEFAULT NULL,
  `cantidad` int(10) DEFAULT NULL,
  `fecha_compra` date DEFAULT NULL,
  PRIMARY KEY (`clientes_id`,`productos_id`),
  KEY `compra_productos_fk` (`productos_id`),
  CONSTRAINT `compra_clientes_fk` FOREIGN KEY (`clientes_id`) REFERENCES `clientes` (`id`),
  CONSTRAINT `compra_productos_fk` FOREIGN KEY (`productos_id`) REFERENCES `productos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `id` int(5) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES
(1,'Juan','Perez','REPONEDOR'),
(2,'Ana','Garcia','REPONEDOR'),
(3,'Luis','Rodriguez','REPONEDOR'),
(4,'Maria','Lopez','REPONEDOR'),
(5,'Carlos','Hernandez','REPONEDOR'),
(6,'Elena','Martinez','CAJERO'),
(7,'Miguel','Gonzalez','CAJERO'),
(8,'Lucia','Fernandez','CAJERO'),
(9,'Pablo','Gomez','ENCARGADO'),
(10,'Sofia','Diaz','ENCARGADO'),
(11,'David','Alvarez','OTRO'),
(12,'Laura','Moreno','OTRO'),
(13,'Sergio','Muñoz','OTRO'),
(14,'Raquel','Jimenez','OTRO'),
(15,'Jorge','Ruiz','OTRO'),
(16,'Sara','Sanchez','OTRO'),
(17,'Adrian','Ramirez','OTRO'),
(18,'Paula','Torres','OTRO'),
(19,'Alberto','Flores','OTRO'),
(20,'Isabel','Navarro','OTRO');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `id` int(5) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  `precio_en_euros` decimal(10,2) DEFAULT NULL,
  `iva` decimal(5,2) DEFAULT NULL,
  `altura_en_metros` decimal(5,2) DEFAULT NULL,
  `anchura_en_metros` decimal(5,2) DEFAULT NULL,
  `peso_en_kg` decimal(5,2) DEFAULT NULL,
  `numero_elementos` int(5) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES
(1,'Leche Entera','Puleva','ALIMENTACION',0.89,0.04,0.20,0.10,1.00,1,'Leche entera 1L'),
(2,'Pan Integral','Bimbo','ALIMENTACION',1.50,0.04,0.10,0.20,0.50,1,'Pan integral 500g'),
(3,'Arroz','SOS','ALIMENTACION',2.00,0.04,0.30,0.10,1.00,1,'Arroz 1kg'),
(4,'Pasta','Gallo','ALIMENTACION',1.20,0.04,0.20,0.10,1.00,1,'Pasta 1kg'),
(5,'Aceite de Oliva','Carbonell','ALIMENTACION',5.00,0.04,0.40,0.10,1.00,1,'Aceite de oliva 1L'),
(6,'Tomate Frito','Orlando','ALIMENTACION',1.00,0.04,0.15,0.10,0.50,1,'Tomate frito 500g'),
(7,'Azúcar','Azucarera','ALIMENTACION',0.80,0.04,0.20,0.10,1.00,1,'Azúcar 1kg'),
(8,'Sal','Sal Costa','ALIMENTACION',0.40,0.04,0.10,0.10,0.50,1,'Sal 1kg'),
(9,'Café','Nescafé','ALIMENTACION',3.00,0.04,0.20,0.10,0.50,1,'Café 500g'),
(10,'Lechuga','Florette','ALIMENTACION',1.00,0.04,0.30,0.20,0.50,1,'Lechuga fresca'),
(11,'Manzanas','Pink Lady','ALIMENTACION',2.50,0.04,0.15,0.15,1.00,6,'Manzanas 1kg'),
(12,'Zumo de Naranja','Don Simón','ALIMENTACION',2.00,0.04,0.30,0.10,1.00,1,'Zumo de naranja 1L'),
(13,'Yogur Natural','Danone','ALIMENTACION',2.00,0.04,0.10,0.10,0.50,8,'Yogur natural 8x125g'),
(14,'Queso Rallado','El Caserío','ALIMENTACION',2.50,0.04,0.10,0.10,0.20,1,'Queso rallado 200g'),
(15,'Cereales','Kelloggs','ALIMENTACION',3.50,0.04,0.30,0.10,0.50,1,'Cereales 500g'),
(16,'Huevos','Coren','ALIMENTACION',1.50,0.04,0.10,0.10,0.50,12,'Huevos 12 unidades'),
(17,'Mantequilla','Central Lechera Asturiana','ALIMENTACION',1.80,0.04,0.10,0.10,0.25,1,'Mantequilla 250g'),
(18,'Cerveza','Mahou','ALIMENTACION',0.60,0.04,0.15,0.10,0.50,1,'Cerveza 330ml'),
(19,'Agua Mineral','Font Vella','ALIMENTACION',0.50,0.04,0.30,0.10,1.00,1,'Agua mineral 1.5L'),
(20,'Vino Tinto','Rioja','ALIMENTACION',5.00,0.04,0.30,0.10,1.00,1,'Vino tinto 750ml'),
(21,'Champú','HyS','COSMETICA',3.50,0.21,0.25,0.10,0.50,1,'Champú revitalizante 500ml'),
(22,'Gel de Ducha','Dove','COSMETICA',2.50,0.21,0.30,0.10,0.50,1,'Gel de ducha 500ml'),
(23,'Crema Hidratante','Nivea','COSMETICA',4.00,0.21,0.20,0.10,0.50,1,'Crema hidratante 200ml'),
(24,'Desodorante','Rexona','COSMETICA',2.00,0.21,0.20,0.10,0.50,1,'Desodorante 150ml'),
(25,'Pasta de Dientes','Colgate','COSMETICA',1.50,0.21,0.15,0.10,0.50,1,'Pasta de dientes 100ml'),
(26,'Jabón Facial','La Toja','COSMETICA',3.00,0.21,0.10,0.10,0.50,1,'Jabón facial 150g'),
(27,'Lápiz Labial','Maybelline','COSMETICA',5.00,0.21,0.05,0.05,0.20,1,'Lápiz labial rojo'),
(28,'Perfume','Chanel','COSMETICA',20.00,0.21,0.10,0.05,0.20,1,'Perfume 50ml'),
(29,'Maquillaje','Loréal','COSMETICA',10.00,0.21,0.10,0.05,0.20,1,'Maquillaje 30ml'),
(30,'Crema Solar','Nivea Sun','COSMETICA',8.00,0.21,0.20,0.10,0.50,1,'Crema solar 200ml'),
(31,'Jabón de Manos','Dove','COSMETICA',1.50,0.21,0.15,0.10,0.50,1,'Jabón de manos 250ml'),
(32,'Mascarilla Facial','Garnier','COSMETICA',2.50,0.21,0.05,0.05,0.20,1,'Mascarilla facial'),
(33,'Loción Corporal','Vaseline','COSMETICA',5.00,0.21,0.20,0.10,0.50,1,'Loción corporal 400ml'),
(34,'Crema Antiarrugas','Olay','COSMETICA',10.00,0.21,0.05,0.05,0.20,1,'Crema antiarrugas 50ml'),
(35,'Desmaquillante','Garnier','COSMETICA',3.00,0.21,0.10,0.10,0.50,1,'Desmaquillante 200ml'),
(36,'Acondicionador','Pantene','COSMETICA',4.00,0.21,0.25,0.10,0.50,1,'Acondicionador 250ml'),
(37,'Tónico Facial','Clinique','COSMETICA',12.00,0.21,0.15,0.10,0.50,1,'Tónico facial 200ml'),
(38,'Champú Anticaspa','HyS','COSMETICA',4.00,0.21,0.25,0.10,0.50,1,'Champú anticaspa 400ml'),
(39,'Esmalte de Uñas','Essie','COSMETICA',9.00,0.21,0.05,0.05,0.10,1,'Esmalte de uñas 15ml'),
(40,'Serum Facial','The Ordinary','COSMETICA',7.00,0.21,0.05,0.05,0.10,1,'Serum facial 30ml'),
(41,'Detergente Líquido','Ariel','DROGUERIA',5.00,0.10,0.40,0.20,2.00,1,'Detergente líquido 2L'),
(42,'Suavizante','Mimosín','DROGUERIA',3.00,0.10,0.30,0.20,2.00,1,'Suavizante 1.5L'),
(43,'Lavavajillas','Fairy','DROGUERIA',2.50,0.10,0.20,0.10,1.00,1,'Lavavajillas 750ml'),
(44,'Lejía','Conejo','DROGUERIA',1.00,0.10,0.30,0.10,1.00,1,'Lejía 1L'),
(45,'Multiusos','KH-7','DROGUERIA',3.00,0.10,0.20,0.10,1.00,1,'Multiusos 750ml'),
(46,'Ambientador','Air Wick','DROGUERIA',4.00,0.10,0.20,0.10,0.50,1,'Ambientador 250ml'),
(47,'Desinfectante','Sanytol','DROGUERIA',3.50,0.10,0.20,0.10,1.00,1,'Desinfectante 1L'),
(48,'Limpiacristales','Cristasol','DROGUERIA',2.00,0.10,0.20,0.10,1.00,1,'Limpiacristales 750ml'),
(49,'Papel Higiénico','Scottex','DROGUERIA',4.00,0.10,0.40,0.20,0.50,12,'Papel higiénico 12 rollos'),
(50,'Toallitas','Dodot','DROGUERIA',3.00,0.10,0.30,0.20,1.00,64,'Toallitas húmedas 64 unidades'),
(51,'Esponja','Spontex','DROGUERIA',1.50,0.10,0.10,0.10,0.10,1,'Esponja de cocina'),
(52,'Fregasuelos','Asevi','DROGUERIA',2.50,0.10,0.30,0.10,1.00,1,'Fregasuelos 1L'),
(53,'Cepillo','Vileda','DROGUERIA',5.00,0.10,0.40,0.20,1.00,1,'Cepillo de barrer'),
(54,'Recambio de Mopa','Swiffer','DROGUERIA',4.00,0.10,0.20,0.10,1.00,10,'Recambio de mopa 10 unidades'),
(55,'Bolsa de Basura','Albal','DROGUERIA',3.00,0.10,0.30,0.20,1.00,20,'Bolsa de basura 20 unidades'),
(56,'Desatascador','Tiret','DROGUERIA',5.00,0.10,0.40,0.20,1.00,1,'Desatascador 1L'),
(57,'Quitamanchas','Vanish','DROGUERIA',4.50,0.10,0.30,0.20,1.00,1,'Quitamanchas 750ml'),
(58,'Blanqueador','Neutrex','DROGUERIA',2.00,0.10,0.30,0.10,1.00,1,'Blanqueador 1L'),
(59,'Insecticida','Bloom','DROGUERIA',3.50,0.10,0.20,0.10,1.00,1,'Insecticida 400ml'),
(60,'Limpiador WC','Harpic','DROGUERIA',2.50,0.10,0.20,0.10,1.00,1,'Limpiador WC 750ml'),
(61,'ejemplo WC','ejemplo','DROGUERIA',2.50,0.10,0.20,0.10,1.00,1,'ejemplo');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `productos_id` int(5) NOT NULL,
  `cantidad` int(10) DEFAULT NULL,
  PRIMARY KEY (`productos_id`),
  CONSTRAINT `stock_productos_fk` FOREIGN KEY (`productos_id`) REFERENCES `productos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES
(1,1),
(2,6),
(3,30),
(4,41),
(5,15),
(6,26),
(7,47),
(8,58),
(9,9),
(10,10),
(11,1),
(12,22),
(13,13),
(14,14),
(15,15),
(16,16),
(17,17),
(18,18),
(19,39),
(20,20),
(21,21),
(22,22),
(23,23),
(24,24),
(25,25),
(26,26),
(27,57),
(28,28),
(29,26),
(30,30),
(31,31),
(32,32),
(33,13),
(34,34),
(35,35),
(36,36),
(37,35),
(38,38),
(39,39),
(40,40),
(41,41),
(42,42),
(43,43),
(44,44),
(45,15),
(46,46),
(47,47),
(48,48),
(49,42),
(50,50),
(51,1),
(52,2),
(53,3),
(54,42),
(55,35),
(56,56),
(57,77),
(58,18),
(59,39),
(60,10),
(61,1);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `CLIENTES_VIEW`
--

/*!50001 DROP VIEW IF EXISTS `CLIENTES_VIEW`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `CLIENTES_VIEW` AS select `clientes`.`id` AS `ID`,`clientes`.`codigo_postal` AS `CODIGO_POSTAL`,`clientes`.`correo_electronico` AS `CORREO_ELECTRONICO` from `clientes` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `COMPRA_VIEW`
--

/*!50001 DROP VIEW IF EXISTS `COMPRA_VIEW`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `COMPRA_VIEW` AS select `compra`.`clientes_id` AS `CLIENTES_ID`,`compra`.`productos_id` AS `PRODUCTOS_ID`,`compra`.`id_compra` AS `ID_COMPRA`,`compra`.`cantidad` AS `CANTIDAD`,`compra`.`fecha_compra` AS `FECHA_COMPRA` from `compra` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `EMPLEADOS_VIEW`
--

/*!50001 DROP VIEW IF EXISTS `EMPLEADOS_VIEW`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `EMPLEADOS_VIEW` AS select `empleados`.`id` AS `ID`,`empleados`.`nombre` AS `NOMBRE`,`empleados`.`apellidos` AS `APELLIDOS`,`empleados`.`categoria` AS `CATEGORIA` from `empleados` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `PRODUCTOS_VIEW`
--

/*!50001 DROP VIEW IF EXISTS `PRODUCTOS_VIEW`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `PRODUCTOS_VIEW` AS select `productos`.`id` AS `ID`,`productos`.`nombre` AS `NOMBRE`,`productos`.`marca` AS `MARCA`,`productos`.`categoria` AS `CATEGORIA`,`productos`.`precio_en_euros` AS `PRECIO_EN_EUROS`,`productos`.`iva` AS `IVA`,`productos`.`altura_en_metros` AS `ALTURA_EN_METROS`,`productos`.`anchura_en_metros` AS `ANCHURA_EN_METROS`,`productos`.`peso_en_kg` AS `PESO_EN_KG`,`productos`.`numero_elementos` AS `NUMERO_ELEMENTOS`,`productos`.`descripcion` AS `DESCRIPCION` from `productos` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `STOCK_VIEW`
--

/*!50001 DROP VIEW IF EXISTS `STOCK_VIEW`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `STOCK_VIEW` AS select `stock`.`productos_id` AS `PRODUCTOS_ID`,`stock`.`cantidad` AS `CANTIDAD` from `stock` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-19 11:52:12
