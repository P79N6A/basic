CREATE TABLE `user201801` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL DEFAULT '',
  `nick_name` varchar(255) NOT NULL DEFAULT '',
  `school` varchar(255) NOT NULL DEFAULT '',
  `note` varchar(255) NOT NULL DEFAULT '',
  `role_id` bigint(18) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_nick_name` (`nick_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE `user201802` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL DEFAULT '',
  `nick_name` varchar(255) NOT NULL DEFAULT '',
  `school` varchar(255) NOT NULL DEFAULT '',
  `note` varchar(255) NOT NULL DEFAULT '',
  `role_id` bigint(18) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_nick_name` (`nick_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE `user201803` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL DEFAULT '',
  `nick_name` varchar(255) NOT NULL DEFAULT '',
  `school` varchar(255) NOT NULL DEFAULT '',
  `note` varchar(255) NOT NULL DEFAULT '',
  `role_id` bigint(18) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_nick_name` (`nick_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;