DROP DATABASE IF EXISTS locker;

CREATE DATABASE locker;

use locker;


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) not null PRIMARY KEY AUTO_INCREMENT,
  `open_id` VARCHAR(60) not null,
  `nick_name` VARCHAR(60) ,
  `avatar_url` VARCHAR(255) ,
  `gender` VARCHAR(10)  ,
  `city` VARCHAR(30) ,
  `province` VARCHAR(30),
  `country` VARCHAR(30),
  `language` VARCHAR(30),
  `union_id` VARCHAR(60),
  `phone` VARCHAR(30)
)ENGINE =InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET =utf8;

DROP TABLE IF EXISTS `lockers`;
CREATE TABLE `lockers`(
  `lockers_id` VARCHAR(255) not NULL PRIMARY KEY,
  `box_total` INT not NULL ,
  `box_used` INT NOT NULL ,
  `addr` VARCHAR(255) NOT NULL ,
  `is_full` INT NOT NULL DEFAULT 0 ,
  `is_delete` INT NOT NULL DEFAULT 0
)ENGINE =InnoDB DEFAULT CHARSET =utf8;


DROP TABLE IF EXISTS `lockers_box`;
CREATE TABLE `lockers_box`(
  `lockers_id` VARCHAR(255) NOT NULL,
  `id` INT NOT NULL ,
  `box_id` INT NOT NULL ,
  `is_used` INT NOT NULL DEFAULT 0 ,
  `avail` int  NOT NULL DEFAULT 1
)ENGINE =InnoDB DEFAULT CHARSET =utf8;


DROP TABLE IF EXISTS `box`;
CREATE TABLE `box`(
  `box_id` INT(11) not NULL PRIMARY KEY AUTO_INCREMENT,
  `lockers_id` VARCHAR(255) NOT NULL ,
  `type_id` int(11) not null
)ENGINE =InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET =utf8;

DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`(
  `type_id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `type_name` VARCHAR(30) NOT NULL,
  `cost` int(11) NOT NULL
)ENGINE =InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET =utf8;

DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`(
  `log_id` INT(11) not NULL PRIMARY KEY AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL ,
  `locker_id` VARCHAR(255) NOT NULL ,
  `id` INT(11) NOT NULL ,
  `create_time` VARCHAR(20) NOT NULL ,
  `end_time` VARCHAR(20) not null,
  `money` INT(11) not NULL DEFAULT 0
)ENGINE =InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET =utf8;
