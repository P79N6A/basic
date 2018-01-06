package com.itcast.basic.spring.jdbc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by treey.qian on 2017/10/18.
 */
public class SpringJdbcTemplateServiceClient {

    private static final Log log = LogFactory.getLog(SpringJdbcTemplateServiceClient.class);

    private static JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        try {
            log.info("enter into SpringJdbcTemplateServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/jdbc/application.xml"});
            jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
//            createTable();
//            insertStudent();
            queryStudent();
        } catch (Exception e) {
            log.info("SpringJdbcTemplateServiceClient error is {}", e);
        }
    }

    private static void createTable() {
        jdbcTemplate.execute("create table student( " +
                "id INT NOT NULL AUTO_INCREMENT," +
                "name VARCHAR(100) NOT NULL," +
                "school VARCHAR(40) NOT NULL," +
                "birth timestamp," +
                " PRIMARY KEY ( id )"
                + ")ENGINE=InnoDB DEFAULT CHARSET=utf8;");
    }

    private static void insertStudent() {
        jdbcTemplate.execute("insert into student (name,school,birth) values(\'treey\',\'wuhan\',now())");
    }

    private static void queryStudent() {
        List<Student> students = jdbcTemplate.query("select * from student", new UserQueryMapper());
        for (Student student : students) {
            log.info("query result is " + student);
        }
    }
}
