/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-05-13 20:35:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `announcement`
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `content` varchar(2048) CHARACTER SET utf8 DEFAULT NULL,
  `title` varchar(1024) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('18', '2016-10-28 22:46:06', '哈哈你妹', '哈哈哈哈');
INSERT INTO `announcement` VALUES ('23', '2016-11-06 21:22:40', '哦哦哦哦哦哦哦哦', '哦哦啊啊啊啊');
INSERT INTO `announcement` VALUES ('26', '2016-11-06 21:52:42', '今天天气真好', '天气好');
INSERT INTO `announcement` VALUES ('27', '2016-11-06 21:52:53', '阿达达', '阿的');

-- ----------------------------
-- Table structure for `bbs`
-- ----------------------------
DROP TABLE IF EXISTS `bbs`;
CREATE TABLE `bbs` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` char(10) DEFAULT NULL,
  `title` char(14) DEFAULT NULL,
  `content` char(100) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs
-- ----------------------------
INSERT INTO `bbs` VALUES ('4', '小明', '哈哈', '嘎嘎', '2016-06-02 19:06:21');
INSERT INTO `bbs` VALUES ('5', '小明', '你好', '你好', '2016-06-05 11:45:34');

-- ----------------------------
-- Table structure for `friends`
-- ----------------------------
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `friendId` int(11) NOT NULL,
  `remarkName` char(32) CHARACTER SET utf32 DEFAULT '-',
  `group` char(32) DEFAULT '-',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friends
-- ----------------------------
INSERT INTO `friends` VALUES ('1', '17', '11', 'xiaoming', '-');
INSERT INTO `friends` VALUES ('2', '17', '12', 'xiaohong', '-');

-- ----------------------------
-- Table structure for `noticereply`
-- ----------------------------
DROP TABLE IF EXISTS `noticereply`;
CREATE TABLE `noticereply` (
  `replyId` int(20) NOT NULL AUTO_INCREMENT,
  `replyNoticeId` int(20) NOT NULL,
  `replyJudge` int(20) NOT NULL,
  `replyDateTime` datetime(6) DEFAULT NULL,
  `replyResponder` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `replyPublisher` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `replyFloor` int(20) DEFAULT NULL,
  `replyText` varchar(1024) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`replyId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of noticereply
-- ----------------------------
INSERT INTO `noticereply` VALUES ('3', '7', '1', '2016-09-30 20:47:27.000000', '小红', '小明', '1', '这是回复内容');

