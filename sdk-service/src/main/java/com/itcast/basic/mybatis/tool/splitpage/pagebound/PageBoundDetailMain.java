package com.itcast.basic.mybatis.tool.splitpage.pagebound;


import com.itcast.basic.mybatis.tool.splitpage.pagebound.model.User;
import com.itcast.basic.mybatis.tool.splitpage.pagebound.service.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

/**
 * Created by treey.qian on 2018/1/22.
 */
public class PageBoundDetailMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into PageBoundDetailMain");
            Reader reader = Resources.getResourceAsReader("mybatis/tool/splitpage/pagebound/mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            int result = 0;
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = userMapper.findUserByName("name%", new RowBounds(0, 5));
            System.out.println("size of users is " + users.size());
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
