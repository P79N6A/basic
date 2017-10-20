package com.itcast.basic.jdk.jdbc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.ResultSet;

/**
 * Created by treey.qian on 2017/10/19.
 */
public class JDBCUtilServiceClient {
    private static Log logger = LogFactory.getLog(JDBCUtilServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into JDBCUtilServiceClient");
//            queryOne();
//            queryList();
//            batchInsert();
            batchUpdate();
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
    }

    private static void queryOne() throws Exception {
        ResultSet resultSet = JDBCUtils.queryForOne("select * from student");
        while (resultSet.next()) {
            logger.info("resultSet { id=" + resultSet.getInt("id") +
                    " name=" + resultSet.getString("name") +
                    " school=" + resultSet.getString("school") +
                    " birth=" + resultSet.getDate("birth") +
                    " }");
        }
    }

    private static void queryList() throws Exception {
        ResultSet resultSet = JDBCUtils.queryForOne("select * from student where id=?", "1");
        while (resultSet.next()) {
            logger.info("resultSet { id=" + resultSet.getInt("id") +
                    " name=" + resultSet.getString("name") +
                    " school=" + resultSet.getString("school") +
                    " birth=" + resultSet.getDate("birth") +
                    " }");
        }
    }

    private static void batchInsert() {
        boolean isSuccess = JDBCUtils.batchUpdate(new String[]{"insert student(name,school,birth)values(\'lucy\',\'wuhan\',now())", "insert student(name,school,birth)values(\'tim\',\'wuhan\',now())"});
        logger.info("isSuccess=" + isSuccess);
    }

    private static void batchUpdate() {
        boolean isSuccess = JDBCUtils.batchUpdate(new String[]{"update student set school=\'xiamen\' where id=1", "update student set school=\'xiamen\' where id=2"});
        logger.info("isSuccess=" + isSuccess);
    }
}
