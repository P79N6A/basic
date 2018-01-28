package com.itcast.basic.hibernate.queryway.hql;

import com.itcast.basic.hibernate.queryway.UtilHelper;
import com.itcast.basic.hibernate.queryway.initdata.User;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by qfl on 16/7/8.
 */
public class HibernateQueryHelper {

    private static final int pageSize = 10;

    public static void hqlDemo() {

        int pageIndex = 0;
        //利用事务管理必须开启事务
        Session session = UtilHelper.getQuerySession("com/itcast/basic/hibernate/queryway/hibernate.cfg.xml");

        /**
         * 普通hql查询示例(带分页)
         */
        List<User> userList = (List<User>) session.createQuery("form User u where " +
                "u.age between 18 and 25 " +
                "and " +
                "u.sex = com.itcast.basic.hibernate.queryway.initdata.Sex.MAN " +
                "and " +
                "lower(u.name) like 'li%' " +
                "and " +
                "upper(u.status) in ('HORMAL','CUSTOMER') " +
                "and " +
                "exits (from User u where u.id is not null) " +
                "group by sex order by age desc")
                .setFirstResult(pageIndex)
                .setMaxResults(pageSize)
                .list();

        /**
         * hql普通连接查询示例
         * 左外链接:from User u left join u.userInfo
         * 右外连接:from User u right join u.userInfo
         * 内连接:from User u (inner) join u.userInfo
         * 隐式内连接:from User u where u.userInfo.id = u.id
         */
        List<Object[]> results = (List<Object[]>) session.createQuery("from User u left join u.userInfo").list();

        /**
         * hql迫切连接查询示例
         * 迫切内连接:from User u inner join fetch u.userInfo
         * 迫切左外连接:from User u left join fetch u.userInfo
         * 迫切右外连接:from User u right join fetch u.userInfo
         */
        List<User> users = (List<User>) session.createQuery("from User u inner join fetch u.userInfo").list();

        /**
         * hql投影查询示例
         * 字段投影查询:select u.id,u.name from User u
         * 对象投影查询:select u from User u inner join u.userInfo
         */
        List<Object[]> resultList = session.createQuery("select u.id,u.name from User u").list();

        /**
         * 通过hbm.xml文件中的hql语句查询
         */
        List<User> us = session.getNamedQuery("queryUser").list();

        /**
         * hql集合过滤器查询示例
         */
        User user = (User) session.load(User.class, 1);
        List<User> userResult = (List<User>) session.createFilter(user.getOrders(), "where this.number like :numberBegin order by price desc")
                .setString("numberBegin", "42%")
                .list();
    }
}
