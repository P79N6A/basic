package com.itcast.basic.mybatis.mybatisspring.transactionmanager.dao;

import com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/1/14.
 */
@Repository
public interface UserDao {

    int insertUser(User user);

    User findById(@Param("id") long id);

    List<User> findByName(@Param("name") String name);

    int updateUser(User user);

    int deleteUser(@Param("id") long id);

    User selectById(@Param("id") long id);
}
