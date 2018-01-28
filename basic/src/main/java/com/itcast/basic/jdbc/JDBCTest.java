package com.itcast.basic.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by qfl on 16/6/7.
 */
public class JDBCTest {
    public static void main(String[] args) {
        DBUtils dbUtils = new DBUtils();
        try {
            ResultSet resultSet = dbUtils.exceQuery("select * from user");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") + " " + resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
