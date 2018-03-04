package com.itcast.basic.sortalgorit.quicksort;

import java.util.List;

/**
 * Created by qfl on 2018/3/4.
 */
public class QuickSort<T extends Comparable> {
    private List<T> elements;
    private String sort = "asc";

    public void setSort(String sort) {
        this.sort = sort;
    }

    public QuickSort(List<T> elements) {
        this.elements = elements;
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
