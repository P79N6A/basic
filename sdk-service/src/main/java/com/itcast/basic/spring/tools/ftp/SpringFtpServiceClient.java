package com.itcast.basic.spring.tools.ftp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/24.
 */
public class SpringFtpServiceClient {
    private static final Log logger = LogFactory.getLog(SpringFtpServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringFtpServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/tools/ftp/application.xml"});
            SpringFtpClient ftpClient = (SpringFtpClient) applicationContext.getBean("ftpClient");
//            logger.info(ftpClient.download("/log/", "D:\\apps\\store\\"));
            logger.info(ftpClient.upload("/log/", "D:\\apps\\store\\"));
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
    }

    private static void createFtpClient() {

    }
}
