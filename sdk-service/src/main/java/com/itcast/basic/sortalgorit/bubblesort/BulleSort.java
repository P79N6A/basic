package com.itcast.basic.sortalgorit.bubblesort;

import java.util.List;

/**
 * Created by qfl on 2018/3/4.
 */
public class BulleSort<T extends Comparable> {
    private List<T> elements;

    private String sort = "asc";

    public BulleSort(List<T> elements) {
        this.elements = elements;
    }

    public void setSort(String sort) {
        this.sort = sort;
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
        int len = elements.size();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                T maxValue = elements.get(j);
                T element = elements.get(j + 1);
                int result = maxValue.compareTo(element);
                if (result > 0) {
                    elements.set(j, element);
                    elements.set(j + 1, maxValue);
                }
            }
        }
    }

    private void descSort() {
        int len = elements.size();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                T minValue = elements.get(j);
                T element = elements.get(j + 1);
                int result = minValue.compareTo(element);
                if (result < 0) {
                    elements.set(j, element);
                    elements.set(j + 1, minValue);
                }
            }
        }
    }

    public void displayElements() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T element : elements) {
            stringBuilder.append(element).append(" ===> ");
        }
        System.out.println("elements is " + stringBuilder.substring(0, stringBuilder.lastIndexOf("===>")));
    }
}
