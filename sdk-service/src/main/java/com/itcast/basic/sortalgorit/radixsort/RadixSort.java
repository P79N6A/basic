package com.itcast.basic.sortalgorit.radixsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by treey.qian on 2018/3/5.
 */
public class RadixSort<T extends Comparable> {
    private List<T> elements;
    private String sort = "asc";
    private int radix = 0;

    public void setSort(String sort) {
        this.sort = sort;
    }

    public RadixSort(List<T> elements) {
        this.elements = elements;
        initRadix();
    }

    private void initRadix() {
        for (int i = 0, size = elements.size(); i < size; i++) {
            int length = elements.get(i).toString().length();
            if (length > radix) {
                radix = length;
            }
        }
    }

    public void sortElements() {
        switch (sort) {
            case "asc":
                ascSort();
                break;
            case "desc":
                descSort();
                break;
        }
    }

    private void ascSort() {
        List<T> temp = new ArrayList<>();
        int looper = 0;
        while (looper < radix) {

            looper++;
        }
    }

    private void descSort() {

    }

    public void displayElements() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T element : elements) {
            stringBuilder.append(element).append(" ===> ");
        }
        System.out.println("elements is " + stringBuilder.substring(0, stringBuilder.lastIndexOf("===>")));
    }
}
