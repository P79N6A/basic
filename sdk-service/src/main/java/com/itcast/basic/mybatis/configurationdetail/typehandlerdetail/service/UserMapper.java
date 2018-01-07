package com.itcast.basic.mybatis.configurationdetail.typehandlerdetail.service;

import com.itcast.basic.mybatis.configurationdetail.typehandlerdetail.model.User;

/**
 * Created by Administrator on 2018/1/7.
 */
public interface UserMapper {

    User selectUser(int id);

    int insertUser(User user);
}
