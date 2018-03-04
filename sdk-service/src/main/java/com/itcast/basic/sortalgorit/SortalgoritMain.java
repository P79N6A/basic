package com.itcast.basic.sortalgorit;

import com.itcast.basic.sortalgorit.bubblesort.BulleSort;
import com.itcast.basic.sortalgorit.insertsort.InsertionSort;
import com.itcast.basic.sortalgorit.selectionsort.SelectionSort;

import java.util.Arrays;

/**
 * Created by qfl on 2018/3/4.
 */
public class SortalgoritMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into SortalgoritMain");
            System.out.println("**********************选择排序***********************************");
            SelectionSort selectionSort = new SelectionSort(Arrays.asList(new Integer[]{5, 8, 7, 2, 10, 6, 3}));
            selectionSort.displayElements();
            selectionSort.setSort("desc");
            selectionSort.sortElements();
            selectionSort.displayElements();
            System.out.println("**********************选择排序***********************************\n");


            System.out.println("**********************冒泡排序***********************************");
            BulleSort bulleSort = new BulleSort(Arrays.asList(new Integer[]{5, 8, 7, 2, 10, 6, 3}));
            bulleSort.displayElements();
            bulleSort.setSort("desc");
            bulleSort.sortElements();
            bulleSort.displayElements();
            System.out.println("**********************冒泡排序***********************************\n");

            System.out.println("**********************插入排序***********************************");
            InsertionSort insertionSort = new InsertionSort(Arrays.asList(new Integer[]{5, 8, 7, 2, 10, 6, 3}));
            insertionSort.displayElements();
            insertionSort.setSort("desc");
            insertionSort.sortElements();
            insertionSort.displayElements();
            System.out.println("**********************插入排序***********************************\n");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
