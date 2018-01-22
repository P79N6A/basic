package com.itcast.basic.mybatis.tool.splitpage.pagingplugin;


import com.itcast.basic.mybatis.tool.splitpage.pagingplugin.model.User;
import com.itcast.basic.mybatis.tool.splitpage.pagingplugin.service.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

/**
 * Created by treey.qian on 2018/1/23.
 */
public class PagingPluginDetailMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into PagingPluginDetailMain");
            Reader reader = Resources.getResourceAsReader("mybatis/tool/splitpage/pagingplugin/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.findUserByName("name%");
            System.out.println("size of userList is " + userList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
