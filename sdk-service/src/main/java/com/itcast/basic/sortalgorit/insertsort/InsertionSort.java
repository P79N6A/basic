package com.itcast.basic.sortalgorit.insertsort;

import java.util.List;

/**
 * Created by qfl on 2018/3/4.
 */
public class InsertionSort<T extends Comparable> {
    private List<T> elements;
    private String sort = "asc";

    public InsertionSort(List elements) {
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
        for (int i = 1, len = elements.size(); i < len; i++) {
            int index = i - 1;
            T insElement = elements.get(i);
            while (index >= 0 && elements.get(index).compareTo(insElement) > 0) {
                elements.set(index + 1, elements.get(index));
                index--;
            }
            elements.set(index + 1, insElement);
        }
    }

    private void descSort() {
        for (int i = 1, len = elements.size(); i < len; i++) {
            int index = i - 1;
            T insElement = elements.get(i);
            while (index >= 0 && elements.get(index).compareTo(insElement) < 0) {
                elements.set(index + 1, elements.get(index));
                index--;
            }
            elements.set(index + 1, insElement);
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
