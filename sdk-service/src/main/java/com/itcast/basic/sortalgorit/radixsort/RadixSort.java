package com.itcast.basic.sortalgorit.radixsort;

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
//        System.out.println("radix=" + radix);
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
        int looper = 0;
        while (looper < radix) {

            for (int i = 1, size = elements.size(); i < size; i++) {
                int index = i - 1;
                char subKey = '0', insKey = '0';

                //构造待插入元素比较器值
                T inElement = elements.get(i);
                String inStr = inElement.toString();
                int inLen = inStr.length();
                if (inLen - 1 >= looper) {
                    insKey = inStr.charAt(inLen - 1 - looper);
                }

                //构造元素比较器值
                T subElement = elements.get(index);
                String subStr = subElement.toString();
                int subLen = subStr.length();
                if (subLen - 1 >= looper) {
                    subKey = subStr.charAt(subLen - 1 - looper);
                }

//                System.out.println("i=" + i + " subKey=" + subKey + " insKey=" + insKey + " subStr=" + subStr + " inStr=" + inStr);
                while (index >= 0 && subKey > insKey) {
                    elements.set(index + 1, elements.get(index));
                    index--;
                    if (index >= 0) {
                        subKey = '0';
                        subElement = elements.get(index);
                        subStr = subElement.toString();
                        subLen = subStr.length();
                        if (subLen - 1 >= looper) {
                            subKey = subStr.charAt(subLen - 1 - looper);
                        }
                    }
                }
                elements.set(index + 1, inElement);
            }
            looper++;
        }
    }

    private void descSort() {
        int looper = 0;
        while (looper < radix) {

            for (int i = 1, size = elements.size(); i < size; i++) {
                int index = i - 1;
                char subKey = '0', insKey = '0';

                //构造待插入元素比较器值
                T inElement = elements.get(i);
                String inStr = inElement.toString();
                int inLen = inStr.length();
                if (inLen - 1 >= looper) {
                    insKey = inStr.charAt(inLen - 1 - looper);
                }

                //构造元素比较器值
                T subElement = elements.get(index);
                String subStr = subElement.toString();
                int subLen = subStr.length();
                if (subLen - 1 >= looper) {
                    subKey = subStr.charAt(subLen - 1 - looper);
                }

//                System.out.println("i=" + i + " subKey=" + subKey + " insKey=" + insKey + " subStr=" + subStr + " inStr=" + inStr);
                while (index >= 0 && subKey < insKey) {
                    elements.set(index + 1, elements.get(index));
                    index--;
                    if (index >= 0) {
                        subKey = '0';
                        subElement = elements.get(index);
                        subStr = subElement.toString();
                        subLen = subStr.length();
                        if (subLen - 1 >= looper) {
                            subKey = subStr.charAt(subLen - 1 - looper);
                        }
                    }
                }
                elements.set(index + 1, inElement);
            }
            looper++;
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
