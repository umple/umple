-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.15.0.1751 modeling language!

CREATE DATABASE IF NOT EXISTS `elections`;
USE `elections`;

CREATE TABLE IF NOT EXISTS `elections`.`election`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*election Attributes*/
  id_election INT,
  name VARCHAR(255),
  description VARCHAR(255),
  PRIMARY KEY(id_election)

);



CREATE DATABASE IF NOT EXISTS `elections`;
USE `elections`;

CREATE TABLE IF NOT EXISTS `elections`.`poll`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*poll Associations*/
  election_id_election INT,
  
  /*poll Attributes*/
  id_poll INT,
  name VARCHAR(255),
  description VARCHAR(255),
  status VARCHAR(255) DEFAULT 'planned',
  PRIMARY KEY(id_poll, election_id_election)

);



ALTER TABLE `elections`.`poll` ADD CONSTRAINT `fk_election_id_election` FOREIGN KEY (`election_id_election`) REFERENCES `elections`.`election`(`id_election`);
