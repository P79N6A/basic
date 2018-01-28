package com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate;

import com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.model.User;
import com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.service.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2018/1/15.
 */
public class SqlSessionTemplateMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into SqlSessionTemplateMain");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath*:mybatis/mybatisspring/sqlsessiontemplate/spring-mybatis.xml"});
            UserDao userDao = (UserDao) applicationContext.getBean("userDao");
//            User user0 = new User();
//            user0.setId(1);
//            int result = userDao.deleteUser(user0);
//            int result = userDao.insertUser(new User("aa", "dd", "ff"));
//            User user = new User();
//            user.setId(51);
//            user.setName("lily");
//            user.setNickName("treey");
//            user.setSchool("wuhan");
//            int result = userDao.updateUser(user);
//            System.out.println("result=" + result);
//            user0 = new User();
//            user0.setId(1);
//            user0 = userDao.findById(user0);
//            user0 = new User();
//            user0.setName("lily");
//            List<User> users = userDao.findByName(user0);
//            System.out.println("user0=" + user0);
            UserDao userMapper = (UserDao) applicationContext.getBean("userMapper");
            User user = userMapper.selectById(2);
            System.out.println("user=" + user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
