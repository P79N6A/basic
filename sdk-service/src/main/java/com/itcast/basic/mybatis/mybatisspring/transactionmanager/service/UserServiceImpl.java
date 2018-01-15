package com.itcast.basic.mybatis.mybatisspring.transactionmanager.service;

import com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.model.User;
import com.itcast.basic.mybatis.mybatisspring.transactionmanager.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by treey.qian on 2018/1/15.
 */
@Service("userService")
public class UserServiceImpl {

    @Autowired
    private UserDao userDao;

    @Autowired
    @Qualifier("userService")
    private UserServiceImpl userService;

    @Transactional
    public int updateUser(User user) throws InterruptedException {
        int result = userDao.updateUser(user);
        userService.insertUser(user);
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insertUser(User user) {
        int result = userDao.insertUser(user);
        return result;
    }
}
