package com.itcast.basic.mybatis.datatools;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

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

//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis/datatool/mybatis.xml"));
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            User user = userMapper.selectUser(1);
//            System.out.println("user=" + user);

            //编码方式实现
            //datasource
            PooledDataSource dataSource = new PooledDataSource();
            dataSource.setDriver("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/tongzhuwang");
            dataSource.setUsername("root");
            dataSource.setPassword("a123456");
            //transactionManager
            JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();
            //enviroment
            Environment environment = new Environment("development", jdbcTransactionFactory, dataSource);
            //configuration
            Configuration configuration = new Configuration(environment);
            //registry alias
            configuration.getTypeAliasRegistry().registerAlias("User", User.class);
            //add mapper
            configuration.addMapper(UserMapper.class);
            //create sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            //open sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //use mapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectUser(1);
            //use ibatis
            sqlSession.selectOne("selectUser",1);
            System.out.println("user=" + user);
        } catch (Exception e) {
            System.out.println("error message is" + e);
        }
    }
}





