-- ----------------------------
-- Table structure for `postprofile`
-- ----------------------------
DROP TABLE IF EXISTS `postprofile`;
CREATE TABLE `postprofile` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_title` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  `post_text` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  `post_phone` varchar(24) CHARACTER SET utf8 DEFAULT NULL,
  `post_publisher` varchar(24) CHARACTER SET utf8 DEFAULT NULL,
  `post_replynum` int(11) DEFAULT '0',
  `post_publishdt` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `post_newdt` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `post_picture1` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `post_picture2` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `post_picture3` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `post_picture4` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `post_picture5` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `post_picture6` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `post_picture7` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `post_picture8` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `post_picture9` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of postprofile
-- ----------------------------
INSERT INTO `postprofile` VALUES ('39', '标题1', '内容1', '15521374237', '鹏', '6', '2016-10-16 00:25:36', '2016-10-16 00:25:36', 'aa.png', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('40', '标题2', '内容2', '15521374237', '鹏', '18', '2016-10-16 00:26:10', '2016-10-16 00:26:10', 'bb.png', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('41', '标题3', '内容3', '15521374237', '鹏', '5', '2016-10-16 00:26:59', '2016-10-16 00:26:59', 'aa.png', 'bb.png', null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('42', '蓝牙已成功', '哈哈哈', '15521374237', '鹏', '0', '2016-10-18 23:00:50', '2016-10-18 23:00:50', null, null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('46', '现在', '马上', '15521374237', '鹏', '0', '2016-10-20 18:11:11', '2016-10-20 18:11:11', null, null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('47', '半天假', '今天下午，去干嘛了？嘛是谁', '18813294204', '鸿', '0', '2016-10-22 20:11:57', '2016-10-22 20:11:57', null, null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('48', '大家好', '今天天气真好', '15521374237', '鹏', '0', '2016-10-22 22:41:40', '2016-10-22 22:41:40', 'p1.png', 'p2.png', 'p3.png', null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('49', '哈哈', 'Hello World', '15521374237', '鹏', '0', '2016-10-22 22:45:40', '2016-10-22 22:45:40', 'p1.png', 'p2.png', null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('50', '台风', '台风走le', '15521374237', '鹏', '0', '2016-10-22 22:46:41', '2016-10-22 22:46:41', 'p1.png', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('51', '哈巴河', '洗澡课，游泳了', '18813294204', '鸿', '0', '2016-10-23 14:13:00', '2016-10-23 14:13:00', '0P61022-141221.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('52', '该', '感觉', '18813294204', '鸿', '0', '2016-10-23 14:19:48', '2016-10-23 14:19:48', '0P61022-141221.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('53', '俩', '好', '18813294204', '鸿', '0', '2016-10-23 14:20:42', '2016-10-23 14:20:42', '0P61022-141221.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('54', 'fh', 'fg', '18813294204', '鸿', '0', '2016-10-23 14:21:37', '2016-10-23 14:21:37', '0P61022-141221.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('55', 'gh', 'ghj', '18813294204', '鸿', '0', '2016-10-23 14:22:53', '2016-10-23 14:22:53', '0P61022-141221.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('57', '足记', '不想说太多卡。', '18813294204', '鸿', '2', '2016-10-27 23:01:53', '2016-10-27 23:01:53', '0P61022-141324.jpg', '1P61022-141324_1.jpg', '2P61022-141325.jpg', '3P61022-141313.jpg', null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('58', '1块一块', '一句两句', '18813294204', '鸿', '0', '2016-10-27 23:19:44', '2016-10-27 23:19:44', null, null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('59', '干嘛呢', '无事', '18813294204', '鸿', '0', '2016-10-28 20:28:27', '2016-10-28 20:28:27', '0P61022-141223.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('60', '身份证号？', '号码是', '18813294204', '鸿', '0', '2016-10-28 20:31:00', '2016-10-28 20:31:00', '0P61022-141222.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('61', '天地一剑，王权世家', '只需一剑，言语。', '18813294204', '鸿', '1', '2016-11-02 10:07:53', '2016-11-02 10:07:53', '0P61022-141222_1.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('62', '哈喽', '看看', '18813294204', '鸿', '0', '2016-11-02 10:17:08', '2016-11-02 10:17:08', '0P61022-141222_1.jpg', '1P61022-141224.jpg', null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('63', '弯刀', '大刀耍洗团', '18813294204', '鸿', '0', '2016-11-02 10:23:14', '2016-11-02 10:23:14', '0P61022-141227.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('64', '气氛了', 'LOMO默默', '18813294204', '鸿', '0', '2016-11-02 10:27:30', '2016-11-02 10:27:30', '0P61022-141221.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('65', '快了', '看看', '18813294204', '鸿', '0', '2016-11-02 10:33:21', '2016-11-02 10:33:21', '0P61022-141222.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('66', '啦啊评估', '快来咯no', '18813294204', '鸿', '0', '2016-11-02 10:47:07', '2016-11-02 10:47:07', '0P61022-141231.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('67', '啊', '咖', '18813294204', '鸿', '0', '2016-11-02 10:49:17', '2016-11-02 10:49:17', null, null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('68', '罢了', '里', '18813294204', '鸿', '3', '2016-11-02 10:50:50', '2016-11-02 10:50:50', '0P61022-141223.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('69', '哭', '哈哈', '18813294204', '鸿', '2', '2016-11-02 11:29:27', '2016-11-02 11:29:27', '0P61022-141221.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('70', '吧', '吧', '15521374237', '鹏', '3', '2016-11-03 21:02:54', '2016-11-03 21:02:54', '0IMG_20160927_205929_HDR.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('71', '咖', '还饿', '18813294204', '鸿', '2', '2016-11-05 11:35:50', '2016-11-05 11:35:50', '0P61022-141223_1.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('72', '无上功法', '火龙', '18813294204', '鸿', '0', '2016-11-11 23:05:05', '2016-11-11 23:05:05', null, null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('73', '啦咯啦咯啦咯咯嘛咯KKK啦咯', '图KKK', '18813294204', '鸿', '1', '2016-11-12 23:42:15', '2016-11-12 23:42:15', null, null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('74', '什么时候去高兴吗', '不认识', '18813294204', '遇到一个人以后怎么办', '5', '2016-11-13 18:21:36', '2016-11-13 18:21:36', null, null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('75', '哈哈哈', '天气真好', '15521374237', '鹏', '1', '2016-11-17 22:43:15', '2016-11-17 22:43:15', '0IMG_20160927_120040_HDR.jpg', null, null, null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('76', '啊哈哈哈哈哈哈哈哈哈还吃！', '啊哈哈哈哈哈哈哈哈哈还吃！啊哈哈哈哈哈哈哈哈哈还吃！', '18826139244', '涛', '2', '2017-02-07 09:38:54', '2017-02-07 09:38:54', '0img-ad2e9ae118ecaca074e894d0655eaaf6.jpg', '1img-14bfc236412dcf71b61faa3172fcc1ef.jpg', '2img-6cabf6e1752d19ec7d5ae54a1477fad7.jpg', null, null, null, null, null, null);
INSERT INTO `postprofile` VALUES ('77', '111111', '111111', '18813294204', '把', '1', '2017-04-09 19:43:05', '2017-04-09 19:43:05', '0P61122-145027.jpg', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `reply_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reply_postid` bigint(20) DEFAULT NULL,
  `reply_judge` smallint(6) DEFAULT NULL,
  `reply_datetime` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `reply_responder` varchar(24) CHARACTER SET utf8 DEFAULT NULL,
  `reply_publisher` varchar(24) CHARACTER SET utf8 DEFAULT NULL,
  `reply_floor` int(11) DEFAULT NULL,
  `reply_text` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '39', '1', '2016-10-16 00:25:36', 'peng', '小明', '1', '回复回复内容11');
INSERT INTO `reply` VALUES ('2', '40', '1', '2016-10-16 00:26:10', 'peng', '小红', '1', '回复内荣222');
INSERT INTO `reply` VALUES ('3', '40', '1', '2016-10-16 02:26:10', 'peng', '小xiao', '2', '会恢复');
INSERT INTO `reply` VALUES ('4', '10', '1', '2016-10-16 12:26:10', 'peng', '小大', '3', '十大很大很大');
INSERT INTO `reply` VALUES ('15', '1', '1', '2016-10-16 22:41:57', '1', 'peng', '1', '好吧');
INSERT INTO `reply` VALUES ('16', '1', '1', '2016-10-16 22:48:13', '', 'peng', '2', ' 你好');
INSERT INTO `reply` VALUES ('17', '1', '1', '2016-10-16 22:50:38', '', 'peng', '3', '再见');
INSERT INTO `reply` VALUES ('18', '1', '1', '2016-10-16 22:53:39', '鸿', 'peng', '4', '干什么');
INSERT INTO `reply` VALUES ('19', '1', '1', '2016-10-16 23:09:38', '鸿', 'peng', '5', '补补脑');
INSERT INTO `reply` VALUES ('20', '1', '0', '2016-10-16 23:13:42', '鸿', 'peng', '6', '号楼');
INSERT INTO `reply` VALUES ('21', '39', '1', '2016-10-17 13:32:18', '鸿', '鹏', '2', '干什么');
INSERT INTO `reply` VALUES ('22', '40', '0', '2016-10-17 14:12:59', '鸿', '小xiao', '2', '哈哈');
INSERT INTO `reply` VALUES ('23', '40', '0', '2016-10-17 14:30:01', '鸿', 'peng', '1', '哎呀哎呀哎呀');
INSERT INTO `reply` VALUES ('24', '40', '1', '2016-10-18 21:27:03', '鸿', '鹏', '3', '幸亏还有');
INSERT INTO `reply` VALUES ('25', '40', '1', '2016-10-18 21:27:12', '鸿', '鹏', '4', '还有什么');
INSERT INTO `reply` VALUES ('26', '40', '0', '2016-10-18 21:28:35', '鸿', '鸿', '3', '没有了啦！');
INSERT INTO `reply` VALUES ('27', '40', '1', '2016-10-18 22:46:24', '鸿', '鹏', '5', '感觉');
INSERT INTO `reply` VALUES ('28', '40', '0', '2016-10-18 22:53:12', '鸿', '鸿', '1', '感觉');
INSERT INTO `reply` VALUES ('29', '40', '0', '2016-10-18 22:56:10', '鸿', '鸿', '3', '成功了，太好了');
INSERT INTO `reply` VALUES ('30', '40', '0', '2016-10-18 22:57:46', '鸿', '鸿', '3', '怎么回事，好帅');
INSERT INTO `reply` VALUES ('31', '40', '0', '2016-10-18 23:58:21', '鸿', 'peng', '2', '二楼');
INSERT INTO `reply` VALUES ('32', '40', '0', '2016-10-18 23:58:42', '鸿', '鸿', '2', '回复哈哈的');
INSERT INTO `reply` VALUES ('33', '40', '1', '2016-10-18 23:58:55', '鸿', '鹏', '6', '是的');
INSERT INTO `reply` VALUES ('34', '40', '0', '2016-10-19 00:00:24', '鸿', '鸿', '2', '回复一下吧');
INSERT INTO `reply` VALUES ('35', '40', '1', '2016-10-19 00:00:31', '鸿', '鹏', '7', '是啊');
INSERT INTO `reply` VALUES ('36', '40', '1', '2016-10-19 00:01:02', '鸿', '鹏', '8', '挣钱啊');
INSERT INTO `reply` VALUES ('37', '40', '0', '2016-10-19 15:00:27', '鹏', '鸿', '3', '是吗');
INSERT INTO `reply` VALUES ('38', '40', '0', '2016-10-19 15:00:49', '鹏', '鸿', '3', '是的');
INSERT INTO `reply` VALUES ('39', '40', '0', '2016-10-19 15:00:58', '鹏', '鹏', '3', '好的');
INSERT INTO `reply` VALUES ('40', '39', '0', '2016-10-19 15:11:22', '鹏', '鸿', '2', '没干什么');
INSERT INTO `reply` VALUES ('41', '39', '1', '2016-10-19 15:12:13', '鹏', '鹏', '3', '哈哈');
INSERT INTO `reply` VALUES ('42', '41', '1', '2016-10-19 23:53:51', '', '鹏', '1', '啊');
INSERT INTO `reply` VALUES ('43', '41', '0', '2016-10-19 23:54:01', '', '', '1', '啊');
INSERT INTO `reply` VALUES ('44', '39', '1', '2016-10-19 23:56:59', '鸿', '鹏', '4', '还不睡觉');
INSERT INTO `reply` VALUES ('45', '39', '0', '2016-10-19 23:57:42', '鸿', 'peng', '1', '天下长情');
INSERT INTO `reply` VALUES ('46', '39', '0', '2016-10-19 23:58:04', '鸿', '鸿', '1', '无所事事');
INSERT INTO `reply` VALUES ('47', '41', '0', '2016-10-20 16:38:21', '鸿', '', '1', '天下第一个');
INSERT INTO `reply` VALUES ('48', '41', '1', '2016-10-20 16:38:45', '鸿', '鹏', '2', '无敌了？');
INSERT INTO `reply` VALUES ('49', '41', '0', '2016-10-20 16:39:04', '鸿', '鸿', '1', '嗯嗯。无敌了');
INSERT INTO `reply` VALUES ('50', '57', '1', '2016-11-01 22:30:08', '鸿', '鸿', '1', '阿狸');
INSERT INTO `reply` VALUES ('51', '57', '1', '2016-11-01 22:30:27', '鸿', '鸿', '2', '什么鬼');
INSERT INTO `reply` VALUES ('52', '68', '1', '2016-11-03 17:15:29', '鸿', '鸿', '1', '一句两句话，费查询');
INSERT INTO `reply` VALUES ('53', '68', '1', '2016-11-03 17:16:30', '鸿', '鸿', '2', '不错嘛');
INSERT INTO `reply` VALUES ('54', '68', '0', '2016-11-03 17:16:37', '鸿', '鸿', '2', '还用说');
INSERT INTO `reply` VALUES ('55', '61', '1', '2016-11-06 11:04:50', '鹏', '鸿', '1', '嗯');
INSERT INTO `reply` VALUES ('56', '70', '1', '2016-11-11 22:04:35', '鸿', '鹏', '1', '哈哈');
INSERT INTO `reply` VALUES ('57', '70', '1', '2016-11-11 22:08:01', '鸿', '鹏', '2', '什么');
INSERT INTO `reply` VALUES ('58', '71', '1', '2016-11-11 22:15:55', '鸿', '鸿', '1', '哈哈');
INSERT INTO `reply` VALUES ('59', '69', '1', '2016-11-11 22:36:19', '鸿', '鸿', '1', '努力吧');
INSERT INTO `reply` VALUES ('60', '69', '0', '2016-11-13 18:41:40', '遇到一个人以后怎么办', '鸿', '1', '确实');
INSERT INTO `reply` VALUES ('61', '73', '1', '2016-11-17 22:25:27', '鹏', '鸿', '1', '嗯');
INSERT INTO `reply` VALUES ('62', '74', '1', '2016-11-17 22:25:37', '鹏', '遇到一个人以后怎么办', '1', '哈');
INSERT INTO `reply` VALUES ('63', '74', '1', '2016-11-17 22:41:38', '鹏', '遇到一个人以后怎么办', '2', '哈哈哈哈');
INSERT INTO `reply` VALUES ('64', '74', '0', '2016-11-17 22:41:44', '鹏', '鹏', '2', '陌陌');
INSERT INTO `reply` VALUES ('65', '74', '0', '2016-11-17 22:41:50', '鹏', '鹏', '2', '得得');
INSERT INTO `reply` VALUES ('66', '71', '0', '2016-11-28 19:46:36', '鹏', '鸿', '1', '嗯嗯');
INSERT INTO `reply` VALUES ('67', '74', '1', '2016-12-17 23:20:24', '鹏', '遇到一个人以后怎么办', '3', '哈哈');
INSERT INTO `reply` VALUES ('68', '70', '0', '2016-12-18 01:00:11', '', '鸿', '2', '啊啊啊');
INSERT INTO `reply` VALUES ('69', '75', '1', '2017-01-14 12:55:48', '涛', '鹏', '1', '试试');
INSERT INTO `reply` VALUES ('70', '76', '1', '2017-02-20 15:44:17', '树', '涛', '1', '哈哈哈');
INSERT INTO `reply` VALUES ('71', '76', '0', '2017-04-09 23:25:41', '把', '树', '1', '刚刚');
INSERT INTO `reply` VALUES ('72', '77', '1', '2017-04-10 21:29:41', '', '把', '1', '哦哦哦');

-- ----------------------------
-- Table structure for `t_dooruser`
-- ----------------------------
DROP TABLE IF EXISTS `t_dooruser`;
CREATE TABLE `t_dooruser` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `dName` varchar(10) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `dPassword` varchar(20) CHARACTER SET utf8 NOT NULL,
  `dPhone` varchar(15) CHARACTER SET utf8 NOT NULL,
  `Building` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `DoorID` varchar(10) DEFAULT NULL,
  `dImagePath` varchar(128) CHARACTER SET utf8 DEFAULT '-',
  `dODPass` varchar(20) CHARACTER SET utf8 NOT NULL DEFAULT '000000',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_dooruser
-- ----------------------------
INSERT INTO `t_dooruser` VALUES ('11', 'Leon', '123456', '18826245497', 'B2', 'door01', 'Upload/Leon/headImage.jpg', '231012');
INSERT INTO `t_dooruser` VALUES ('12', 'lin', '123456', '18826245496', 'B2', 'door03', 'Upload/lin/headImage.jpg', '123456');
INSERT INTO `t_dooruser` VALUES ('13', 'long', '123456', '15689326578', 'B1', 'door03', 'Upload/long/headImage.jpg', '123456');
INSERT INTO `t_dooruser` VALUES ('14', '11', 'yudawei1996', '15521197165', null, null, 'Upload/default/headImage.jpg', '123456');
INSERT INTO `t_dooruser` VALUES ('16', 'Hello', '159357', '112112', 'B13', 'a1', '-', '000000');
INSERT INTO `t_dooruser` VALUES ('17', '鹏', 'hkmzjp', '15521374237', '1栋', '110', 'Upload/HeadImage/15521374237/headImage.jpg', '888888');
INSERT INTO `t_dooruser` VALUES ('18', '-', 'zyc13434975475', '15622758304', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('19', '2017年毕业设计', '000000', '18813294204', '西八', '428', 'Upload/HeadImage/18813294204/headImage.jpg', '000000');
INSERT INTO `t_dooruser` VALUES ('23', '   ', '123456', '13246823448', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('29', '树', '888888', '18813294319', '西十二', '535', 'Upload/HeadImage/18813294319/headImage.jpg', '000000');
INSERT INTO `t_dooruser` VALUES ('30', '', '123456', '13715986216', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('31', '', 'york0817', '18826135166', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('32', '涛', '123456', '18826139244', null, null, 'Upload/HeadImage/18826139244/headImage.jpg', '000000');
INSERT INTO `t_dooruser` VALUES ('33', '', '123456', '15262114989', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('34', '涛', '1069353613', '13005264236', '3', '602', 'Upload/HeadImage/13005264236/headImage.jpg', '000000');
INSERT INTO `t_dooruser` VALUES ('35', '张敏', '123456', '15180861778', 'R2区4栋2单元', '2208', '-', '000000');
INSERT INTO `t_dooruser` VALUES ('36', '', 'zou123', '13433562696', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('37', '', 'asdfghjkl', '13430307774', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('38', '', 'UWyatoo2007', '13631480246', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('39', '', 'know123', '13710646687', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('40', '', 'zhanglin19740219', '13538065547', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('41', '', '11112222', '13570910246', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('42', '', '11112222', '13570910246', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('43', '', '11112222', '13570910246', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('44', '', 'gff44167593', '13426990999', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('45', '', '6064152ghh', '18819441185', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('46', '', '311247900', '13104881525', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('47', '', '106948', '18216210495', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('48', '', 'zxc1234', '18350032353', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('49', '', 'guoyiqu', '15625044950', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('50', '', '19970620', '15193976672', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('51', '', 'xuan13980191164', '13980191164', null, null, '-', '000000');
INSERT INTO `t_dooruser` VALUES ('52', '', 'jp0809', '15689989387', null, null, '-', '000000');

-- ----------------------------
-- Table structure for `t_employees`
-- ----------------------------
DROP TABLE IF EXISTS `t_employees`;
CREATE TABLE `t_employees` (
  `NO` int(10) unsigned NOT NULL,
  `eName` varchar(20) NOT NULL,
  `eSal` int(10) unsigned DEFAULT NULL,
  `DeptNO` int(11) unsigned DEFAULT NULL,
  `LeaderNO` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_employees
-- ----------------------------
INSERT INTO `t_employees` VALUES ('0', 'df', '8332', null, null);
INSERT INTO `t_employees` VALUES ('2001', 'Leo', '7909', '10', '1000');
INSERT INTO `t_employees` VALUES ('2002', 'Kitty', '6894', '10', '1000');
INSERT INTO `t_employees` VALUES ('2003', 'Jhon', '9834', '20', '1001');
INSERT INTO `t_employees` VALUES ('2004', 'Miller', '5098', '30', '1002');
INSERT INTO `t_employees` VALUES ('2005', 'Smith', '9087', '30', '1002');
INSERT INTO `t_employees` VALUES ('2006', 'Adams', '9087', '30', '1002');
INSERT INTO `t_employees` VALUES ('2007', 'Martin', '4982', '50', null);

-- ----------------------------
-- Table structure for `t_fc`
-- ----------------------------
DROP TABLE IF EXISTS `t_fc`;
CREATE TABLE `t_fc` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dName` varchar(20) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL DEFAULT '',
  `dPass` varchar(20) NOT NULL,
  `dImagePath` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID`,`dName`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_fc
-- ----------------------------
INSERT INTO `t_fc` VALUES ('2', 'Leo', '123456', 'Upload/Leo/headImage.jpg');
INSERT INTO `t_fc` VALUES ('5', 'leon', '123456', 'Upload/leon/headImage.jpg');
INSERT INTO `t_fc` VALUES ('6', 'dong', '123456', 'Upload/default/headImage.jpg');
INSERT INTO `t_fc` VALUES ('7', '123', '123456', 'Upload/default/headImage.jpg');

-- ----------------------------
-- Table structure for `t_images`
-- ----------------------------
DROP TABLE IF EXISTS `t_images`;
CREATE TABLE `t_images` (
  `NO` int(11) unsigned NOT NULL,
  `Path` varchar(20) NOT NULL,
  PRIMARY KEY (`NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_images
-- ----------------------------
INSERT INTO `t_images` VALUES ('10', 'images/test.jpg');

-- ----------------------------
-- Table structure for `t_leaders`
-- ----------------------------
DROP TABLE IF EXISTS `t_leaders`;
CREATE TABLE `t_leaders` (
  `NO` int(10) unsigned NOT NULL,
  `lName` varchar(20) NOT NULL,
  `Dept` varchar(20) DEFAULT NULL,
  `DeptNO` int(11) DEFAULT NULL,
  PRIMARY KEY (`NO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_leaders
-- ----------------------------
INSERT INTO `t_leaders` VALUES ('999', 'Boss', 'Manager', '0');
INSERT INTO `t_leaders` VALUES ('1000', 'Kobe', 'Analyst', '10');
INSERT INTO `t_leaders` VALUES ('1001', 'James', 'Cleak', '20');
INSERT INTO `t_leaders` VALUES ('1002', 'Jordon', 'Salesman', '30');
