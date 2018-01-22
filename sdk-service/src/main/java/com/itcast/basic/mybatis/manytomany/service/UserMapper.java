package com.itcast.basic.mybatis.manytomany.service;

import com.itcast.basic.mybatis.manytomany.model.User;

import java.util.List;

/**
 * Created by treey.qian on 2018/1/22.
 */
public interface UserMapper {

    int insertUser(User user);

    User findUserById(long id);

    List<User> findUsersByRoleId(long roleId);

}
