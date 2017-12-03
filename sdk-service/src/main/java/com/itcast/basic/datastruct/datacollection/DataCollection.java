package com.itcast.basic.datastruct.datacollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/3.
 * this is a collection struct class
 */
public class DataCollection<T> {

    public List<T> data = new ArrayList<>();

    public DataCollection() {
    }

    public DataCollection(T[] elements) {
        if (elements != null) {
            for (T e : elements) {
                data.add(e);
            }
        }
    }

    public synchronized boolean addElemet(T element) {
        if (element == null) {
            throw new IllegalArgumentException("element is null");
        }
        boolean isSuccess = true;
        try {
            data.add(element);
        } catch (Exception e) {
            isSuccess = false;
        }
        return isSuccess;
    }

    public synchronized boolean addElemets(T[] elements) {

        boolean isSuccess = false;

        return isSuccess;
    }

    public synchronized boolean add(int index, T element) {

        boolean isSuccess = false;

        return isSuccess;
    }


    public synchronized boolean remove(int index) {
        boolean isSuccess = false;

        return isSuccess;
    }


    public synchronized boolean removeElement(T element) {
        boolean isSuccess = false;

        return isSuccess;
    }


    public synchronized boolean removeElements(T[] elements) {
        boolean isSuccess = false;

        return isSuccess;
    }

    public synchronized void display() {

    }


    public synchronized String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.toString();
    }
}
