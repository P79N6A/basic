package com.itcast.basic.mybatis.configurationdetail.typehandlerdetail;

import com.itcast.basic.mybatis.configurationdetail.typehandlerdetail.model.Sex;
import com.itcast.basic.mybatis.configurationdetail.typehandlerdetail.model.User;
import com.itcast.basic.mybatis.configurationdetail.typehandlerdetail.service.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by Administrator on 2018/1/7.
 */
public class TypeHandlerDetailClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into TypeHandlerDetailClient");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis/configurationdetail/typehandlerdetail/mybatis.xml"));
            //设置自动提交
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(4, "lily", "wuhan", Sex.MAN, Sex.MAN);
            int result = userMapper.insertUser(user);
            String databaseId = sqlSession.getConfiguration().getDatabaseId();
            System.out.println("result is " + result + " user=" + user + " databaseId=" + databaseId);
//            user = userMapper.selectUser(2);
//            System.out.println("result is " + user);
            if (result >= 1) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
