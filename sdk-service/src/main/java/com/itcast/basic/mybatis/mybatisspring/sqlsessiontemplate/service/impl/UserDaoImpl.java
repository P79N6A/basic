package com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.service.impl;

import com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.model.User;
import com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.service.UserDao;

import java.util.List;

/**
 * Created by treey.qian on 2018/1/15.
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Override
    public int insertUser(User user) {
        return this.getSqlSessionTemplate().insert("com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.service.UserDao.insertUser", user);
    }

    @Override
    public User findById(User user) {
        return this.getSqlSessionTemplate().selectOne("com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.service.UserDao.findById", user);
    }

    @Override
    public List<User> findByName(User user) {
        return this.getSqlSessionTemplate().selectList("com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.service.UserDao.findByName", user);
    }

    @Override
    public int updateUser(User user) {
        return this.getSqlSessionTemplate().update("com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.service.UserDao.updateUser", user);
    }

    @Override
    public int deleteUser(User user) {
        return this.getSqlSessionTemplate().delete("com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.service.UserDao.deleteUser", user);
    }

    @Override
    public User selectById(long id) {
        return null;
    }
}
