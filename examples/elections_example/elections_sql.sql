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
  id_election INT AUTO_INCREMENT,
  name VARCHAR(255),
  description VARCHAR(255),
  date DATE,
  PRIMARY KEY(id_election)

);



CREATE DATABASE IF NOT EXISTS `elections`;
USE `elections`;

CREATE TABLE IF NOT EXISTS `elections`.`position`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*position Attributes*/
  id_position INT AUTO_INCREMENT,
  name VARCHAR(255),
  description VARCHAR(255),
  PRIMARY KEY(id_position)

);



CREATE DATABASE IF NOT EXISTS `elections`;
USE `elections`;

CREATE TABLE IF NOT EXISTS `elections`.`candidate`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*candidate Attributes*/
  id_candidate INT AUTO_INCREMENT,
  name VARCHAR(255),
  address VARCHAR(255),
  telephone VARCHAR(255),
  PRIMARY KEY(id_candidate)

);



CREATE DATABASE IF NOT EXISTS `elections`;
USE `elections`;

CREATE TABLE IF NOT EXISTS `elections`.`election_for_position`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*election_for_position Associations*/
  election_id_election INT,
  position_id_position INT,
  
  /*election_for_position Attributes*/
  id_election_for_position INT AUTO_INCREMENT,
  PRIMARY KEY(id_election_for_position)

);



CREATE DATABASE IF NOT EXISTS `elections`;
USE `elections`;

CREATE TABLE IF NOT EXISTS `elections`.`candidature`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*candidature Associations*/
  candidate_id_candidate INT,
  election_for_position_id_election_for_position INT,
  
  /*candidature Attributes*/
  id_candidature INT AUTO_INCREMENT,
  PRIMARY KEY(id_candidature)

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
  id_poll INT AUTO_INCREMENT,
  number INT,
  name VARCHAR(255),
  description VARCHAR(255),
  status VARCHAR(255) DEFAULT 'planned',
  PRIMARY KEY(id_poll)

);



CREATE DATABASE IF NOT EXISTS `elections`;
USE `elections`;

CREATE TABLE IF NOT EXISTS `elections`.`voter`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*voter Attributes*/
  id_voter INT AUTO_INCREMENT,
  name VARCHAR(255),
  address VARCHAR(255),
  telephone VARCHAR(255),
  PRIMARY KEY(id_voter)

);





ALTER TABLE `elections`.`election_for_position` ADD CONSTRAINT `fk_electionforposition_election_id_election` FOREIGN KEY (`election_id_election`) REFERENCES `elections`.`election`(`id_election`);
ALTER TABLE `elections`.`election_for_position` ADD CONSTRAINT `fk_electionforposition_position_id_position` FOREIGN KEY (`position_id_position`) REFERENCES `elections`.`position`(`id_position`);

ALTER TABLE `elections`.`candidature` ADD CONSTRAINT `fk_candidature_candidate_id_candidate` FOREIGN KEY (`candidate_id_candidate`) REFERENCES `elections`.`candidate`(`id_candidate`);
ALTER TABLE `elections`.`candidature` ADD CONSTRAINT `fk_candidature_election_for_position_id_election_for_position` FOREIGN KEY (`election_for_position_id_election_for_position`) REFERENCES `elections`.`election_for_position`(`id_election_for_position`);

ALTER TABLE `elections`.`poll` ADD CONSTRAINT `fk_poll_election_id_election` FOREIGN KEY (`election_id_election`) REFERENCES `elections`.`election`(`id_election`);

