/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2020-09-14 15:28:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `UserID` int(10) NOT NULL,
  `GoodsID` int(10) NOT NULL,
  `Number` int(10) NOT NULL DEFAULT '1',
  `AddDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `CID` int(10) NOT NULL AUTO_INCREMENT,
  `UserID` int(10) NOT NULL DEFAULT '0',
  `GoodsID` int(10) NOT NULL DEFAULT '0',
  `CText` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `franchise`
-- ----------------------------
DROP TABLE IF EXISTS `franchise`;
CREATE TABLE `franchise` (
  `FranID` int(10) NOT NULL AUTO_INCREMENT,
  `Password` varchar(32) DEFAULT NULL,
  `FranName` varchar(16) DEFAULT NULL,
  `FranImage` varchar(50) DEFAULT NULL,
  `WhoInCharge` varchar(16) DEFAULT NULL,
  `ChargeID` varchar(20) DEFAULT NULL,
  `ChargePhone` int(11) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Email` varchar(32) DEFAULT NULL,
  `Balance` int(11) DEFAULT NULL,
  `CreditCard` int(20) DEFAULT NULL,
  `Introduce` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`FranID`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of franchise
-- ----------------------------
INSERT INTO `franchise` VALUES ('101', 'kuba1985', 'Kuba King', 'Fran1.jpg', 'Runrun', '12347890564738', '123666', '2218489', 'fortress@kuba.com', '500000', '60252222', 'Welcome');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `GoodsID` int(10) NOT NULL,
  `GoodsName` varchar(20) NOT NULL,
  `Price` int(11) NOT NULL,
  `Number` int(11) NOT NULL,
  `LaunchDate` date NOT NULL,
  `Ways` varchar(20) NOT NULL,
  `Meals` int(11) NOT NULL DEFAULT '1',
  `SSID` int(10) NOT NULL,
  `FranID` int(10) NOT NULL,
  PRIMARY KEY (`GoodsID`),
  KEY `SSID` (`SSID`),
  KEY `FranID` (`FranID`),
  KEY `Price` (`Price`),
  CONSTRAINT `FranID` FOREIGN KEY (`FranID`) REFERENCES `franchise` (`FranID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `SSID` FOREIGN KEY (`SSID`) REFERENCES `scenicspot` (`SSID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `MaID` int(10) NOT NULL AUTO_INCREMENT,
  `Password` varchar(32) DEFAULT NULL,
  `MaName` varchar(16) DEFAULT NULL,
  `MaImage` varchar(50) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Email` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`MaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `OrderID` int(10) NOT NULL AUTO_INCREMENT,
  `GoodsID` int(10) NOT NULL,
  `Price` int(10) NOT NULL,
  `UserID` int(10) NOT NULL,
  `State` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`OrderID`),
  KEY `GoodsID` (`GoodsID`),
  KEY `Price` (`Price`),
  KEY `UserID` (`UserID`),
  CONSTRAINT `GoodsID` FOREIGN KEY (`GoodsID`) REFERENCES `goods` (`GoodsID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `Price` FOREIGN KEY (`Price`) REFERENCES `goods` (`Price`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `UserID` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `scenicspot`
-- ----------------------------
DROP TABLE IF EXISTS `scenicspot`;
CREATE TABLE `scenicspot` (
  `SSID` int(10) NOT NULL AUTO_INCREMENT,
  `SSName` varchar(20) NOT NULL,
  `SSImage_1` varchar(32) NOT NULL,
  `SSImage_2` varchar(32) DEFAULT NULL,
  `SSImage_3` varchar(32) DEFAULT NULL,
  `Introduce` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scenicspot
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `UserID` int(10) NOT NULL AUTO_INCREMENT,
  `Password` varchar(32) DEFAULT NULL,
  `UserName` varchar(16) DEFAULT NULL,
  `UserImage` varchar(50) DEFAULT NULL,
  `TrueName` varchar(16) DEFAULT NULL,
  `IDNumber` varchar(20) DEFAULT NULL,
  `QQNumber` int(11) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Email` varchar(32) DEFAULT NULL,
  `Balance` int(11) DEFAULT NULL,
  `Tag1` varchar(16) DEFAULT NULL,
  `Tag2` varchar(16) DEFAULT NULL,
  `Tag3` varchar(16) DEFAULT NULL,
  `Introduce` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10001', '123654', 'User1', 'User1.jpg', 'Mario', '552024598732472123', '43477619', '123456', '2548@nintendo.com', '0', null, null, null, 'It\'s Me, Mario!');

-- ----------------------------
-- Table structure for `usertype`
-- ----------------------------
DROP TABLE IF EXISTS `usertype`;
CREATE TABLE `usertype` (
  `ID` int(10) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Type` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertype
-- ----------------------------
INSERT INTO `usertype` VALUES ('10001', '123654', '2');
