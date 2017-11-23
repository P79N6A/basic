package com.itcast.basic.spring.dubbo.mergegroups.dto;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class ResponseDto implements Serializable {

    private String systemId;
    private String message;
    private String code;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
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

    @Override
    public String toString() {
        return "ResponseDto{" +
                "systemId='" + systemId + '\'' +
                ", message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
