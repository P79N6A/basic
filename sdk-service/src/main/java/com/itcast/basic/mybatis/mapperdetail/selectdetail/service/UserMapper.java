package com.itcast.basic.mybatis.mapperdetail.selectdetail.service;

import com.itcast.basic.mybatis.mapperdetail.selectdetail.model.User;
import com.itcast.basic.mybatis.mapperdetail.selectdetail.model.UserParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by treey.qian on 2018/1/8.
 */
public interface UserMapper {

    User selectUser(long id);

    User selectUserById(long id);

    int insertUser(User user);

    int count(String name);

    List<User> selectUserByParams(Map<String, String> params);

    List<User> selectUserByConditions(@Param("name") String mame, @Param("school") String school);

    List<User> selectUserByUserParam(UserParam userParam);
}
