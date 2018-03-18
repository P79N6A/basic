package com.itcast.basic.jdk.util.common;

/**
 * Created by qfl on 2018/3/18.
 */
public class CommonUtilsMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into CommonUtilsMain");
//            int[] a = new int[]{3, 2, 7, 5, 4, 1};
//            DataArrays.sort(a);
//            System.out.println("a=" + DataArrays.toString(a));
//            String dateFormat = "yyyy-MM-dd HH:mm:ss";
//            System.out.println("now is " + CommonUtils.convertDateToText(dateFormat, new Date()));
//            Date date = CommonUtils.initDate(TimeModel.HOUR, 3);
//            String today = CommonUtils.convertDateToText(dateFormat, date);
//            Date time = CommonUtils.convertDateFromText(dateFormat, today);
//            System.out.println("today is " + today);
//            System.out.println("today is " + time);
            System.out.println("uuid is " + CommonUtils.uuid());
            System.out.println("random is " + CommonUtils.random(200));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
