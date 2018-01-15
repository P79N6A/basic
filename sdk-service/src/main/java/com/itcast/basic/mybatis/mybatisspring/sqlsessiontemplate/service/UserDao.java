package com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.service;

import com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/1/14.
 */
public interface UserDao {

    int insertUser(User user);

    User findById(User user);

    List<User> findByName(User user);

    int updateUser(User user);

    int deleteUser(User user);

    User selectById(@Param("id") long id);
}
