package com.itcast.basic.jdbc;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * Created by qfl on 16/6/6.
 */
public class DBUtils {
    private static Properties properties;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    private static final String DRIVER = "mysql.jdbc.driver";
    private static final String URL = "mysql.jdbc.url";
    private static final String USER = "mysql.jdbc.user";
    private static final String PASSWORD = "mysql.jdbc.password";
    private static final String USER_DIR = "user.dir";
    private static final String CONFIGFILE = "DBConfig.properties";
    private static final String SRC = "src";
    private static final String TEMP_SPLIT = "";
    private static final String FILE_SPLIT = File.separator;
    private static final String POINT_SPLIT = ".";
    private static final int ERROR = -1;

    /**
     * 初始化配置文件
     */
    static {
        properties = new Properties();
        try {
            String path = System.getProperty(USER_DIR) + FILE_SPLIT + SRC + FILE_SPLIT + DBUtils.class.getPackage().getName().replace(POINT_SPLIT, FILE_SPLIT) + FILE_SPLIT + CONFIGFILE;
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = threadLocal.get();
        try {
            if (connection == null) {
                Class.forName(properties.getProperty(DRIVER, TEMP_SPLIT).trim());
                connection = DriverManager.getConnection(properties.getProperty(URL, TEMP_SPLIT).trim(), properties.getProperty(USER, TEMP_SPLIT).trim(), properties.getProperty(PASSWORD, TEMP_SPLIT).trim());
                threadLocal.set(connection);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 执行查询得到返回结果
     *
     * @param query 查询语句
     * @return 结果集
     * @throws SQLException
     */
    public static ResultSet exceQuery(String query) throws SQLException {
        return getConnection().createStatement().executeQuery(query);
    }

    /**
     * 可变条件查询集合
     *
     * @param query 查询语句
     * @param args  可变参数集
     * @return
     */
    public static ResultSet exceQuery(String query, Object... args) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            for (int i = 0; i < args.length; i++)
                preparedStatement.setObject(i + 1, args[i]);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * 单条更新语句
     *
     * @param sql 更新语句
     * @return 是否更新成功
     */
    public static boolean exceUpdate(String sql) {
        boolean success = true;
        try {
            int i = getConnection().createStatement().executeUpdate(sql);
            if (i == ERROR)
                success = false;
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    /**
     * @param sqls sql语句集合
     * @return
     * @throws SQLException
     */
    public static boolean exceBatchSql(String... sqls) throws SQLException {

        Connection connection = getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        for (String sql : sqls)
            statement.addBatch(sql);
        int[] results = statement.executeBatch();
        connection.commit();
        return backExceResult(results, connection);
    }

    /**
     * 批量插入
     *
     * @param sql
     * @param args
     * @return
     */
    public static boolean exceBatchInsert(String sql, List<Object[]> args) throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Iterator<Object[]> iterators = args.iterator();
        while (iterators.hasNext()) {
            Object[] objects = iterators.next();
            for (int i = 0; i < objects.length; i++)
                preparedStatement.setObject(i + 1, objects[i]);
            preparedStatement.addBatch();
        }
        int[] results = preparedStatement.executeBatch();
        connection.commit();
        return backExceResult(results, connection);
    }

    /**
     * 检验执行结果
     *
     * @param results
     * @param connection
     * @return
     * @throws SQLException
     */
    private static boolean backExceResult(int[] results, Connection connection) throws SQLException {
        boolean success = true;
        if (Arrays.asList(results).contains(ERROR)) {
            connection.rollback();
            success = false;
        }
        return success;
    }
}
