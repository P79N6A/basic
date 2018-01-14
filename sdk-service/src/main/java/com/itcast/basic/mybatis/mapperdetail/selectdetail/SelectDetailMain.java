package com.itcast.basic.mybatis.mapperdetail.selectdetail;

import com.itcast.basic.mybatis.mapperdetail.selectdetail.model.User;
import com.itcast.basic.mybatis.mapperdetail.selectdetail.model.UserParam;
import com.itcast.basic.mybatis.mapperdetail.selectdetail.service.UserMapper;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;
import java.util.Map;

/**
 * Created by treey.qian on 2018/1/8.
 */
public class SelectDetailMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into SelectDetailMain");
            Reader reader = Resources.getResourceAsReader("mybatis/mapperdetail/selectdetail/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int result = 0;
//            for (int i = 1; i < 10; i++) {
//                result += userMapper.insertUser(new User(i, "lily" + i, "wuhan", "小菜鸟"));
//            }
//            int count = userMapper.count("lily");
//            System.out.println("count is " + count);
            User user = userMapper.selectUser(1);
            user = userMapper.selectUserById(2);
            System.out.println("user is " + user);
            Map<String, String> params = new HashedMap();
            params.put("name", "lily");
            params.put("school", "wuhan");
            List<User> users = userMapper.selectUserByParams(params);
            users = userMapper.selectUserByConditions("lily", "wuhan");
            users = userMapper.selectUserByUserParam(new UserParam("lily", "wuhan"));
            for (User item : users) {
                System.out.println("item is " + item);
            }
            System.out.println("users size is " + users.size());
            if (result > 0) {
                sqlSession.commit();
                System.out.println("result is " + result);
            } else {
                sqlSession.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
