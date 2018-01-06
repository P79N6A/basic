package com.itcast.basic.spring.quartz.simple;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by treey.qian on 2017/10/25.
 */
public class JobService extends QuartzJobBean {

    private final Log logger = LogFactory.getLog(JobService.class);

    private String jobName;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("正在执行定时任务(" + jobName + "),执行时间" + dateFormat.format(new Date()));
    }
}
