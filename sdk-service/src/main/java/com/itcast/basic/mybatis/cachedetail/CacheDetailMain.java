package com.itcast.basic.mybatis.cachedetail;

import com.google.gson.Gson;
import com.itcast.basic.mybatis.cachedetail.model.User;
import com.itcast.basic.mybatis.cachedetail.service.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

/**
 * Created by treey.qian on 2018/1/12.
 */
public class CacheDetailMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into CacheDetailMain");
            Reader reader = Resources.getResourceAsReader("mybatis/cachedetail/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(new Gson().fromJson("[{\"id\":1,\"name\":\"lily0\",\"school\":\"school0\",\"nickName\":\"nickName0\"}]",List.class));
//            int result = 0;
//            for (int i = 0; i < 10; i++) {
//                result += userMapper.insertUser(new User("lily" + i, "school" + i, "nickName" + i));
//            }
//            System.out.println("result=" + result);
//            if (result > 0) {
//                sqlSession.commit();
//            } else {
//                sqlSession.rollback();
//            }
            //mybatis一级缓存 相同sql语句在一级缓存过期时间内仅执行一次sql sqlSession级别
            User user = userMapper.selectUserById(1);
//            user = userMapper.selectUserById(1);
            sqlSession.commit();

            //mybatis二级缓存
            SqlSession sqlSession0 = sqlSessionFactory.openSession();
            UserMapper userMapper0 = sqlSession0.getMapper(UserMapper.class);
            userMapper0.selectUserById(1);
//            user = userMapper0.selectUserById(1);
            sqlSession0.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
