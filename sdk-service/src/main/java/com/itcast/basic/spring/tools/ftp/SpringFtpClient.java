package com.itcast.basic.spring.tools.ftp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by treey.qian on 2017/10/24.
 */
public class SpringFtpClient {

    private final Log logger = LogFactory.getLog(SpringFtpClient.class);

    /**
     * ftp服务器主机地址
     */
    private String ftpHost;
    /**
     * ftp服务器端口号
     */
    private int ftpPort;
    /**
     * 登录用户
     */
    private String loginName;
    /**
     * 登录密码
     */
    private String loginPassword;
    /**
     * 连接超时时间
     */
    private int connectTimeout;
    /**
     * 传输超时时间
     */
    private int dataTimeout;
    /**
     * 缓冲器大小
     */
    private int bufferSize;
    /**
     * 文件编码
     */
    private String controlEncoding;
    /**
     * 传输的文件类型
     */
    private int fileType;

    /**
     * 是否开启ftp文件上传
     */
    private boolean openUpload;

    public String getFtpHost() {
        return ftpHost;
    }

    public void setFtpHost(String ftpHost) {
        this.ftpHost = ftpHost;
    }

    public int getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(int ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getDataTimeout() {
        return dataTimeout;
    }

    public void setDataTimeout(int dataTimeout) {
        this.dataTimeout = dataTimeout;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public String getControlEncoding() {
        return controlEncoding;
    }

    public void setControlEncoding(String controlEncoding) {
        this.controlEncoding = controlEncoding;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public boolean isOpenUpload() {
        return openUpload;
    }

    public void setOpenUpload(boolean openUpload) {
        this.openUpload = openUpload;
    }

    private FTPClient ftpClient;


    public void init() throws Exception {
        //输出ftp服务器配置
        logger.info("当前ftp服务器连接配置为;ftpConfig=" + toString());
        //创建ftp服务器连接
        ftpClient = new FTPClient();
        // 连接服务器
        ftpClient.connect(getFtpHost(), getFtpPort());
        // 是否登录成功
        boolean loginStatus = ftpClient.login(getLoginName(), getLoginPassword());
        // 登录失败释放连接
        if (!loginStatus) {
            logger.info("登录失败(loginName ==> " + getLoginName() + " loginPassword ==> "
                    + getLoginPassword() + ")");
        } else {
            logger.info("登录成功(loginName ==> " + getLoginName() + " loginPassword ==> "
                    + getLoginPassword() + ")");
            // 判断当前连接是否可用
            if (!(FTPReply.isPositiveCompletion(ftpClient.getReplyCode()))) {
                logger.info("当前ftp服务器连接不可用:ftpClient=" + ftpClient);
                throw new Exception("当前ftp服务器连接不可用");
            }
            // 设置被动模式(向ftp上传文件)
            if (isOpenUpload()) {
                ftpClient.enterLocalPassiveMode();
            }

            if (connectTimeout > 0) {
                // 设置连接超时时间
                ftpClient.setConnectTimeout(getConnectTimeout());
            }

            if (dataTimeout >= 0) {
                // 设置传输超时时间
                ftpClient.setDataTimeout(getDataTimeout());
            }

            if (bufferSize > 0) {
                // 设置缓冲器大小
                ftpClient.setBufferSize(getBufferSize());
            }

            if (fileType > 0) {
                // 设置文件传输流类型,默认是ASCII
                ftpClient.setFileType(getFileType());
            }

            if (controlEncoding != null) {
                // 设置文件编码
                ftpClient.setControlEncoding(getControlEncoding());
            }
            // 创建ftp服务器连接成功
            logger.info("获取前置机ftp服务器连接成功");
        }
    }

    public FTPFile[] listFile(String remotePath) {
        FTPFile[] ftpFiles = null;
        try {
            if (checkRemotePathExist(remotePath)) {
                ftpFiles = ftpClient.listFiles();
            }
        } catch (Exception e) {
            logger.info("listFile error message is {}", e);
        }
        return ftpFiles;
    }

    public boolean download(String remotePath, String localPath) {
        boolean isSuccess = false;
        try {
            if (checkRemotePathExist(remotePath)) {
                FTPFile[] ftpFiles = ftpClient.listFiles();
                for (FTPFile ftpFile : ftpFiles) {
                    String fileName = ftpFile.getName();
                    long beginTime = System.currentTimeMillis();
                    isSuccess = ftpClient.retrieveFile(fileName, new FileOutputStream(new StringBuilder(localPath).append(fileName).toString()));
                    if (isSuccess) {
                        logger.info("文件( fileName=" + fileName + " )上传成功，耗时" + (System.currentTimeMillis() - beginTime) + "ms");
                    } else {
                        logger.info("文件( fileName=" + fileName + " )上传失败");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            logger.info("download error message is {}", e);
        }
        return isSuccess;
    }

    public boolean upload(String remotePath, String localPath) {
        boolean isSuccess = false;
        try {
            if (checkRemotePathExist(remotePath)) {
                File localFile = new File(localPath);
                if (localFile.isDirectory()) {
                    File[] files = localFile.listFiles();
                    for (File file : files) {
                        long beginTime = System.currentTimeMillis();
                        String fileName = file.getName();
                        isSuccess = ftpClient.storeFile(fileName, new FileInputStream(file));
                        if (isSuccess) {
                            logger.info("文件( fileName=" + fileName + " )下载成功，耗时" + (System.currentTimeMillis() - beginTime) + "ms");
                        } else {
                            logger.info("文件( fileName=" + fileName + " )下载失败");
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.info("upload error message is {}", e);
        }
        return isSuccess;
    }

    public boolean checkRemotePathExist(String remotePath) {
        boolean isExist = false;
        try {
            isExist = ftpClient.changeWorkingDirectory(remotePath);
        } catch (Exception e) {
            logger.info("checkRemotePathExist error message is {}", e);
        }
        return isExist;
    }

    public void close() {
        try {
            if (ftpClient != null) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (Exception e) {
            logger.info("关闭ftp连接失败,异常信息为:{}", e);
            ftpClient = null;
        }
    }

    @Override
    public String toString() {
        return "SpringFtpClient{" +
                "ftpHost='" + ftpHost + '\'' +
                ", ftpPort=" + ftpPort +
                ", loginName='" + loginName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", connectTimeout=" + connectTimeout +
                ", dataTimeout=" + dataTimeout +
                ", bufferSize=" + bufferSize +
                ", controlEncoding='" + controlEncoding + '\'' +
                ", fileType=" + fileType +
                ", openUpload=" + openUpload +
                '}';
    }
}
