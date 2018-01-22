package com.itcast.basic.mybatis.tool.splittable;


import com.itcast.basic.mybatis.tool.splittable.model.User;
import com.itcast.basic.mybatis.tool.splittable.service.UserMapper;
import com.itcast.basic.mybatis.tool.splittable.util.DateTools;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.Date;

/**
 * Created by treey.qian on 2018/1/22.
 */
public class SplitTableDetailMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into SplitTableDetailMain");
            Reader reader = Resources.getResourceAsReader("mybatis/tool/splittable/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            int result = 0;
            String tableName = DateTools.parseDate(new Date());
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            for (int i = 0; i < 9; i++) {
//                User user = new User();
//                user.setNote("this is user" + i);
//                user.setName("name" + i);
//                user.setSchool("school" + i);
//                user.setNickName("nickName" + i);
//                user.setRoleId(1);
//                result += userMapper.insertUser(user, tableName);
//            }
            System.out.println("result=" + result);
            User user = userMapper.findUserById(1, tableName);
            System.out.println("user=" + user);
            result = userMapper.deleteUserById(1, tableName);
            if (result > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
