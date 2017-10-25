package com.itcast.basic.spring.tools.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Vector;

/**
 * Created by treey.qian on 2017/10/25.
 */
public class SpringSftpClient {

    private final Log logger = LogFactory.getLog(SpringSftpClient.class);
    /**
     * 默认通道类型
     */
    private final String defaultChannel = "sftp";

    private String host;
    private String username;
    private String password;
    private int port;
    private int connectTimeout;
    private String openChannelName = defaultChannel;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getOpenChannelName() {
        return openChannelName;
    }

    public void setOpenChannelName(String openChannelName) {
        this.openChannelName = openChannelName;
    }

    private ChannelSftp channelSftp;

    private Session session;

    public void init() throws JSchException {
        // 创建JSch对象
        JSch jsch = new JSch();
        // 根据用户名，主机ip，端口获取一个Session对象
        session = jsch.getSession(username, host, port);
        logger.info("Session created successfully");
        // 设置密码
        session.setPassword(password);
        //创建会话属性集合
        Properties config = new Properties();
        //设置首次登陆提示，可选值：(ask | yes | no)
        config.put("StrictHostKeyChecking", "no");
        //设置回话属性properties
        session.setConfig(config);
        //设置timeout时间
        if (connectTimeout > 0) {
            session.setTimeout(connectTimeout);
        }
        //建立Session回话
        session.connect();
        logger.info("Session connected successfully.");
        // 打开SFTP通道
        channelSftp = (ChannelSftp) session.openChannel(openChannelName);
        // 建立SFTP通道的连接
        channelSftp.connect();
        logger.info("Connected successfully to sftServer(" + toString() + ")");
    }

    public boolean upload(String remotePath, String localPath) {
        boolean isSuccess = false;
        try {
            if (checkRemotePathExist(remotePath)) {
                File localFile = new File(localPath);
                if (localFile.isDirectory()) {
                    File[] files = localFile.listFiles();
                    for (File file : files) {
                        String fileName = file.getName();
                        long beginTime = System.currentTimeMillis();
                        channelSftp.put(new FileInputStream(file), remotePath + fileName, ChannelSftp.OVERWRITE);
                        logger.info("文件( fileName=" + fileName + " )上传成功，耗时" + (System.currentTimeMillis() - beginTime) + "ms");
                    }
                }
                isSuccess = true;
            }
        } catch (Exception e) {
            logger.info("upload error message is {}", e);
        }
        return isSuccess;
    }

    public boolean download(String remotePath, String localPath) {
        boolean isSuccess = false;
        try {
            if (checkRemotePathExist(remotePath)) {
                Vector<ChannelSftp.LsEntry> lsEntryVector = channelSftp.ls(remotePath);
                for (ChannelSftp.LsEntry lsEntry : lsEntryVector) {
                    String fileName = lsEntry.getFilename();
                    long beginTime = System.currentTimeMillis();
                    logger.info("fileName=" + fileName);
                    if (fileName.startsWith(".")) {
                        continue;
                    }
                    channelSftp.get(remotePath + fileName, localPath + fileName);
                    logger.info("下载文件" + fileName + "耗时" + (System.currentTimeMillis() - beginTime));
                }
                isSuccess = true;
            }
        } catch (Exception e) {
            logger.info("download error message is {}", e);
        }
        return isSuccess;
    }

    public Vector<ChannelSftp.LsEntry> listFile(String remotePath) {
        Vector<ChannelSftp.LsEntry> lsEntryVector = null;
        try {
            if (checkRemotePathExist(remotePath)) {
                lsEntryVector = channelSftp.ls(remotePath);
            }
        } catch (Exception e) {
            logger.info("listFile error message is {}", e);
        }
        return lsEntryVector;
    }

    public boolean checkRemotePathExist(String remotePath) {
        boolean isExist = false;
        try {
            channelSftp.cd(remotePath);
            isExist = true;
        } catch (Exception e) {
            logger.info("checkRemotePathExist error message is {}", e);
        }
        return isExist;
    }

    public void close() {

        if (channelSftp != null && !channelSftp.isClosed()) {
            channelSftp.disconnect();
        }

        if (session != null && session.isConnected()) {
            session.disconnect();
        }
    }


    @Override
    public String toString() {
        return "SpringSftpClient{" +
                "host='" + host + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", port=" + port +
                ", connectTimeout=" + connectTimeout +
                ", openChannelName='" + openChannelName + '\'' +
                '}';
    }
}
