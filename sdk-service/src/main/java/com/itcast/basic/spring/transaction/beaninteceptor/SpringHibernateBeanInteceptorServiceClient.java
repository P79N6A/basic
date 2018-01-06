package com.itcast.basic.spring.transaction.beaninteceptor;

import com.itcast.basic.spring.transaction.BaseDao;
import com.itcast.basic.spring.transaction.Student;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by treey.qian on 2017/10/19.
 */
public class SpringHibernateBeanInteceptorServiceClient {

    private static final Log log = LogFactory.getLog(SpringHibernateBeanInteceptorServiceClient.class);

    public static void main(String[] args) {
        try {
            log.info("enter into SpringHibernateTxAdvisorServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/transaction/beaninteceptor/application.xml"});
            BaseDao baseDao = (BaseDao) applicationContext.getBean("studentDao");
            List<Student> students = baseDao.queryForList("from Student");
            for (Student student : students) {
                log.info("student=" + student);
            }
        } catch (Exception e) {
            log.info("error message is {}", e);
        }
    }
}
