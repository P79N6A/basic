package com.itcast.basic.internationalproperty;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by qfl on 16/5/10.
 */
public class LocalUtils {

    //①带有语言和国家/地区信息的本地化对象
    Locale locale1 = new Locale("zh", "CN");

    //②只有语言信息的本地化对象
    Locale locale2 = new Locale("zh");

    //③等同于Locale("zh","CN")
    Locale locale3 = Locale.CHINA;

    //④等同于Locale("zh")
    Locale locale4 = Locale.CHINESE;

    //⑤获取本地系统默认的本地化对象
    Locale locale5 = Locale.getDefault();

    //加载制度的资源文件
    public static ResourceBundle getResourceBundle(String path, Locale locale) {
        return ResourceBundle.getBundle(path, locale);
    }

    //按本地格式输出数字
    public static String printNumberByLocale(Number number, Locale locale) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
//        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
//        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        return numberFormat.format(number);
    }

    //按本地格式输出消息
    public static String printMessgeByLocal(Object message, String pattern, Locale locale) {
        MessageFormat messageFormat = new MessageFormat(pattern, locale);
        return messageFormat.format(message);
    }

    //按格式输出日期
    public static String printDateByLocal(String pattern, Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
