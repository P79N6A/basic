package com.itcast.basic.mybatis.manytomany.service;

import com.itcast.basic.mybatis.manytomany.model.Role;

import java.util.List;

/**
 * Created by treey.qian on 2018/1/22.
 */
public interface RoleMapper {
    int insertRole(Role role);

    Role findRoleById(long id);

    List<Role> findRolesByUserId(long userId);
}
