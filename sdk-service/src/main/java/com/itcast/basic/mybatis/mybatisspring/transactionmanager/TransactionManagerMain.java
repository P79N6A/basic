package com.itcast.basic.mybatis.mybatisspring.transactionmanager;

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
//            int result = userService.testTransaction();
//            int result = userService.testTrtansactionTarget0();
            int result = userService.testTrtansactionTarget1();
//            int result = userService.testTransactionInThread();
//            int result = userService.testTransactionServiceMethod();
//            int result = userService.testNestedTransaction();
//            int result = userService.testRollbackNestedTransaction();
            System.out.println("result=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
