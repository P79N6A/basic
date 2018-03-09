package com.itcast.basic.sortalgorit.heapsort;

import java.util.List;

/**
 * Created by treey.qian on 2018/3/6.
 */
public class HeapSort<T extends Comparable> {
    private List<T> elements;
    private String sort = "asc";

    public void setSort(String sort) {
        this.sort = sort;
    }

    public HeapSort(List<T> elements) {
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
        while (size > 0) {
            int lastIndex = (size - 2) / 2;
            while (lastIndex >= 0) {
//                System.out.println("**************lastIndex=***************" + elements.get(lastIndex));
                //左孩子
                int leftIndex = 2 * lastIndex + 1;
                if (leftIndex <= size - 1 && elements.get(lastIndex).compareTo(elements.get(leftIndex)) < 0) {
                    swap(lastIndex, leftIndex);
                }
                //右孩子
                int rightIndex = 2 * lastIndex + 2;
                if (rightIndex <= size - 1 && elements.get(lastIndex).compareTo(elements.get(rightIndex)) < 0) {
                    swap(lastIndex, rightIndex);
                }
                lastIndex--;
            }
            size--;
            swap(0, size);
//            System.out.println("******************************size**********************************" + size);
        }
    }

    private void swap(int sourceIndex, int targetIndex) {
//        System.out.println(targetIndex + "<====>" + sourceIndex + " swap node:" + elements.get(sourceIndex) + "<=====>" + elements.get(targetIndex));
        T lastNode = elements.get(sourceIndex);
        elements.set(sourceIndex, elements.get(targetIndex));
        elements.set(targetIndex, lastNode);
    }


    private void descSort() {
        int size = elements.size();
        while (size > 0) {
            int lastIndex = (size - 2) / 2;
            while (lastIndex >= 0) {
//                System.out.println("**************lastIndex=***************" + elements.get(lastIndex));
                //左孩子
                int leftIndex = 2 * lastIndex + 1;
                if (leftIndex <= size - 1 && elements.get(lastIndex).compareTo(elements.get(leftIndex)) > 0) {
                    swap(lastIndex, leftIndex);
                }
                //右孩子
                int rightIndex = 2 * lastIndex + 2;
                if (rightIndex <= size - 1 && elements.get(lastIndex).compareTo(elements.get(rightIndex)) > 0) {
                    swap(lastIndex, rightIndex);
                }
                lastIndex--;
            }
            size--;
            swap(0, size);
//            System.out.println("******************************size**********************************" + size);
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
