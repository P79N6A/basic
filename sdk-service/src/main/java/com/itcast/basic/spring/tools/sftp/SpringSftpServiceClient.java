package com.itcast.basic.spring.tools.sftp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/25.
 */
public class SpringSftpServiceClient {
    private static final Log logger = LogFactory.getLog(SpringSftpServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringSftpServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/tools/sftp/application.xml"});
            SpringSftpClient sftpClient = (SpringSftpClient) applicationContext.getBean("sftpClient");
//            boolean isSuccess = sftpClient.download("/fepftp/black/all/", "D:\\apps\\store\\");
            boolean isSuccess = sftpClient.upload("/fepftp/black/all/", "D:\\apps\\store\\");
//            boolean isSuccess=sftpClient.checkRemotePathExist("/fepftp/black/all/");
//            Vector<ChannelSftp.LsEntry> vector = sftpClient.listFile("/fepftp/black/all/");
//            logger.info("isSuccess="+isSuccess+" size is "+vector.size());
//            for (ChannelSftp.LsEntry lsEntry : vector) {
//                String fileName = lsEntry.getFilename();
//                logger.info("fileName=" + fileName);
//            }
//            logger.info(" size is " + vector.size());
            logger.info("isSuccess=" + isSuccess);
        } catch (Exception e) {
            logger.info("error message is {}", e);
        }
    }
}
