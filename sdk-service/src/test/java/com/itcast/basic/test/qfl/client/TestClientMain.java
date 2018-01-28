package com.itcast.basic.test.qfl.client;

import com.itcast.basic.test.qfl.model.Person;
import org.apache.ibatis.executor.statement.CallableStatementHandler;
import org.apache.ibatis.executor.statement.SimpleStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * Created by Administrator on 2018/1/13.
 */
public class TestClientMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into TestClientMain");
            Class classType = Person.class;
            System.out.println("classType= " + classType);

            Class classType0 = Class.forName("com.itcast.basic.test.qfl.model.Person");
            System.out.println("classType0= " + classType0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
