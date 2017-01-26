
--

CREATE DATABASE IF NOT EXISTS ibook;
USE ibook;

--
-- Definition of table `flights`
--


DROP TABLE IF EXISTS `books`;
DROP TABLE IF EXISTS `booksauthor`;
DROP TABLE IF EXISTS `categories`;
DROP TABLE IF EXISTS `bookgenre`;
DROP TABLE IF EXISTS `keywords`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `readers`;
DROP TABLE IF EXISTS `employees`;
DROP TABLE IF EXISTS `purchases`;
DROP TABLE IF EXISTS `reviews`;
DROP TABLE IF EXISTS `searchnumber`;

CREATE TABLE `books` (
  bookid int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `language` varchar(45) NOT NULL,
  `summary` varchar(510) NOT NULL,
  `tableofcontents` varchar(510) NOT NULL,
  `price` varchar(45) NOT NULL,
  `visibility` int NOT NULL default 1,
  PRIMARY KEY  (bookid)
);

CREATE TABLE `booksauthor` (
  bookid int NOT NULL,
  `author` varchar(45) NOT NULL,
  PRIMARY KEY  (bookid, `author`)
);

CREATE TABLE `categories` (
 `category` varchar(45) NOT NULL,
 `genre` varchar(45) NOT NULL UNIQUE,
  PRIMARY KEY  (`category`,`genre`)
);

CREATE TABLE `bookgenre` (
  bookid int NOT NULL,
 `genre` varchar(45) NOT NULL,
  PRIMARY KEY  (bookid,`genre`)
);

CREATE TABLE `keywords` (
  bookid int NOT NULL,
 `keyword` varchar(45) NOT NULL,
  PRIMARY KEY  (bookid,`keyword`)
);

CREATE TABLE `users` (
 `username` varchar(45) NOT NULL,
 `password` varchar(45) NOT NULL,
 `firstname` varchar(45) NOT NULL,
 `lastname` varchar(45) NOT NULL,
 `ssn` varchar(45) NOT NULL,
 `type` int DEFAULT 0,
 `isloggedin` int DEFAULT 0,
  PRIMARY KEY  (`username`)
);

CREATE TABLE `readers` (
 `username` varchar(45) NOT NULL,
 `paymentmethod` varchar(45) ,
 `subscription` varchar(45) ,
 `date` varchar (45),
 `isfrozen` int DEFAULT 1,
  PRIMARY KEY  (`username`)
);

CREATE TABLE `employees` (
 `username` varchar(45) NOT NULL,
 `employeeid` varchar(45) NOT NULL,
 `email` varchar(45) NOT NULL,
 `department` varchar(45) NOT NULL,
 `role` varchar(45) NOT NULL,
  PRIMARY KEY  (`username`)
);

CREATE TABLE `purchases` (
 bookid int not null,
 `username` varchar(45) NOT NULL,
 `date` varchar(45) NOT NULL,
  PRIMARY KEY  (`username`, bookid)
);

CREATE TABLE `reviews` (
 bookid int not null,
 `username` varchar(45) NOT NULL,
 `review` varchar(255) NOT NULL,
 `visibility` int DEFAULT 0,
  PRIMARY KEY  (`username`, bookid)
);

CREATE TABLE `searchnumber` (
  bookid int not null,
  `date` date NOT NULL,
  `numberofclicks` int DEFAULT 0,
  PRIMARY KEY  (bookid, `date`)
);




