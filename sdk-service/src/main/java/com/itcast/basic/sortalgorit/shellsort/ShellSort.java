package com.itcast.basic.sortalgorit.shellsort;

import java.util.List;

/**
 * Created by treey.qian on 2018/3/6.
 */
public class ShellSort<T extends Comparable> {
    private List<T> elements;
    private String sort = "asc";

    public void setSort(String sort) {
        this.sort = sort;
    }

    public ShellSort(List<T> elements) {
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
        int size = elements.size();
        int d = size / 2;
        while (d >= 1) {
            int group = 0;
            while (group < d) {
                for (int i = group + d; i < size; i += d) {
                    int index = i - d;
                    T insElement = elements.get(i);
                    while (index >= 0 && elements.get(index).compareTo(insElement) > 0) {
                        elements.set(index + d, elements.get(index));
                        index -= d;
                    }
                    elements.set(index + d, insElement);
                }
                group++;
            }
            d = d / 2;
        }
    }

    private void descSort() {
        int size = elements.size();
        int d = size / 2;
        while (d >= 1) {
            int group = 0;
            while (group < d) {
                for (int i = group + d; i < size; i += d) {
                    int index = i - d;
                    T insElement = elements.get(i);
                    while (index >= 0 && elements.get(index).compareTo(insElement) < 0) {
                        elements.set(index + d, elements.get(index));
                        index -= d;
                    }
                    elements.set(index + d, insElement);
                }
                group++;
            }
            d = d / 2;
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
