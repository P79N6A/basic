CREATE TABLE `role` (
  `id` bigint(18) auto_increment NOT NULL COMMENT '主键',
  `role_name` varchar(255) NOT NULL DEFAULT '',
  `note` varchar(255) NOT NULL DEFAULT '',
  `user_id` bigint(18) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_role_name` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` bigint(18) auto_increment NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL DEFAULT '',
  `nick_name` varchar(255) NOT NULL DEFAULT '',
  `school` varchar(255) NOT NULL DEFAULT '',
  `note` varchar(255) NOT NULL DEFAULT '',
  `role_id` bigint(18) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_nick_name` (`nick_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;