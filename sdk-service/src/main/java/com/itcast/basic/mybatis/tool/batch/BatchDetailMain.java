package com.itcast.basic.mybatis.tool.batch;

import com.itcast.basic.mybatis.tool.batch.model.User;
import com.itcast.basic.mybatis.tool.batch.service.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by Administrator on 2018/1/21.
 */
public class BatchDetailMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into BatcnDetailMain");
            Reader reader = Resources.getResourceAsReader("mybatis/tool/batch/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            for (int i = 0; i < 9; i++) {
                User user = new User();
                user.setName("lily" + i);
                user.setNickName("treey" + i);
                user.setSchool("wuhan" + i);
                userMapper.insertUser(user);
            }
            User user = new User();
            user.setName("lily");
            user.setNickName("treey");
            user.setSchool("wuhan");
            int result = userMapper.insertUser(user);
//            sqlSession.flushStatements();
//            User userResult = userMapper.selectUserByName("lily");
//            System.out.println("result=" + result + " userResult=" + userResult + " user=" + user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
