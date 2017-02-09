/*
SQLyog Ultimate v10.42 
MySQL - 5.7.17-0ubuntu0.16.04.1 : Database - challengemate
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`challengemate` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `challengemate`;

/*Table structure for table `challenge` */

DROP TABLE IF EXISTS `challenge`;

CREATE TABLE `challenge` (
  `id` float NOT NULL,
  `categoryid` float DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `gifimage` varchar(100) DEFAULT NULL,
  `points` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoryid_fk` (`categoryid`),
  CONSTRAINT `categoryid_fk` FOREIGN KEY (`categoryid`) REFERENCES `challenge_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `challenge` */

/*Table structure for table `challenge_category` */

DROP TABLE IF EXISTS `challenge_category`;

CREATE TABLE `challenge_category` (
  `id` float NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `points` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `challenge_category` */

/*Table structure for table `challengemate` */

DROP TABLE IF EXISTS `challengemate`;

CREATE TABLE `challengemate` (
  `id` float NOT NULL,
  `fromfbuserid` varchar(255) DEFAULT NULL,
  `tofbuserid` varchar(255) DEFAULT NULL,
  `challengeid` float DEFAULT NULL,
  `challengetype` int(1) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `expiredatetime` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `rating` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fromfbuserid_fk` (`fromfbuserid`),
  KEY `tofbuserid_fk` (`tofbuserid`),
  KEY `challengeid_fk` (`challengeid`),
  CONSTRAINT `challengeid_fk` FOREIGN KEY (`challengeid`) REFERENCES `challenge` (`id`),
  CONSTRAINT `fromfbuserid_fk` FOREIGN KEY (`fromfbuserid`) REFERENCES `users` (`fbuserid`),
  CONSTRAINT `tofbuserid_fk` FOREIGN KEY (`tofbuserid`) REFERENCES `users` (`fbuserid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `challengemate` */

/*Table structure for table `custom_challenge_category` */

DROP TABLE IF EXISTS `custom_challenge_category`;

CREATE TABLE `custom_challenge_category` (
  `id` float NOT NULL AUTO_INCREMENT,
  `fbuserid` varchar(255) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `video` varchar(100) DEFAULT NULL,
  `categoryid` float DEFAULT NULL,
  PRIMARY KEY (`id`,`fbuserid`),
  KEY `fbuserid_c_c_c_fk` (`fbuserid`),
  KEY `categoryid_c_c_c_fk` (`categoryid`),
  CONSTRAINT `categoryid_c_c_c_fk` FOREIGN KEY (`categoryid`) REFERENCES `challenge` (`id`),
  CONSTRAINT `fbuserid_c_c_c_fk` FOREIGN KEY (`fbuserid`) REFERENCES `users` (`fbuserid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `custom_challenge_category` */

/*Table structure for table `dashboard` */

DROP TABLE IF EXISTS `dashboard`;

CREATE TABLE `dashboard` (
  `fbuserid` varchar(255) NOT NULL,
  `givenchallenges` bigint(11) DEFAULT NULL,
  `givenchallsuccess` bigint(11) DEFAULT NULL,
  `givenchallfailed` bigint(11) DEFAULT NULL,
  `givenchallrejected` bigint(11) DEFAULT NULL,
  `mychallenges` bigint(11) DEFAULT NULL,
  `mychallsuccess` bigint(11) DEFAULT NULL,
  `mychallfailed` bigint(11) DEFAULT NULL,
  `mychallrejected` bigint(11) DEFAULT NULL,
  `givenchallpoints` bigint(11) DEFAULT NULL,
  `mychallpoints` bigint(11) DEFAULT NULL,
  `mychalltotalpoints` bigint(11) DEFAULT NULL,
  `redeempoints` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`fbuserid`),
  CONSTRAINT `fbuserid_d_fk` FOREIGN KEY (`fbuserid`) REFERENCES `users` (`fbuserid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dashboard` */

/*Table structure for table `points_redeem` */

DROP TABLE IF EXISTS `points_redeem`;

CREATE TABLE `points_redeem` (
  `fbuserid` varchar(255) NOT NULL,
  `rewardid` float DEFAULT NULL,
  `addressid` float DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`fbuserid`),
  KEY `rewardid_fk` (`rewardid`),
  KEY `addressid_fk` (`addressid`),
  CONSTRAINT `addressid_fk` FOREIGN KEY (`addressid`) REFERENCES `user_address` (`id`),
  CONSTRAINT `fbuserid_p_r_fk` FOREIGN KEY (`fbuserid`) REFERENCES `users` (`fbuserid`),
  CONSTRAINT `rewardid_fk` FOREIGN KEY (`rewardid`) REFERENCES `reward_goodies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `points_redeem` */

/*Table structure for table `reward_goodies` */

DROP TABLE IF EXISTS `reward_goodies`;

CREATE TABLE `reward_goodies` (
  `id` float NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `points` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reward_goodies` */

/*Table structure for table `reward_goodies_images` */

DROP TABLE IF EXISTS `reward_goodies_images`;

CREATE TABLE `reward_goodies_images` (
  `rewardid` float NOT NULL,
  `images` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`rewardid`),
  CONSTRAINT `rewardid_r_g_i_fk` FOREIGN KEY (`rewardid`) REFERENCES `reward_goodies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reward_goodies_images` */

/*Table structure for table `user_address` */

DROP TABLE IF EXISTS `user_address`;

CREATE TABLE `user_address` (
  `id` float NOT NULL,
  `fbuserid` varchar(255) NOT NULL,
  `address` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`,`fbuserid`),
  KEY `fbuserid_fk` (`fbuserid`),
  CONSTRAINT `fbuserid_fk` FOREIGN KEY (`fbuserid`) REFERENCES `users` (`fbuserid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_address` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `fbuserid` varchar(255) NOT NULL,
  `mobile` bigint(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `profilepic` varchar(100) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL COMMENT 'registered date time',
  PRIMARY KEY (`fbuserid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users` */

/*Table structure for table `users_activity` */

DROP TABLE IF EXISTS `users_activity`;

CREATE TABLE `users_activity` (
  `id` float NOT NULL,
  `fbuserid` varchar(255) DEFAULT NULL,
  `logindatetime` datetime DEFAULT NULL COMMENT 'login date time',
  `device` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fbuserid_ua_fk` (`fbuserid`),
  CONSTRAINT `fbuserid_ua_fk` FOREIGN KEY (`fbuserid`) REFERENCES `users` (`fbuserid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users_activity` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
