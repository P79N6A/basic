package com.itcast.basic.mybatis.tool.splitpage.pagingplugin.plugin;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by treey.qian on 2018/1/23.
 */
@Intercepts({
        @Signature(type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class}
        )})
public class PagingPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("enter into intercept method");
        //得到执行的方法
        Method method = invocation.getMethod();
        System.out.println("invoke method is " + method.getName());
        //得到sql编译器
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        // 分离代理对象链
        while (metaStatementHandler.hasGetter("h")) {
            Object object = metaStatementHandler.getValue("h");
            metaStatementHandler = SystemMetaObject.forObject(object);
        }
        // 分离最后一个代理对象的目标类
        while (metaStatementHandler.hasGetter("target")) {
            Object object = metaStatementHandler.getValue("target");
            metaStatementHandler = SystemMetaObject.forObject(object);
        }
        //获得mapper
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        //获得配置
        Configuration configuration = mappedStatement.getConfiguration();
        //获得执行sql
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        System.out.println("sql=" + sql);
        String countSql = "select count(*) as total from (" + sql + ")u";
        //获取拦截方法参数
        Connection connection = (Connection) invocation.getArgs()[0];
        PreparedStatement ps = connection.prepareStatement(countSql);
        BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
        BoundSql countBoundSql = new BoundSql(configuration, countSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
        ParameterHandler handler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), countBoundSql);
        handler.setParameters(ps);
        ResultSet resultSet = ps.executeQuery();
        int total = 0;
        while (resultSet.next()) {
            total = resultSet.getInt("total");
        }
        System.out.println("total=" + total);
        StringBuilder stringBuilder = new StringBuilder("select * from ( ");
        stringBuilder.append(sql).append(" ) u").append(" limit 0, 5");
        String newSql = stringBuilder.toString();
        metaStatementHandler.setValue("delegate.boundSql.sql", newSql);
        //参数集合
        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappings();
        for (ParameterMapping parameterMapping : parameterMappingList) {
            System.out.println("parameterMapping=" + parameterMapping);
        }
        //参数对象
        Object parameterObject = boundSql.getParameterObject();
        if (parameterObject instanceof Map) {
            Map<String, Object> parameterMap = (Map<String, Object>) parameterObject;
            for (Map.Entry entry : parameterMap.entrySet()) {
                System.out.println("key=" + entry.getKey() + " value=" + entry.getValue());
            }
        }
        System.out.println("class name of parameterObject is " + parameterObject.getClass().getName());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("enter into plugin method");
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("enter into setProperties method");
    }
}
