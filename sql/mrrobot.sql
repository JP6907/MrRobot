/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : mrrobot

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-05-13 20:34:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `command`
-- ----------------------------
DROP TABLE IF EXISTS `command`;
CREATE TABLE `command` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESCRIPTION` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of command
-- ----------------------------
INSERT INTO `command` VALUES ('1', '段子', '一个段子');
INSERT INTO `command` VALUES ('4', '查看', '某些内容');

-- ----------------------------
-- Table structure for `command_content`
-- ----------------------------
DROP TABLE IF EXISTS `command_content`;
CREATE TABLE `command_content` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONTENT` varchar(2048) COLLATE utf8_unicode_ci DEFAULT NULL,
  `COMMAND_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of command_content
-- ----------------------------
INSERT INTO `command_content` VALUES ('1', '从前有个人......', '1');
INSERT INTO `command_content` VALUES ('2', '从前有个鬼......', '1');
INSERT INTO `command_content` VALUES ('3', '其实这里没什么', '4');
INSERT INTO `command_content` VALUES ('4', '其实这里根本没什么', '4');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `ID` int(11) NOT NULL,
  `COMMAND` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESCRIPTION` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CONTENT` varchar(2048) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '自我介绍', '自我介绍', '你好，我是心地善良的小鹏，我的大名是鹏鹏，请多多指教。');
INSERT INTO `message` VALUES ('2', '段子', '段子', '从前有座山...');
INSERT INTO `message` VALUES ('3', '精彩', '精彩内容', '这是精彩内容');
