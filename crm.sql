/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-23 21:40:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `desc` varchar(200) DEFAULT NULL,
  `book_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `cust_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`),
  KEY `cust_id` (`cust_id`),
  CONSTRAINT `bookinfo_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
INSERT INTO `bookinfo` VALUES ('6', 'testaaa', 'a', '2018-07-08 00:00:00', '2018-07-01 00:00:00', '1');
INSERT INTO `bookinfo` VALUES ('9', 'test', 'aa', '2018-07-21 00:00:00', '2018-07-14 00:00:00', '1');
INSERT INTO `bookinfo` VALUES ('11', 'dd', 'd', '2018-07-14 00:00:00', '2018-07-15 00:00:00', '6');

-- ----------------------------
-- Table structure for contacts
-- ----------------------------
DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts` (
  `cont_id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_id` int(11) NOT NULL,
  `cont_name` varchar(20) NOT NULL,
  `cont_dept` varchar(50) NOT NULL,
  `cont_position` varchar(50) NOT NULL,
  `cont_telephone` varchar(20) DEFAULT NULL,
  `cont_mobile` varchar(20) NOT NULL,
  `cont_email` varchar(50) DEFAULT NULL,
  `cont_qq` varchar(20) DEFAULT NULL,
  `tech_degree` char(1) DEFAULT NULL,
  `more_info` varchar(200) DEFAULT NULL,
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cont_id`),
  KEY `cust_id` (`cust_id`),
  CONSTRAINT `contacts_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contacts
-- ----------------------------
INSERT INTO `contacts` VALUES ('5', '1', '張三', 'aa', 'aaaa', 'aaa', 'aaa', 'aaa', 'aaa', '1', 'aaaa', '2018-07-14 01:04:14');
INSERT INTO `contacts` VALUES ('15', '6', '李四', '技术部', '员工', '无', '3123131321', '123', '3123123', '2', 'aaaa', '2018-07-14 08:09:40');

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(50) NOT NULL,
  `cust_type` int(11) NOT NULL,
  `cust_background` int(11) NOT NULL,
  `listed` char(1) NOT NULL,
  `reg_capital` int(11) NOT NULL,
  `year_sales` int(11) DEFAULT NULL,
  `entp_scale` int(11) DEFAULT NULL,
  `tester_no` int(11) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `zip_code` varchar(15) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `main_products` varchar(200) DEFAULT NULL,
  `major_services` varchar(200) DEFAULT NULL,
  `status` char(1) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`customer_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES ('1', '学院', '3', '2', '1', '8', '8', '8', '8', 'www', '8', '丽', '白', '无w', '3', '3', '2018-07-23 21:39:17');
INSERT INTO `customers` VALUES ('6', 'm', '1', '1', '1', '5', '3', '5', '3', '5', '3', '5', '3', '3', '2', '1', '2018-07-13 08:43:55');
INSERT INTO `customers` VALUES ('10', 'test1', '3', '2', '2', '6', '6', '6', '6', '6', '6', '6', '6', '6', '1', '3', '2018-07-23 21:39:19');
INSERT INTO `customers` VALUES ('11', 'test2', '3', '2', '2', '6', '6', '6', '6', '6', '6', '6', '6', '6', '2', '1', '2018-07-23 21:39:25');

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `desc` varchar(200) DEFAULT NULL,
  `cust_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`log_id`),
  KEY `cust_id` (`cust_id`),
  CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logs
-- ----------------------------
INSERT INTO `logs` VALUES ('5', 'u', 'u', '1', '2018-07-11 00:00:00');
INSERT INTO `logs` VALUES ('8', 'ddddd', 'ddddd', '1', '2018-07-06 00:00:00');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `birthday` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `role_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', 'admin', '0', '2018-07-11 18:38:03', '1', '1');
INSERT INTO `users` VALUES ('3', 'abc', '12314', '1', '2018-07-14 08:03:52', '2', '0');
INSERT INTO `users` VALUES ('16', 'test1', '1', '0', '2018-07-14 08:04:01', '3', '1');
INSERT INTO `users` VALUES ('17', 'test2', '1', '1', '1998-08-08 00:00:00', '2', '1');
INSERT INTO `users` VALUES ('18', 'aaaa', '1', '0', '2018-07-14 00:00:00', '3', '0');
SET FOREIGN_KEY_CHECKS=1;
