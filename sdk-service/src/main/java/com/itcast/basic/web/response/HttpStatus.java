package com.itcast.basic.web.response;

/**
 * Created by Administrator on 2018/1/28.
 */
public enum HttpStatus {

    OK("200", "success"), ERROR("500", "fail");

    HttpStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HttpStatus{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
