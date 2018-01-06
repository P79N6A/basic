package com.itcast.basic.spring.context.eventlistener;

import org.springframework.context.ApplicationEvent;

import java.util.Date;

/**
 * Created by treey.qian on 2017/9/5.
 */
public class InvokeEvent extends ApplicationEvent {

    private String caller;
    private Date invokeDate;
    private String methodName;

    public InvokeEvent(Object source) {
        super(source);
    }

    public InvokeEvent(Object source, String caller, Date invokeDate, String methodName) {
        super(source);
        this.caller = caller;
        this.invokeDate = invokeDate;
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        return "InvokeEvent{" +
                "caller='" + caller + '\'' +
                ", invokeDate=" + invokeDate +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}
