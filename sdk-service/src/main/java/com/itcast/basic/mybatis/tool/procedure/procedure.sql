CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL DEFAULT '',
  `nick_name` varchar(255) NOT NULL DEFAULT '',
  `school` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

select `name` from mysql.proc where db = 'tongzhuwang' and `type` = 'PROCEDURE'

create procedure pro(in param varchar(255),out num int)
begin
     select count(*) into num from users where name like concat(param,'%');
end