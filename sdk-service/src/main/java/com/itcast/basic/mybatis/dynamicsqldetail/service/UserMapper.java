package com.itcast.basic.mybatis.dynamicsqldetail.service;

import com.itcast.basic.mybatis.dynamicsqldetail.model.User;
import com.itcast.basic.mybatis.dynamicsqldetail.model.UserParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/1/14.
 */
public interface UserMapper {

    List<User> selectUserByCondition(UserParams userParams);

    List<User> selectUserByName(@Param("name") String name);

    List<User> selectUser(UserParams userParams);

    int updateUserById(UserParams userParams);

    int deleteByIds(@Param("ids") List ids);

    User selectUserById(@Param("id") long id);
}
