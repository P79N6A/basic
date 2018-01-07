package com.itcast.basic.mybatis.datatools;

import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2018/1/6.
 */
public interface UserMapper {

    @Select("select * from users where id = #{id}")
    User selectUser(int id);
}
