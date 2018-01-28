package com.itcast.basic.spring.annatation.annationbasicconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qfl on 16/7/31.
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void save(User user) {
        userDAO.saveUser(user);
    }
}
