package com.itcast.basic.spring.quartz.invoke;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by treey.qian on 2017/10/25.
 */
public class LogJobService {
    private final Log logger = LogFactory.getLog(LogJobService.class);

    public void logger() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info(simpleDateFormat.format(new Date()) + "正在写入日志");
    }
}
