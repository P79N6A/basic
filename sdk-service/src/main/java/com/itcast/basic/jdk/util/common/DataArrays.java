package com.itcast.basic.jdk.util.common;

import java.util.List;

/**
 * Created by qfl on 2018/3/18.
 * 模拟com.java.util.Arrays
 */
public class DataArrays {

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("参数异常请重新输入");
        }
        quickSort(0, arr.length - 1, arr);
    }

    //仅提供升序演示
    private static void quickSort(int left, int right, int[] a) {
        if (left > right) {
            return;
        }
        int i = left, j = right;
        int temp;
        int minV = a[left];

        while (i != j) {
            while (i < j && a[j] >= minV) {
                j--;
            }
            while (i < j && a[i] <= minV) {
                i++;
            }
            if (i < j) {
                //交换i j
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }

        }
        //交换a[i] minV
        temp = a[i];
        a[i] = minV;
        a[left] = temp;

        quickSort(left, i - 1, a);
        quickSort(i + 1, right, a);
    }

    public static String toString(int[] arr) {
        if (arr == null) {
            return "null";
        }
        int len = arr.length - 1;
        if (len < 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[ ");
        for (int i : arr) {
            stringBuilder.append(i).append(" ");
        }
        return stringBuilder.append("]").toString();
    }

    public static boolean equals(int[] source, int[] target) {
        if (source == target) {
            return true;
        }

        if (source == null || target == null) {
            return false;
        }

        if (source.length != target.length) {
            return false;
        }
        for (int i = 0; i < source.length; i++) {
            if (source[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

//    public static List asList(int[] arr) {
//
//        return null;
//    }
}
