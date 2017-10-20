package com.itcast.basic.jpa;

import com.itcast.basic.jpa.domain.Sex;
import com.itcast.basic.jpa.domain.User;
import com.itcast.basic.jpa.domain.UserInfo;
import com.itcast.basic.jpa.user.UserService;
import com.itcast.basic.jpa.user.UserServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/10/20.
 */
public class JPAEntityManagerServiceClient {
    private static final Log logger = LogFactory.getLog(JPAEntityManagerServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into JPAEntityManagerServiceClient");
            UserService userService = new UserServiceImpl();
            User user=new User();
            user.setName("lily");
            user.setIDcard("370406199112165058");
            user.setPhone("18363310143");
            user.setSex(Sex.MAN);
            UserInfo userInfo=new UserInfo();
            userInfo.setNickName("treey");
            userInfo.setCollege("wuhan");
            userInfo.setMarried(false);
            userInfo.setHeight(170.20);
            userInfo.setWeight(65.21);
            user.setUserInfo(userInfo);
            userService.saveUser(user);
        } catch (Exception e) {
            logger.info("JPAEntityManagerServiceClient error message is {}", e);
        }
    }
}
