package com.itcast.basic.internationalproperty;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by qfl on 16/5/10.
 */
public class LocalPropertyDemo {
    public static void main(String[] args) {
        ResourceBundle chinaBundle = LocalUtils.getResourceBundle("com/itcast/basic/internationalproperty/resource", Locale.CHINA);
        System.out.println("name= " + chinaBundle.getString("name"));
        ResourceBundle usBundle = LocalUtils.getResourceBundle("com/itcast/basic/internationalproperty/resource", Locale.US);
        System.out.println("name= " + usBundle.getString("name"));
        System.out.println("number=" + LocalUtils.printNumberByLocale(122, Locale.CANADA));
        //①信息格式化串
        String pattern = "At {1,time,short} On {1,date,long}，{0} paid {2,number, currency}.";
        //②用于动态替换占位符的参数
        Object[] params = {"John", new GregorianCalendar().getTime(), 1.0E3};
        System.out.println("message is " + LocalUtils.printMessgeByLocal(params, pattern, Locale.CHINA));

        System.out.println("当前日期为: " + LocalUtils.printDateByLocal("yyyy-MM-dd", new Date()));
        System.out.println("当前日期为: " + LocalUtils.printDateByLocal("HH:mm:ss", new Date()));
        System.out.println("当前日期为: " + LocalUtils.printDateByLocal("yyyy-MM-dd HH:mm:ss", new Date()));
        //加载类资源文件
        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.itcast.basic.internationalproperty.LanguagePorperties", Locale.CHINESE);
        System.out.println(resourceBundle.getObject("China"));
    }
}
