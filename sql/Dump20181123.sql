CREATE DATABASE  IF NOT EXISTS `librarymsswing` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `librarymsswing`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: librarymsswing
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `books` (
  `book_id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `available_quantity` int(10) NOT NULL,
  `issued_quantity` int(10) NOT NULL DEFAULT '0',
  `added_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`book_id`),
  UNIQUE KEY `callno` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES ('GEO1','Geography','A','P',18,2,'2018-11-23 12:52:35');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issued_books`
--

DROP TABLE IF EXISTS `issued_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `issued_books` (
  `book_id` varchar(100) NOT NULL,
  `student_id` int(5) NOT NULL,
  `librarian_id` int(5) NOT NULL,
  `issue_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`book_id`,`student_id`),
  KEY `studentid` (`student_id`),
  KEY `bookcallno` (`book_id`),
  KEY `fk_issued_books_librarian1_idx` (`librarian_id`),
  CONSTRAINT `fk_issued_books_librarian1` FOREIGN KEY (`librarian_id`) REFERENCES `librarian` (`id`),
  CONSTRAINT `issuebooks_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `issuebooks_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issued_books`
--

LOCK TABLES `issued_books` WRITE;
/*!40000 ALTER TABLE `issued_books` DISABLE KEYS */;
INSERT INTO `issued_books` VALUES ('GEO1',2,1,'2018-11-23 12:50:15');
/*!40000 ALTER TABLE `issued_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librarian`
--

DROP TABLE IF EXISTS `librarian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `librarian` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `city` varchar(100) NOT NULL,
  `contact` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `contact_UNIQUE` (`contact`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librarian`
--

LOCK TABLES `librarian` WRITE;
/*!40000 ALTER TABLE `librarian` DISABLE KEYS */;
INSERT INTO `librarian` VALUES (1,'SD','SD','SD','SD','SD','123');
/*!40000 ALTER TABLE `librarian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `city` varchar(100) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `librarian_id` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `contact_UNIQUE` (`contact`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_student_librarian1_idx` (`librarian_id`),
  CONSTRAINT `fk_student_librarian1` FOREIGN KEY (`librarian_id`) REFERENCES `librarian` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'SDS','SDS','SDS','SDS','SDS',1),(2,'S','S','ss','s','s',1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'librarymsswing'
--

--
-- Dumping routines for database 'librarymsswing'
--
/*!50003 DROP PROCEDURE IF EXISTS `issue_book` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `issue_book`(BookId varchar(100), StudentId int, LibrarianId int, OUT success int)
BEGIN
   
    DECLARE available int(10);
    DECLARE issued int(10);
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
		SET success = -1;
        ROLLBACK;
    END;
	
    SET SQL_SAFE_UPDATES = 0;
	SET AUTOCOMMIT = 0;
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    
	START TRANSACTION;
		SET success = 0;
    
		SELECT available_quantity, issued_quantity INTO available, issued FROM books WHERE book_id = BookId FOR UPDATE;
        IF available > 0 THEN
			INSERT INTO issued_books (book_id, student_id, librarian_id) VALUES (BookId, StudentId, LibrarianId);
            
            IF ROW_COUNT() > 0 THEN
				SET available = available - 1;
                SET issued = issued + 1;
				UPDATE books SET available_quantity = available, issued_quantity = issued WHERE book_id = BookId;
                
                IF ROW_COUNT() > 0 THEN
					SET success = 0;
				ELSE 
					SET success = 3;
					ROLLBACK;
				END IF;
			ELSE
				SET success = 2;
				ROLLBACK;
            END IF;
		ELSE 
			SET success = 1;
			ROLLBACK;
        END IF;
        
    COMMIT;
    
    SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
    SET AUTOCOMMIT = 1;
    SET SQL_SAFE_UPDATES = 1;
    
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `return_book` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `return_book`(BookId varchar(100), StudentId int, OUT success int)
BEGIN
   
    DECLARE available int(10);
    DECLARE issued int(10);
    DECLARE id varchar(100);
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
		SET success = -1;
        ROLLBACK;
    END;
	
    SET SQL_SAFE_UPDATES = 0;
	SET AUTOCOMMIT = 0;
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    
	START TRANSACTION;
		SET success = 0;
    
		SELECT book_id INTO id FROM issued_books WHERE book_id = BookId AND student_id = StudentId FOR UPDATE;
        IF id IS NOT NULL THEN
			DELETE FROM issued_books WHERE book_id = BookId AND student_id = StudentId;
            
            IF ROW_COUNT() > 0 THEN
				UPDATE books SET available_quantity = (available_quantity+1), issued_quantity = (issued_quantity-1) WHERE book_id = BookId;
                
                IF ROW_COUNT() > 0 THEN
					SET success = 0;
				ELSE 
					SET success = 3;
					ROLLBACK;
				END IF;
			ELSE
				SET success = 2;
				ROLLBACK;
            END IF;
		ELSE 
			SET success = 1;
			ROLLBACK;
        END IF;
        
    COMMIT;
    SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
    SET AUTOCOMMIT = 1;
    SET SQL_SAFE_UPDATES = 1;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-23 20:21:49
