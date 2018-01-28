package com.itcast.basic.datatype.doubleapi;

import java.math.BigDecimal;

/**
 * Created by qfl on 16/4/19.
 * 由于计算机无法精确的表示浮点数,可以使用BigDecimal(String value)
 */
public class DoubleDemo {
    public static void main(String[] args) {
        System.out.println("欢迎来到神奇的浮点数世界");
        System.out.println("*************************************************************");
        BigDecimal stringBigDecimal = new BigDecimal("0.05");
        System.out.println(stringBigDecimal.add(new BigDecimal("0.01")));
        System.out.println("*************************************************************");
        BigDecimal doubleBigDecimal = new BigDecimal(0.05);
        System.out.println(doubleBigDecimal.add(new BigDecimal(0.01)));
        System.out.println("*************************************************************");
        double d = 0.05;
        double dv = 0.01;
        System.out.println(d + dv);
        System.out.println("*************************************************************");
    }
}
