package com.itcast.basic.jdk.rpc.transfer;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by treey.qian on 2018/4/3.
 */
public class TransferDto implements Serializable {
    private String beanId;
    private String className;
    private String methodName;
    private Vector<Object> params;

    public Vector<Object> getParams() {
        return params;
    }

    public void setParams(Vector<Object> params) {
        this.params = params;
    }

    public TransferDto() {
    }

    public TransferDto(String beanId, String className, String methodName, Vector<Object> params) {
        this.beanId = beanId;
        this.className = className;
        this.methodName = methodName;
        this.params = params;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }


    @Override
    public String toString() {
        return "TransferDto{" +
                "beanId='" + beanId + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", params=" + params +
                '}';
    }
}
