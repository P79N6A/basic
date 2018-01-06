package com.itcast.basic.spring.spring.example0;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by treey.qian on 2017/8/25.
 */
public class FileHelloStr {
    private final Log log = LogFactory.getLog(FileHelloStr.class);

    private String key;
    private String fileName;

    public FileHelloStr() {
    }

    public FileHelloStr(String key, String fileName) {
        this.key = key;
        this.fileName = fileName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        String content = "";
        try {
            Properties properties = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            properties.load(inputStream);
            inputStream.close();
            content = properties.getProperty(key);
        } catch (Exception e) {
            log.info("error is {}", e);
        }
        return content;

    }
}
