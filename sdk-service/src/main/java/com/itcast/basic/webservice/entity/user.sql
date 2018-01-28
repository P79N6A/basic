CREATE TABLE `users` (
  `id` bigint(18) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `nick_name` varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `sex` varchar(5) NOT NULL DEFAULT '' COMMENT '性别',
  `school_name` varchar(255) NOT NULL DEFAULT '' COMMENT '所在学校',
  `create_time` TIMESTAMP NOT NULL DEFAULT '2018-01-01 00:00:00' COMMENT '记录创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新时间',
  key idx_name(`name`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;