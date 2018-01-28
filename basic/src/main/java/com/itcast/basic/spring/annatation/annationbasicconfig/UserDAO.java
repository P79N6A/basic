package com.itcast.basic.spring.annatation.annationbasicconfig;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by qfl on 16/7/31.
 */
@Repository
public class UserDAO {

    @Resource
    private JDBCUtils jdbcUtils;

    @PostConstruct
    public void init() {
        System.out.println("初始化参数");
    }

    public boolean saveUser(User user) {
        System.out.println("获得数据库连接" + jdbcUtils.getUrl());
        System.out.println("保存成功");
        return true;
    }

    @PreDestroy
    public void close() {
        System.out.println("关闭数据看连接");
    }
}
