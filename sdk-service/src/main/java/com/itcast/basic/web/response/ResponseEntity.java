package com.itcast.basic.web.response;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/28.
 */
public class ResponseEntity<T> implements Serializable {

    //状态码
    private String code;
    //状态信息
    private String message;
    //附加信息
    private T value;

    public ResponseEntity() {
    }

    public ResponseEntity(HttpStatus httpStatus, T value) {
        this.code = httpStatus.getCode();
        this.message = httpStatus.getMessage();
        this.value = value;
    }

    public ResponseEntity(String code, String message, T value) {
        this.code = code;
        this.message = message;
        this.value = value;
    }

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

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
