package com.itcast.basic.spring.tools.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * Created by treey.qian on 2017/10/24.
 */
public class MailSender {

    private final Log logger = LogFactory.getLog(MailSender.class);

    private JavaMailSenderImpl javaMailSender;

    public JavaMailSenderImpl getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public boolean sendMail(String subject, String mailContent, String[] sendTo, String encoding) {
        boolean isSuccess = false;
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, encoding);
            mimeMessageHelper.setFrom(javaMailSender.getUsername());
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setTo(sendTo);
            mimeMessageHelper.setSentDate(new Date());
            mimeMessageHelper.setText(mailContent);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
        return isSuccess;
    }

    public boolean sendMailAndCc(String subject, String mailContent, String[] sendTo, String encoding, String[] sendCc) {
        boolean isSuccess = false;
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, encoding);
            mimeMessageHelper.setFrom(javaMailSender.getUsername());
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setTo(sendTo);
            mimeMessageHelper.setCc(sendCc);
            mimeMessageHelper.setSentDate(new Date());
            mimeMessageHelper.setText(mailContent);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
        return isSuccess;
    }

    public boolean sendMailWithAttachments(String subject, String mailContent, String[] sendTo, String encoding, File[] files) {
        boolean isSuccess = false;
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, encoding);
            mimeMessageHelper.setFrom(javaMailSender.getUsername());
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setTo(sendTo);
            if (files != null) {
                for (File file : files) {
                    mimeMessageHelper.addAttachment(file.getName(), file);
                }
            }
            mimeMessageHelper.setSentDate(new Date());
            mimeMessageHelper.setText(mailContent);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
        return isSuccess;
    }

    public boolean sendMailAndCcWithAttachments(String subject, String mailContent, String[] sendTo, String encoding, String[] sendCc, File[] files) {
        boolean isSuccess = false;
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, encoding);
            mimeMessageHelper.setFrom(javaMailSender.getUsername());
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setTo(sendTo);
            mimeMessageHelper.setCc(sendCc);
            if (files != null) {
                for (File file : files) {
                    mimeMessageHelper.addAttachment(file.getName(), file);
                }
            }
            mimeMessageHelper.setSentDate(new Date());
            mimeMessageHelper.setText(mailContent);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
        return isSuccess;
    }
}
