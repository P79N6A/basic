package com.itcast.basic.mybatis.configurationdetail.propertiesdetail;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.Properties;

/**
 * Created by Administrator on 2018/1/7.
 */
public class PropertiesDetailClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into PropertiesDetailClient");
            Reader configReader = Resources.getResourceAsReader("mybatis/configurationdetail/propertiesdetail/mybatis.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configReader);
//            Configuration configuration = sqlSessionFactory.getConfiguration();
//            Environment environment = configuration.getEnvironment();
//            PooledDataSource dataSource = (PooledDataSource) environment.getDataSource();
//            System.out.println("url=" + dataSource.getUrl());

            Properties properties = new Properties();
            properties.setProperty("driver", "com.mysql.jdbc.Driver");
            properties.setProperty("username", "root");
            properties.setProperty("password", "a123456");
            properties.setProperty("url", "jdbc:mysql://127.0.0.1:3306/tongzhuwang?useUnicode=true&characterEncoding=UTF8&&useCursorFetch=true");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configReader, properties);
            Configuration configuration = sqlSessionFactory.getConfiguration();
            Environment environment = configuration.getEnvironment();
            PooledDataSource dataSource = (PooledDataSource) environment.getDataSource();
            System.out.println("url=" + dataSource.getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
