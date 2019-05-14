/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : wordgame

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 16/04/2019 20:12:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for childinfo
-- ----------------------------
DROP TABLE IF EXISTS `childinfo`;
CREATE TABLE `childinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `childname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for childword
-- ----------------------------
DROP TABLE IF EXISTS `childword`;
CREATE TABLE `childword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wordid` int(11) DEFAULT NULL COMMENT '汉字id',
  `childid` int(11) DEFAULT NULL COMMENT '孩子id',
  `righttimes` int(11) DEFAULT NULL COMMENT '正确次数',
  `errortimes` int(11) DEFAULT NULL COMMENT '错误次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for wordinfo
-- ----------------------------
DROP TABLE IF EXISTS `wordinfo`;
CREATE TABLE `wordinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wordroomid` int(11) DEFAULT NULL COMMENT '字库id',
  `wordname` varchar(255) DEFAULT NULL COMMENT '汉字名称',
  `sound` varchar(255) DEFAULT NULL COMMENT '音频文件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for wordroom
-- ----------------------------
DROP TABLE IF EXISTS `wordroom`;
CREATE TABLE `wordroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wordroomname` varchar(255) DEFAULT NULL COMMENT '字库名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
