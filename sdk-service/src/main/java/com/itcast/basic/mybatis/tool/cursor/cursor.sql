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
     declare done int default false;
     declare u_cursor cursor  for select count(*) from users  where name like concat(param,'%');
     declare continue HANDLER for not found set done = true;
     open u_cursor;
     read_loop: loop
       fetch u_cursor into num;
       if done then
           leave read_loop;
       end if;
--        select num;
     end loop;
   close u_cursor;
  end
