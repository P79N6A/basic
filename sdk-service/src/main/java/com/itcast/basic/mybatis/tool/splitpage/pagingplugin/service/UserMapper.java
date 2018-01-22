package com.itcast.basic.mybatis.tool.splitpage.pagingplugin.service;

import com.itcast.basic.mybatis.tool.splitpage.pagingplugin.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by treey.qian on 2018/1/22.
 */
public interface UserMapper {
    List<User> findUserByName(@Param("name") String name);
}
