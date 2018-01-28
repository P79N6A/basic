package com.itcast.basic.mybatis.tool.splittable.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by treey.qian on 2018/1/22.
 */
public class DateTools {

    /**
     * 根据日期构造表名
     *
     * @param date
     * @return
     */
    public static String parseDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        return simpleDateFormat.format(date);
    }

    private DateTools() {

    }
}
