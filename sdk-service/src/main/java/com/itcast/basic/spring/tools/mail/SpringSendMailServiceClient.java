package com.itcast.basic.spring.tools.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

/**
 * Created by treey.qian on 2017/10/24.
 */
public class SpringSendMailServiceClient {
    private static final Log logger = LogFactory.getLog(SpringSendMailServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringSendMailServiceClient");
//            sendMail();
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/tools/mail/application.xml"});
            MailSender mailSender = (MailSender) applicationContext.getBean("mailSender");
//            mailSender.sendMail("测试邮件", "你好", new String[]{"3282749833@qq.com", "2235362731@qq.com"}, "utf-8");
//            mailSender.sendMailAndCc("测试邮件", "你好", new String[]{"2235362731@qq.com"}, "utf-8", new String[]{"3282749833@qq.com"});
            String path = Class.class.getClass().getResource("/").getPath() + "spring/tools/mail/file/01.jpg";
            path = Class.class.getClass().getResource("/").getPath() + "spring/tools/mail/file/order.xlsx";
            path = Class.class.getClass().getResource("/").getPath() + "spring/tools/mail/file/zkI.zip";
            logger.info("path=" + path);
            mailSender.sendMailAndCcWithAttachments("测试邮件", "你好", new String[]{"2235362731@qq.com"}, "utf-8", new String[]{"3282749833@qq.com"}, new File[]{new File(path)});
//            mailSender.sendMailWithAttachments("测试邮件", "你好", new String[]{"2235362731@qq.com"}, "utf-8", new File[]{new File(path)});
//            JavaMailSender mailSender = (JavaMailSender) applicationContext.getBean("javaMailSender");
//            MimeMessage message = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
//            helper.setFrom("1258166167@qq.com");
//            helper.setTo("3282749833@qq.com");
//            helper.setSubject("测试邮件");
//            helper.setText("你好", true);
//            mailSender.send(message);
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
    }

    public static void sendMail() throws MessagingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setDefaultEncoding("utf-8");
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(465);
        mailSender.setUsername("1258166167@qq.com");
        mailSender.setPassword("zvnwngkjlczsgbce");

        Properties javaMailProperties = System.getProperties();
        javaMailProperties.put("mail.smtp.auth", true);
        javaMailProperties.put("mail.debug", true);
//        javaMailProperties.setProperty("mail.host", "smtp.qq.com");
        javaMailProperties.setProperty("mail.smtp.timeout", "2500");
//        javaMailProperties.setProperty("mail.transport.protocol", "smtp");
        javaMailProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        javaMailProperties.setProperty("mail.smtp.port", "465");
//        javaMailProperties.setProperty("mail.smtp.socketFactory.port", "465");

        mailSender.setJavaMailProperties(javaMailProperties);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        helper.setFrom("1258166167@qq.com");
        helper.setTo("3282749833@qq.com");
        helper.setSubject("测试邮件");
        helper.setText("你好", true);
        mailSender.send(message);
    }
}
