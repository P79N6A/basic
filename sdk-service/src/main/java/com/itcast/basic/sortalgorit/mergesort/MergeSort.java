package com.itcast.basic.sortalgorit.mergesort;

import java.util.ArrayList;
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
                ascSort(0, elements.size() - 1);
                break;
            case "desc":
                descSort(0, elements.size() - 1);
                break;
        }
    }

    private void ascSort(int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            //拆分序列
            ascSort(low, mid);
            ascSort(mid + 1, high);
            //合并序列
            ascMerge(low, mid, high);
        }
    }

    //升序
    private void ascMerge(int low, int mid, int high) {
        int initialCapacity = high - low + 1;
        List<T> temp = new ArrayList<>(initialCapacity);
        int i = low, j = mid + 1;

        while (i <= mid && j <= high) {
            if (elements.get(i).compareTo(elements.get(j)) > 0) {
                temp.add(elements.get(j));
                j++;
            } else {
                temp.add(elements.get(i));
                i++;
            }
        }

        while (i <= mid) {
            temp.add(elements.get(i++));
        }

        while (j <= high) {
            temp.add(elements.get(j++));
        }

        for (int index = 0; index < temp.size(); index++) {
            elements.set(low + index, temp.get(index));
        }

    }

    private void descSort(int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            //拆分序列
            descSort(low, mid);
            descSort(mid + 1, high);
            //合并序列
            descMerge(low, mid, high);
        }
    }

    //升序
    private void descMerge(int low, int mid, int high) {
        int initialCapacity = high - low + 1;
        List<T> temp = new ArrayList<>(initialCapacity);
        int i = low, j = mid + 1;

        while (i <= mid && j <= high) {
            if (elements.get(i).compareTo(elements.get(j)) < 0) {
                temp.add(elements.get(j));
                j++;
            } else {
                temp.add(elements.get(i));
                i++;
            }
        }

        while (i <= mid) {
            temp.add(elements.get(i++));
        }

        while (j <= high) {
            temp.add(elements.get(j++));
        }

        for (int index = 0; index < temp.size(); index++) {
            elements.set(low + index, temp.get(index));
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
