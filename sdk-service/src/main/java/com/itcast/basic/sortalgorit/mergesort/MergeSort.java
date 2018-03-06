package com.itcast.basic.sortalgorit.mergesort;

import java.util.List;

/**
 * Created by treey.qian on 2018/3/6.
 */
public class MergeSort<T extends Comparable> {
    private List<T> elements;
    private String sort = "asc";

    public void setSort(String sort) {
        this.sort = sort;
    }

    public MergeSort(List<T> elements) {
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
