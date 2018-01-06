package com.itcast.basic.spring.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by treey.qian on 2017/8/31.
 */
@Component
public class AnnotationPlainBean {

    private final Log log = LogFactory.getLog(AnnotationPlainBean.class);

    public AnnotationPlainBean() {
        log.info("enter AnnotationPlainBean");
    }

    @PostConstruct
    public void initAfterConstructor() {
        log.info("enter initAfterConstructor");
    }

    @PreDestroy
    public void executedBeforeDestory() {
        log.info("enter executedBeforeDestory");
    }
}
