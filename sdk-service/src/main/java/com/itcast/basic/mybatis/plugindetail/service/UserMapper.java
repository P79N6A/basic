package com.itcast.basic.mybatis.plugindetail.service;

import com.itcast.basic.mybatis.plugindetail.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/1/14.
 */
public interface UserMapper {
    User selectUserById(@Param("id") long id);
}
