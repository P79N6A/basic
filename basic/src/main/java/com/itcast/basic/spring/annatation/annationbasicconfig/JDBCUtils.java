package com.itcast.basic.spring.annatation.annationbasicconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by qfl on 16/7/31.
 */
@Component
public class JDBCUtils {

    @Value("url")
    private String url;
    @Value("charSet")
    private String charSet;
    @Value("userName")
    private String userName;
    @Value("password")
    private String password;

    public JDBCUtils(String url, String charSet, String userName, String password) {
        this.url = url;
        this.charSet = charSet;
        this.userName = userName;
        this.password = password;
    }

    public JDBCUtils() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCharSet() {
        return charSet;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String password) {
        this.password = password;
    }
}
