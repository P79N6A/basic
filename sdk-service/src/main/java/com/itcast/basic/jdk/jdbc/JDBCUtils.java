package com.itcast.basic.jdk.jdbc;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Created by treey.qian on 2017/10/19.
 */
public class JDBCUtils {

    private static final Log log = LogFactory.getLog(JDBCUtils.class);
    private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();
    private static String userName;
    private static String password;
    private static String url;
    private static String driverClass;

    private JDBCUtils() {

    }

    static {
        try {
            initConfig();
        } catch (Exception e) {
            log.info("initConfig error,message is {}", e);
        }
    }

    private static void initConfig() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdk/jdbc/jdbc");
        if (resourceBundle != null) {
            userName = resourceBundle.getString("jdbc.user");
            if (userName != null) {
                userName = userName.trim();
                log.info("jdbc.user is " + userName);
            } else {
                throw new Exception("数据库用户名不存在");
            }

            password = resourceBundle.getString("jdbc.password");
            if (password != null) {
                password = password.trim();
                log.info("jdbc.password is " + password);
            } else {
                throw new Exception("数据库用户密码不存在");
            }

            driverClass = resourceBundle.getString("jdbc.driver");
            if (driverClass != null) {
                driverClass = driverClass.trim();
                log.info("jdbc.driver is " + driverClass);
            } else {
                throw new Exception("数据库驱动类名不存在");
            }

            url = resourceBundle.getString("jdbc.url");
            if (url != null) {
                url = url.trim();
                log.info("jdbc.url is " + url);
            } else {
                throw new Exception("数据库连接地址不存在");
            }
        } else {
            throw new Exception("数据库连接资源文件不存在");
        }
    }

    public static Connection newConInstance() throws Exception {

        try {
            Connection connection = connectionThreadLocal.get();
            if (connection != null) {
                return connection;
            } else {
                Class.forName(driverClass);
                connection = DriverManager.getConnection(url, userName, password);
                connectionThreadLocal.set(connection);
                return connection;
            }
        } catch (ClassNotFoundException e) {
            throw new Exception("数据库驱动加载异常");
        } catch (SQLException e) {
            throw new Exception("获取获取数据库连接异常");
        }
    }

    /**
     * 条件查询
     *
     * @param sql
     * @param params
     * @return
     */
    public static ResultSet queryForOne(String sql, String... params) throws Exception {
        Connection connection = newConInstance();
        ResultSet resultSet;
        if (params == null || params.length == 0) {
            log.info("queryForOne execute sql is " + sql);
            resultSet = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY).executeQuery();
        } else {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            log.info("queryForOne execute sql is " + sql);
            StringBuilder stringBuilder = new StringBuilder("params{ ");
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
                stringBuilder.append(params[i]).append(" ");
            }
            stringBuilder.append(" }");
            log.info("params is " + stringBuilder.toString());
            resultSet = preparedStatement.executeQuery();
        }
        return resultSet;
    }

    /**
     * 批次处理
     */
    public static boolean batchUpdate(String[] sqls) {
        boolean isSuccess = false;
        try {
            if (sqls != null) {
                Connection connection = newConInstance();
                connection.setAutoCommit(false);
                Statement statement = connection.createStatement();
                for (String sql : sqls) {
                    statement.addBatch(sql);
                }
                int[] results = statement.executeBatch();
                if (Arrays.asList(results).contains(-1)) {
                    connection.rollback();
                } else {
                    connection.commit();
                    isSuccess = true;
                }
            }
        } catch (Exception e) {
            log.info("batchUpdate error message is {}", e);
        }
        return isSuccess;
    }

}
