package com.itcast.basic.spring.dubbo.mergegroups.dto;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class RequestDto implements Serializable {

    private String systemId;
    private String type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "systemId='" + systemId + '\'' +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
