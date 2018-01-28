package com.itcast.basic.sortedmethod;

import java.util.Arrays;

/**
 * Created by qfl on 16/4/29.
 */
public class SortedArrayClass {
    public static void main(String[] args) {
        int[] arrays = {12, 11, 10, 3, 5, 4, 7, 6, 8, 9, 13, 2, 1};
        SortedUtils.SysAllElements(SortedUtils.sortedByInsert(arrays));
    }
}

//升序排序管理器
class SortedUtils {

    //选择排序
    public static int[] sortedByChange(int[] arrays) {

        int[] newArrays = Arrays.copyOfRange(arrays, 0, arrays.length);
        int length = newArrays.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (newArrays[i] > newArrays[j]) {
                    int temp = newArrays[i];
                    newArrays[i] = newArrays[j];
                    newArrays[j] = temp;
                }
            }
        }
        return newArrays;
    }

    //冒泡排序
    public static int[] sortedByBubble(int[] arrays) {

        int[] newArrays = Arrays.copyOfRange(arrays, 0, arrays.length);
        int length = newArrays.length;
        for (int j = 0; j < length; j++)
            for (int i = 0; i < length - j - 1; i++) {
                if (newArrays[i] > newArrays[i + 1]) {
                    int temp = newArrays[i];
                    newArrays[i] = newArrays[i + 1];
                    newArrays[i + 1] = temp;
                }
            }
        return newArrays;
    }

    //插入排序
    public static int[] sortedByInsert(int[] arrays) {
        int[] sortedArrays = Arrays.copyOfRange(arrays, 0, arrays.length);
        return sortedArrays;
    }

    public static void SysAllElements(int[] arrays) {
        for (int i = 0; i < arrays.length; i++)
            System.out.println("array[" + i + "]= " + arrays[i]);
    }

}



















