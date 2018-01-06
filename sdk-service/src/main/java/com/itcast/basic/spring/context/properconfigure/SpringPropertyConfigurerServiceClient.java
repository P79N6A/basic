package com.itcast.basic.spring.context.properconfigure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/9/4.
 */
public class SpringPropertyConfigurerServiceClient {

    private static final Log log = LogFactory.getLog(SpringPropertyConfigurerServiceClient.class);


    public static void main(String[] args) {
        try {
            log.info("enter SpringPropertyConfigurerServiceClient");
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/properconfigure/application.xml"});
            DataSourceConfigure dataSourceConfigure = (DataSourceConfigure) classPathXmlApplicationContext.getBean("dataSourceConfigure");
            log.info("dataSourceConfigure=" + dataSourceConfigure);
        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }
}
