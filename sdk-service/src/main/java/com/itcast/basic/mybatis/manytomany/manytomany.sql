CREATE TABLE `parent` (
  `id` bigint(18) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `children_id` bigint(18) NOT NULL DEFAULT '0' COMMENT '所有孩子',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `children` (
  `id` bigint(18) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `parent_id` bigint(18) NOT NULL DEFAULT '0' COMMENT '所有父辈',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
