package com.itcast.basic.mybatis.cachedetail.service;

import com.itcast.basic.mybatis.cachedetail.model.User;

/**
 * Created by treey.qian on 2018/1/12.
 */
public interface UserMapper {

    User selectUserById(long id);

    int insertUser(User user);
}
