CREATE TABLE `teacher` (
  `id` bigint(18) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `sex` varchar(5) NOT NULL DEFAULT '' COMMENT '性别',
  `school_name` varchar(255) NOT NULL DEFAULT '' COMMENT '所在学校',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `teacher_card` (
  `id` bigint(18) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `number` varchar(255) NOT NULL DEFAULT '' COMMENT '教师资格证编号',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '籍贯',
  `note` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `teacher_id` bigint(18) NOT NULL DEFAULT '0' COMMENT '老师编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB   DEFAULT CHARSET=utf8;


CREATE TABLE `lesson` (
  `id` bigint(18) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `les_name` varchar(255) NOT NULL DEFAULT '' COMMENT '课程名',
  `note` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `teacher_id` bigint(18) NOT NULL DEFAULT '0' COMMENT '老师编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB   DEFAULT CHARSET=utf8;


CREATE TABLE `man_teacher_health` (
  `id` bigint(18) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `teacher_id` bigint(18) NOT NULL DEFAULT '0',
  `liver_desc` varchar(255) NOT NULL DEFAULT '' COMMENT 'liver_desc',
  `lung_desc` varchar(255) NOT NULL DEFAULT '' COMMENT 'lung_desc',
  `spleen_desc` varchar(255) NOT NULL DEFAULT '' COMMENT 'spleen_desc',
  `heart_desc` varchar(255) NOT NULL DEFAULT '' COMMENT 'heart_desc',
  `prostate_desc` varchar(255) NOT NULL DEFAULT '' COMMENT 'prostate_desc',
  `testis_desc` varchar(255) NOT NULL DEFAULT '' COMMENT 'testis_desc',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `female_teacher_health` (
  `id` bigint(18) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `teacher_id` bigint(18) NOT NULL DEFAULT '0',
  `liver_desc` varchar(255) NOT NULL DEFAULT '' COMMENT 'liver_desc',
  `lung_desc` varchar(255) NOT NULL DEFAULT '' COMMENT 'lung_desc',
  `spleen_desc` varchar(255) NOT NULL DEFAULT '' COMMENT 'spleen_desc',
  `heart_desc` varchar(255) NOT NULL DEFAULT '' COMMENT 'heart_desc',
  `breast_desc` varchar(255) NOT NULL DEFAULT '' COMMENT 'breast_desc',
  `uterus_desc` varchar(255) NOT NULL DEFAULT '' COMMENT 'uterus_desc',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



