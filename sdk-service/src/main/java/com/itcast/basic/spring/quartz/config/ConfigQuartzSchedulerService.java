package com.itcast.basic.spring.quartz.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by treey.qian on 2017/10/25.
 */
public class ConfigQuartzSchedulerService implements Job {

    private final Log log = LogFactory.getLog(ConfigQuartzSchedulerService.class);
    private final String paramSplitSign = ";";
    private final String paramElementSplitSign = ":";

    private String targetClassName;
    private String invokeMethodName;
    private String cronExpression;
    private String methodParams;
    private Scheduler scheduler;

    public String getTargetClassName() {
        return targetClassName;
    }

    public void setTargetClassName(String targetClassName) {
        this.targetClassName = targetClassName;
    }

    public String getInvokeMethodName() {
        return invokeMethodName;
    }

    public void setInvokeMethodName(String invokeMethodName) {
        this.invokeMethodName = invokeMethodName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(String methodParams) {
        this.methodParams = methodParams;
    }

    public ConfigQuartzSchedulerService() {
        init();
    }

    public ConfigQuartzSchedulerService(String targetClassName, String invokeMethodName, String cronExpression, String methodParams) {
        this.targetClassName = targetClassName;
        this.invokeMethodName = invokeMethodName;
        this.cronExpression = cronExpression;
        this.methodParams = methodParams;
    }

    public void init() {
        ResourceBundle bundle = ResourceBundle.getBundle("spring/quartz/config/quartz");
        targetClassName = bundle.getString("jobClassName");
        invokeMethodName = bundle.getString("jobMethodName");
        cronExpression = bundle.getString("jobCronExpression");
        methodParams = bundle.getString("jobMethodParams");
    }

    public boolean start() {
        boolean isSuccess = false;
        try {
            log.info("scheduler config is " + toString());
            //初始化一个quartz容器
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            scheduler = schedulerFactory.getScheduler();
            JobDetail jobDetail = new JobDetailImpl("jobDetail", "jobGroup", this.getClass());
            CronTrigger cronTrigger = new CronTriggerImpl("cronTrigger", "triggerGroup", cronExpression);
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();
        } catch (Exception e) {
            log.info("启动任务失败，错误原因如下:{}", e);
        }
        return isSuccess;
    }

    public boolean stop() {
        boolean isSuccess = false;
        try {
            if (scheduler != null) {
                scheduler.shutdown();
            }
            isSuccess = true;
        } catch (Exception e) {
            log.info("停止任务失败，错误原因如下:{}", e);
        }
        return isSuccess;
    }

    @Override
    public String toString() {
        return "{" +
                "targetClassName='" + targetClassName + '\'' +
                ", invokeMethodName='" + invokeMethodName + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", methodParams='" + methodParams + '\'' +
                '}';
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            //构造一个参数集合
            Map paramMap = new HashMap();
            String[] params = methodParams.split(paramSplitSign);
            for (String param : params) {
                String[] pAr = param.split(paramElementSplitSign);
                paramMap.put(pAr[0], pAr[1]);
            }
            //动态执行定时任务方法
            Class targetClass = Class.forName(targetClassName);
            Object object = targetClass.newInstance();
            Method method = targetClass.getMethod(invokeMethodName, Map.class);
            method.invoke(object, paramMap);
        } catch (Exception e) {
            log.info("启动任务失败，错误原因如下:{}", e);
            throw new JobExecutionException("启动任务失败", e);
        }
    }
}
