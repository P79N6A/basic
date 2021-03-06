package com.itcast.basic.spring.spring.example3;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/8/25.
 */
public class HelloWorldClient {

    private static final Log log = LogFactory.getLog(HelloWorldClient.class);

    public HelloWorldClient() {
//        try {
//            log.info("enter example3.HelloWorldClient");
//            Resource resource=new ClassPathResource("spring/spring.xml");
//            BeanFactory beanFactory=new XmlBeanFactory(resource);
//            HelloWorld helloWorld=(HelloWorld)beanFactory.getBean("helloWorld");
//            log.info("content is " + helloWorld.getContent());
//        } catch (Exception e) {
//            log.info("error is {}", e);
//        }
        try {
            log.info("enter example3.HelloWorldClient");
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/application.xml"});
            HelloWorld helloWorld = (HelloWorld) classPathXmlApplicationContext.getBean("helloWorld");
            log.info("content is " + helloWorld.getContent());
        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }

    public static void main(String[] args) {
        new HelloWorldClient();
    }
}
