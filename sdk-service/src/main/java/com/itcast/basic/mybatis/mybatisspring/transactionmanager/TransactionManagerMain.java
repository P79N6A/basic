package com.itcast.basic.mybatis.mybatisspring.transactionmanager;

import com.itcast.basic.mybatis.mybatisspring.sqlsessiontemplate.model.User;
import com.itcast.basic.mybatis.mybatisspring.transactionmanager.service.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2018/1/15.
 */
public class TransactionManagerMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into TransactionManagerMain");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath*:mybatis/mybatisspring/transactionmanager/spring-mybatis.xml"});
            System.out.println("applicationContext=" + applicationContext);
            UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
            User user = new User();
            user.setId(51);
            user.setName("admin");
            user.setSchool("wuhan");
            user.setNickName("root");
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
