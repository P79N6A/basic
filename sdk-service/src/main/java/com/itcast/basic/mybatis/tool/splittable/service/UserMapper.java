package com.itcast.basic.mybatis.tool.splittable.service;


import com.itcast.basic.mybatis.tool.splittable.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by treey.qian on 2018/1/22.
 */
public interface UserMapper {

    int insertUser(@Param("user") User user, @Param("tableName") String tableName);

    User findUserById(@Param("id") long id, @Param("tableName") String tableName);

    int deleteUserById(@Param("id") long id, @Param("tableName") String tableName);
}
