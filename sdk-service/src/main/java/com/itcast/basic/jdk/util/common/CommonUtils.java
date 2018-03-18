package com.itcast.basic.jdk.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by qfl on 2018/3/18.
 */
public class CommonUtils {

    /**
     * 构造唯一码
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 生成随机数
     *
     * @param limit
     * @return
     */
    public static int random(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

    /**
     * 构造日期
     *
     * @param level
     * @param time
     * @return
     */
    public static Date initDate(TimeModel level, int time) {
        Calendar now = Calendar.getInstance();
        if (level != null && level instanceof TimeModel) {
            switch (level.getIndex()) {
                case 0:
                    now.add(Calendar.SECOND, time);
                    break;
                case 1:
                    now.add(Calendar.MINUTE, time);
                    break;
                case 2:
                    now.add(Calendar.HOUR, time);
                    break;
                case 3:
                    now.add(Calendar.DAY_OF_MONTH, time);
                    break;
                case 4:
                    now.add(Calendar.MONTH, time);
                    break;
                case 5:
                    now.add(Calendar.YEAR, time);
                    break;
            }
        }
        return now.getTime();
    }

    /**
     * 返回指定格式的日期字符串
     *
     * @param format
     * @param date
     * @return
     */
    public static String convertDateToText(String format, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * 返回日期
     *
     * @param format
     * @param text
     * @return
     * @throws ParseException
     */
    public static Date convertDateFromText(String format, String text) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(text);
    }
}
