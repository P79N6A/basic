package com.itcast.basic.mybatis.tool.batch.service;


import com.itcast.basic.mybatis.tool.batch.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/1/14.
 */
public interface UserMapper {
    User selectUserById(@Param("id") long id);

    int insertUser(User user);

    User selectUserByName(@Param("name") String name);
}
