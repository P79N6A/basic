package com.itcast.basic.jpa.user;

import com.itcast.basic.jpa.domain.User;

import java.util.List;

/**
 * Created by qfl on 16/6/10.
 */
public interface UserService {

    void saveUser(User user);

    User findUserById(int id);

    void deleteUser(User user);

    List findUsersByCondition(String sql);

    User findUserByName(String name);
}
