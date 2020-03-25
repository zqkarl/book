/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50625
 Source Host           : localhost
 Source Database       : jk_pro_db

 Target Server Type    : MySQL
 Target Server Version : 50625
 File Encoding         : utf-8

 Date: 03/25/2020 17:16:19 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(11) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `publishingHouse` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `inventory` int(6) DEFAULT NULL,
  `lendCount` int(6) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `book`
-- ----------------------------
BEGIN;
INSERT INTO `book` VALUES ('1', '001', 'Thinking In java', 'Bruce Eckel', 'Mechanical industry press', '1.00', '1', '49', '1', 'A-3', 'Classic object-oriented narrative for beginners and professionals'), ('2', '002', 'Crazy English', 'Yang Li', 'Sun yat-sen university press', '89.00', '3', '10', '0', 'A-3', 'Crazy English is a set of unique English learning methods invented by li Yang. He advocates speaking English crazily'), ('3', '003', 'Tom and Jerry', 'William Hanna', 'Jia jia cartoon', '16.00', '4', '20', '0', 'A-1', 'The plot of Tom and jerry revolves around a pair of common house cats, Tom and jerry the mouse. Tom has a strong desire to constantly try to catch jerry the mouse who is living in the same room, and constantly try to drive the lodger away');
COMMIT;

-- ----------------------------
--  Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '记录类型（borrow；return）',
  `person` varchar(255) DEFAULT NULL COMMENT '借/还书人',
  `time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '借书日期',
  `relate_id` int(11) DEFAULT NULL COMMENT '借书所对应的还书记录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
