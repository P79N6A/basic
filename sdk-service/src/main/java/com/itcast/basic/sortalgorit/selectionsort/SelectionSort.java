package com.itcast.basic.sortalgorit.selectionsort;

import java.util.List;

/**
 * Created by qfl on 2018/3/4.
 */
public class SelectionSort<T extends Comparable> {

    private List<T> elements;

    private String sort = "asc";

    public SelectionSort(List<T> elements) {
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
        for (int i = 0; i < len - 1; i++) {
            T minValue = elements.get(i);
            for (int j = i + 1; j < len; j++) {
                T element = elements.get(j);
                int result = minValue.compareTo(element);
                if (result > 0) {
                    elements.set(i, element);
                    elements.set(j, minValue);
                    minValue = element;
                }
            }
        }
    }

    private void descSort() {
        int len = elements.size();
        for (int i = 0; i < len - 1; i++) {
            T maxValue = elements.get(i);
            for (int j = i + 1; j < len; j++) {
                T element = elements.get(j);
                int result = maxValue.compareTo(element);
                if (result < 0) {
                    elements.set(i, element);
                    elements.set(j, maxValue);
                    maxValue = element;
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
