package com.itcast.basic.jdk.generic;

import com.itcast.basic.jdk.generic.generic.GenericTool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/3.
 */
public class GenericTypeMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into GenericTypeMain");
            GenericTool.getObject(new Integer(2));
            List<?> list = new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
