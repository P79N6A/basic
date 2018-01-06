package com.itcast.basic.mybatis.datatools;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by Administrator on 2018/1/6.
 */
public class DataToolsClient {
    public static void main(String[] args) {
        try {
//            User user = new User();
//            user.setName("lily");
//            user.setSchool("wuhan");
//            JDBCUtils jdbcUtils = new JDBCUtils("jdbc:mysql://127.0.0.1:3306/tongzhuwang", "root", "a123456");
//            jdbcUtils.insert(user);
//            jdbcUtils.select(user);

//            Configuration configuration = new Configuration().configure("mybatis/datatool/hibernate.cfg.xml");
//            SessionFactory sessionFactory = configuration.buildSessionFactory();
//            Session session = sessionFactory.openSession();
//            User user = session.get(User.class, 1);
//            System.out.println("user=" + user);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis/datatool/mybatis.xml"));
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectUser(1);
            System.out.println("user=" + user);
        } catch (Exception e) {
            System.out.println("error message is" + e);
        }
    }
}
