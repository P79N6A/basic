package com.itcast.basic.jdk.complier;

import com.itcast.basic.jdk.complier.compiler.CompilerManagerUtils;

/**
 * Created by Administrator on 2018/2/4.
 */
public class ComplierMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into ComplierMain");
            CompilerManagerUtils.compilerSource("E:\\java","E:\\class","tool");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
