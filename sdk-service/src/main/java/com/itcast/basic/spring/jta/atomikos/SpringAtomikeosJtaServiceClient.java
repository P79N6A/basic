package com.itcast.basic.spring.jta.atomikos;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.UserTransaction;

/**
 * Created by treey.qian on 2017/10/20.
 */
public class SpringAtomikeosJtaServiceClient {
    private static final Log logger = LogFactory.getLog(SpringAtomikeosJtaServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringAtomikeosJtaServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/jta/atomikos/application.xml"});
            JtaTransactionManager transactionManager = (JtaTransactionManager) applicationContext.getBean("transactionManager");
            JdbcTemplate jdbcTemplate = new JdbcTemplate();
            if (transactionManager != null) {
                //获取分布式事务
                UserTransaction userTransaction = transactionManager.getUserTransaction();
                //开启事务
                userTransaction.begin();
                AtomikosDataSourceBean orderSource = (AtomikosDataSourceBean) applicationContext.getBean("orderSource");
                jdbcTemplate.setDataSource(orderSource);
                jdbcTemplate.execute("INSERT INTO student (`id`, `name`, `school`, `birth`) VALUES ('8', 'lily', 'xiamen', '2017-10-19 22:19:52')");
                AtomikosDataSourceBean refundDatasource = (AtomikosDataSourceBean) applicationContext.getBean("refundDatasource");
                jdbcTemplate.setDataSource(refundDatasource);
                jdbcTemplate.execute("INSERT INTO student (`id`, `name`, `school`, `birth`) VALUES ('8', 'lily', 'xiamen', '2017-10-19 22:19:52')");
                //提交事务
                userTransaction.commit();
            }
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
    }

}
