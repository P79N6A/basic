package com.itcast.basic.spring.tools.mongodb;


import com.itcast.basic.spring.tools.mongodb.model.User;
import com.itcast.basic.spring.tools.mongodb.service.MongoDBServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2018/1/26.
 */
public class MongoDBServiceMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into   MongoDBServiceMain ");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/tools/mongodb/application.xml");
            MongoDBServiceImpl mongoDBService = (MongoDBServiceImpl) applicationContext.getBean("mongoDBService");
            if (mongoDBService != null) {
                User user = new User();
                user.setId(1);
                user.setSchool("wuhan");
                user.setName("lily");
                user.setNumber("1836310143");
                boolean isSuccess = mongoDBService.insertData(user, "user");
                System.out.println("isSuccess=" + isSuccess);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
