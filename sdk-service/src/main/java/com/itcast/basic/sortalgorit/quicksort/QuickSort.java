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
                ascSwap(0, elements.size() - 1);
                break;
            case "desc":
                descSwap(0, elements.size() - 1);
                break;
        }
    }

    private void ascSwap(int left, int right) {

        if (left > right) {
            return;
        }

        int i = left, j = right;
        T element = elements.get(left);
        while (i != j) {

            while (elements.get(j).compareTo(element) >= 0 && i < j) {
                j--;
            }

            while (elements.get(i).compareTo(element) <= 0 && i < j) {
                i++;
            }

            if (i < j) {
                //i,j交换
                T temp = elements.get(j);
                elements.set(j, elements.get(i));
                elements.set(i, temp);
            }
        }

        elements.set(left, elements.get(i));
        elements.set(i, element);

        ascSwap(left, i - 1);
        ascSwap(i + 1, right);
    }

    private void descSwap(int left, int right) {

        if (left > right) {
            return;
        }

        int i = left, j = right;
        T element = elements.get(left);
        while (i != j) {

            while (elements.get(j).compareTo(element) <= 0 && i < j) {
                j--;
            }

            while (elements.get(i).compareTo(element) >= 0 && i < j) {
                i++;
            }

            if (i < j) {
                //i,j交换
                T temp = elements.get(j);
                elements.set(j, elements.get(i));
                elements.set(i, temp);
            }
        }

        elements.set(left, elements.get(i));
        elements.set(i, element);

        descSwap(left, i - 1);
        descSwap(i + 1, right);
    }

    public void displayElements() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T element : elements) {
            stringBuilder.append(element).append(" ===> ");
        }
        System.out.println("elements is " + stringBuilder.substring(0, stringBuilder.lastIndexOf("===>")));
    }
}
