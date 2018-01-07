package com.itcast.basic.mybatis.configurationdetail.typealiasesdetail;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.TypeAliasRegistry;

import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2018/1/7.
 */
public class TypeAliasesDetailClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into TypeAliasesDetailClient");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis/configurationdetail/typealiasesdetail/mybatis.xml"));
            Configuration configuration = sqlSessionFactory.getConfiguration();
            TypeAliasRegistry registry = configuration.getTypeAliasRegistry();
            Map<String, Class<?>> stringClassMap = registry.getTypeAliases();
            Set<Map.Entry<String, Class<?>>> entrySet = stringClassMap.entrySet();
            for (Map.Entry<String, Class<?>> entry : entrySet) {
                System.out.println("key=" + entry.getKey() + " className=" + entry.getValue().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
