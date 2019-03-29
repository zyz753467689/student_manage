/*
SQLyog Ultimate v8.32 
MySQL - 8.0.12 : Database - student_information_management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`student_information_management` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `student_information_management`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) DEFAULT NULL,
  `tnumber` varchar(20) NOT NULL,
  `snumber` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`cid`,`cname`,`tnumber`,`snumber`) values (1,'语文','tea001','stu001'),(2,'数学','tea002','stu001'),(3,'英语','tea003','stu001'),(4,'物理','tea004','stu001'),(5,'化学','tea005','stu001'),(6,'语文','tea001','stu002'),(7,'数学','tea002','stu002'),(8,'英语','tea003','stu002'),(21,'数学','tea002','stu003'),(22,'物理','tea004','stu003'),(23,'Java','tea008','stu003');

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `snumber` varchar(20) NOT NULL,
  `course` varchar(10) NOT NULL,
  `grade` int(11) DEFAULT '0',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `grade` */

insert  into `grade`(`gid`,`snumber`,`course`,`grade`) values (1,'stu001','语文',120),(2,'stu001','数学',112),(3,'stu001','英语',92),(4,'stu001','物理',75),(5,'stu001','化学',80),(6,'stu002','语文',120),(7,'stu002','数学',113),(8,'stu002','英语',91);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(10) DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`rid`,`rname`) values (1,'学生'),(2,'教师'),(3,'管理员');

/*Table structure for table `stu_info` */

DROP TABLE IF EXISTS `stu_info`;

CREATE TABLE `stu_info` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `snumber` varchar(20) NOT NULL,
  `sname` varchar(10) NOT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `age` varchar(4) NOT NULL,
  `profession` varchar(20) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `stu_info` */

insert  into `stu_info`(`sid`,`snumber`,`sname`,`gender`,`age`,`profession`) values (1,'stu001','王阳','男','23','软件工程'),(2,'stu002','赵贤坤','女','23','通信工程');

/*Table structure for table `stu_tea` */

DROP TABLE IF EXISTS `stu_tea`;

CREATE TABLE `stu_tea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `snumber` varchar(20) DEFAULT NULL,
  `tnumber` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `stu_tea` */

insert  into `stu_tea`(`id`,`snumber`,`tnumber`) values (1,'stu001','tea001'),(2,'stu001','tea002'),(3,'stu001','tea003'),(4,'stu001','tea004'),(5,'stu001','tea005'),(6,'stu002','tea001'),(7,'stu002','tea002'),(8,'stu002','tea003');

/*Table structure for table `tea_info` */

DROP TABLE IF EXISTS `tea_info`;

CREATE TABLE `tea_info` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tnumber` varchar(20) NOT NULL,
  `tname` varchar(10) NOT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `count` int(11) DEFAULT '0',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `tea_info` */

insert  into `tea_info`(`tid`,`tnumber`,`tname`,`gender`,`type`,`count`) values (1,'tea001','黄小妹','女','语文',2),(2,'tea002','刘苍松','男','数学',2),(3,'tea003','王克晶','女','英语',2),(4,'tea004','范传奇','男','物理',1),(5,'tea005','刘小国斌','男','化学',1),(9,'tea008','zyz','男','Java',0),(10,'tea006','马冬梅','女','语文',0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`password`,`rid`) values (1,'stu001','stu001',1),(2,'admin','admin',3),(3,'stu002','stu002',1),(4,'tea001','tea001',2),(5,'tea002','tea002',2),(6,'tea003','tea003',2),(7,'tea004','tea004',2),(8,'tea005','tea005',2),(9,'tea008','tea008',2),(10,'stu003','stu003',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
