package com.itcast.basic.mybatis.datatools;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * Created by Administrator on 2018/1/6.
 */
public class JDBCUtils {

    private Connection connection;

    public JDBCUtils(String url, String user, String pasword) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pasword);
        } catch (Exception e) {
            System.out.println("error message is " + e);
        }
    }

    //insert
    public boolean insert(User user) {
        boolean isSuccess = false;
        if (user != null) {
            StringBuilder sqlBuilder = new StringBuilder();
            StringBuilder columnBuilder = new StringBuilder("insert into ")
                    .append(new StringBuffer(user.getClass().getSimpleName().toLowerCase()).append("s").toString()).append(" ( ");
            StringBuilder valueBuilder = new StringBuilder("(");
            try {
                Field[] fields = user.getClass().getDeclaredFields();
                for (Field field : fields) {
                    String fieldName = field.getName();
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, user.getClass());
                    Method fieldReadMethod = propertyDescriptor.getReadMethod();
                    Object fieldValue = fieldReadMethod.invoke(user, null);
                    System.out.println("fieldName= " + fieldName + " methodName= " + fieldReadMethod.getName() + " fieldValue= " + fieldValue);
                    if (fieldValue != null && !"".equals(fieldValue.toString().trim())) {
                        if (fieldValue instanceof Number) {
                            valueBuilder.append(fieldValue);
                        } else if (fieldValue instanceof String || fieldValue instanceof Character) {
                            valueBuilder.append("\'").append(fieldValue).append("\'");
                        } else if (fieldValue instanceof Boolean) {
                            if (((Boolean) fieldValue).booleanValue()) {
                                valueBuilder.append(1);
                            } else {
                                valueBuilder.append(0);
                            }
                        }
                        if (fieldValue instanceof Boolean) {
                            int len = fieldName.length();
                            StringBuilder revertBuilder = new StringBuilder("is");
                            for (int i = 0; i < len; i++) {
                                char c = fieldName.charAt(i);
                                if (i == 0) {
                                    revertBuilder.append(Character.toUpperCase(c));
                                } else {
                                    revertBuilder.append(c);
                                }
                            }
                            fieldName = revertBuilder.toString();
                        }
                        valueBuilder.append(",");
                        columnBuilder.append(propertyToColumn(fieldName)).append(",");
                    }
                }
                String columnStr = columnBuilder.toString();
                String valueStr = valueBuilder.toString();
                sqlBuilder.append(columnStr.substring(0, columnStr.length() - 1))
                        .append(" ) values ")
                        .append(valueStr.substring(0, valueStr.length() - 1))
                        .append(")");
                String exeSql = sqlBuilder.toString();
                System.out.println("sql is " + exeSql);
                Statement statement = connection.createStatement();
                isSuccess = statement.execute(exeSql);
            } catch (Exception e) {
                System.out.println("error message is " + e);
            }
        }
        return isSuccess;
    }

    //select
    public List<User> select(User user) {
        List<User> users = new ArrayList<>();
        if (user != null) {
            try {
                StringBuilder sqlBuilder = new StringBuilder("select * from ")
                        .append(new StringBuffer(user.getClass().getSimpleName().toLowerCase()).append("s").toString());
                Map<String, Object> paramMap = new HashMap();
                Field[] fields = user.getClass().getDeclaredFields();
                for (Field field : fields) {
                    String fieldName = field.getName();
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, user.getClass());
                    Method fieldReadMethod = propertyDescriptor.getReadMethod();
                    Object fieldValue = fieldReadMethod.invoke(user, null);
                    System.out.println("fieldName= " + fieldName + " methodName= " + fieldReadMethod.getName() + " fieldValue= " + fieldValue);
                    if (fieldValue != null) {
                        if (fieldValue instanceof Boolean) {
                            int len = fieldName.length();
                            StringBuilder revertBuilder = new StringBuilder("is");
                            for (int i = 0; i < len; i++) {
                                char c = fieldName.charAt(i);
                                if (i == 0) {
                                    revertBuilder.append(Character.toUpperCase(c));
                                } else {
                                    revertBuilder.append(c);
                                }
                            }
                            fieldName = revertBuilder.toString();
                            if (((Boolean) fieldValue).booleanValue()) {
                                paramMap.put(propertyToColumn(fieldName), 1);
                            } else {
                                paramMap.put(propertyToColumn(fieldName), 0);
                            }
                        } else {
                            paramMap.put(propertyToColumn(fieldName), fieldValue);
                        }
                    }
                }
                Set<Map.Entry<String, Object>> entrySet = paramMap.entrySet();
                if (!entrySet.isEmpty()) {
                    sqlBuilder.append(" where ");
                    for (Map.Entry<String, Object> entry : entrySet) {
                        String filedName = entry.getKey();
                        Object fieldValue = entry.getValue();
                        if (fieldValue instanceof Number) {
                            if (((Number) fieldValue).intValue() == 0 && filedName.trim().equals("id")) {
                                continue;
                            } else {
                                sqlBuilder.append(filedName).append("=").append(fieldValue).append(" and ");
                            }
                        } else {
                            if (!"".equals(fieldValue.toString().trim())) {
                                sqlBuilder.append(filedName).append(" = ").append("\'").append(fieldValue).append("\'").append(" and ");
                            }
                        }
                    }
                    String sqlStr = sqlBuilder.toString();
                    String exeSql = sqlStr.substring(0, sqlStr.length() - 4);
                    System.out.println("exeSql= " + exeSql);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(exeSql);
                    while (resultSet.next()) {
                        user = new User();
                        for (Field field : fields) {
                            String typeName = field.getType().getSimpleName();
                            String fieldName = field.getName();
                            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, user.getClass());
                            Method fieldWriteMethod = propertyDescriptor.getWriteMethod();
                            if (typeName.trim().equals("boolean")) {
                                int len = fieldName.length();
                                StringBuilder revertBuilder = new StringBuilder("is");
                                for (int i = 0; i < len; i++) {
                                    char c = fieldName.charAt(i);
                                    if (i == 0) {
                                        revertBuilder.append(Character.toUpperCase(c));
                                    } else {
                                        revertBuilder.append(c);
                                    }
                                }
                                fieldName = revertBuilder.toString();
                            }
                            if (typeName.trim().equals("int")) {
                                fieldWriteMethod.invoke(user, resultSet.getInt(propertyToColumn(fieldName)));
                            } else if (typeName.trim().equals("String")) {
                                fieldWriteMethod.invoke(user, resultSet.getString(propertyToColumn(fieldName)));
                            } else if (typeName.trim().equals("boolean")) {
                                fieldWriteMethod.invoke(user, resultSet.getBoolean(propertyToColumn(fieldName)));
                            }
                        }
                        users.add(user);
                    }
                    System.out.println("size is " + users.size());
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error message is" + e);
            }
        }
        return users;
    }

    private String propertyToColumn(String property) {
        if (property == null || "".equals(property.trim())) {
            throw new IllegalArgumentException("property is not valid");
        }
        StringBuilder columnBuilder = new StringBuilder();
        int len = property.length();
        for (int i = 0; i < len; i++) {
            char c = property.charAt(i);
            if (Character.isUpperCase(c)) {
                columnBuilder.append("_").append(Character.toLowerCase(c));
            } else {
                columnBuilder.append(c);
            }
        }
        return columnBuilder.toString();
    }
}






















