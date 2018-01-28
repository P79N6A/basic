package com.itcast.basic.mybatis.plugindetail;

import com.itcast.basic.mybatis.plugindetail.model.User;
import com.itcast.basic.mybatis.plugindetail.service.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by Administrator on 2018/1/14.
 */
public class PluginDetailMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into PluginDetailMain");
            Reader reader = Resources.getResourceAsReader("mybatis/plugindetail/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectUserById(5);
            System.out.println("user=" + user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
