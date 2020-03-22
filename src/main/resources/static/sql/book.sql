create database jk_pro_db character set utf8;--建库语句
/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : jk_pro_db

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 20/02/2020 16:00:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publishingHouse` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `inventory` int(6) NULL DEFAULT NULL,
  `lendCount` int(6) NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '001', 'Thinking In java', 'Bruce Eckel', 'Mechanical industry press', 1.00, '1', 30, 0, 'A-3', 'Classic object-oriented narrative for beginners and professionals');
INSERT INTO `book` VALUES (2, '002', 'Crazy English', 'Yang Li', 'Sun yat-sen university press', 89.00, '3', 10, 0, 'A-3', 'Crazy English is a set of unique English learning methods invented by li Yang. He advocates speaking English crazily');
INSERT INTO `book` VALUES (3, '003', 'Tom and Jerry', 'William Hanna', 'Jia jia cartoon', 16.00, '4', 20, 0, 'A-1', 'The plot of Tom and jerry revolves around a pair of common house cats, Tom and jerry the mouse. Tom has a strong desire to constantly try to catch jerry the mouse who is living in the same room, and constantly try to drive the lodger away');

SET FOREIGN_KEY_CHECKS = 1;
