package com.itcast.basic.spring.config.ioc.applicationcontextlistener;

import org.springframework.context.ApplicationEvent;

/**
 * Created by qfl on 16/7/29.
 */
public class SimpleApplicationEvent extends ApplicationEvent {
    private String name;
    private String email;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public SimpleApplicationEvent(Object source) {
        super(source);
    }

    public SimpleApplicationEvent(Object source, String name, String email, String content) {
        super(source);
        this.name = name;
        this.email = email;
        this.content = content;
    }

    @Override
    public String toString() {
        return "SimpleApplicationEvent{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
