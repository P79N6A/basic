package com.itcast.basic.datastruct.datacollection;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/3.
 * this is a collection struct class
 */
public class DataCollection<T> implements Serializable {

    private Object[] data;

    private transient int capatity = 20;

    private transient double percent = 0.75;

    private int size = 0;

    private synchronized boolean changeSize() {
        boolean isSuccess = true;
        try {
            capatity = (int) (capatity * (1 + percent)) + 1;
        } catch (Exception e) {
            isSuccess = false;
            System.out.println("changeSize error message is" + e);
        }
        return isSuccess;
    }

    public DataCollection() {
        data = new Object[capatity];
    }

    public DataCollection(T[] elements) {
        if (elements == null) {
            throw new IllegalArgumentException("elements is not vaild");
        }
        data = elements;
        size = elements.length;
    }

    public synchronized T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is not valid");
        }
        Object result = data[index];
        return (T) result;
    }

    public synchronized int indexOf(T element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public synchronized boolean addElemet(T element) {
        if (element == null) {
            throw new IllegalArgumentException("element is not null");
        }
        boolean isSuccess = true;
        int length = data.length;
        try {
            if (length <= size) {
                boolean isEx = changeSize();
                if (isEx) {
                    Object[] oldData = data;
                    data = new Object[capatity];
                    for (int i = 0; i < oldData.length; i++) {
                        data[i] = oldData[i];
                    }
                    data[size++] = element;
                } else {
                    return false;
                }
            } else {
                data[size++] = element;
            }
        } catch (Exception e) {
            isSuccess = false;
            System.out.println("error message is" + e);
        }
        return isSuccess;
    }

    public synchronized boolean addElemets(T[] elements) {
        if (elements == null) {
            throw new IllegalArgumentException("elements is not null");
        }
        if (elements.length == 0) {
            throw new IllegalArgumentException("elements length is not zero");
        }
        boolean isSuccess = true;
        int dataLen = data.length;
        int eleLen = elements.length;
        try {
            if (dataLen >= eleLen + size) {
                for (int i = 0; i < eleLen; i++) {
                    data[size++] = elements[i];
                }
            } else {
                while (capatity < dataLen + eleLen) {
                    boolean isEx = changeSize();
                    if (!isEx) {
                        return false;
                    }
                }
                Object[] oldData = data;
                data = new Object[capatity];
                for (int i = 0; i < dataLen; i++) {
                    data[i] = oldData[i];
                }
                for (int i = 0; i < eleLen; i++) {
                    data[size++] = elements[i];
                }
            }
        } catch (Exception e) {
            isSuccess = false;
            System.out.println("error message is" + e);
        }
        return isSuccess;
    }

    public synchronized boolean add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is not valid");
        }
        if (element == null) {
            throw new IllegalArgumentException("element is not valid");
        }
        int length = data.length;
        boolean isSuccess = true;
        try {
            if (length <= size) {
                boolean isEx = changeSize();
                if (isEx) {
                    Object[] oldData = data;
                    data = new Object[capatity];
                    for (int i = 0; i < oldData.length; i++) {
                        data[i] = oldData[i];
                    }
                } else {
                    return false;
                }
            }
            int idx = size++;
            while (idx > index) {
                data[idx--] = data[idx];
            }
            data[index] = element;
        } catch (Exception e) {
            isSuccess = false;
            System.out.println("error message is" + e);
        }
        return isSuccess;
    }


    public synchronized boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is not valid");
        }
        boolean isSuccess = true;
        try {
            Object[] oldData = data;
            data = new Object[capatity];
            for (int i = 0; i < --size; i++) {
                if (i < index) {
                    data[i] = oldData[i];
                } else {
                    data[i] = oldData[i + 1];
                }
            }

        } catch (Exception e) {
            isSuccess = false;
            System.out.println("error message is" + e);
        }
        return isSuccess;
    }


    public synchronized boolean removeElement(T element) {
        if (element == null) {
            throw new IllegalArgumentException("element is not null");
        }
        boolean isSuccess = true;
        try {
            Object[] oldData = data;
            data = new Object[capatity];
            int dataLen = oldData.length;
            for (int i = 0; i < dataLen; i++) {
                if (element.equals(oldData[i])) {
                    oldData[i] = null;
                    size--;
                }
            }
            for (int i = 0, j = 0; i < dataLen; i++) {
                if (oldData[i] != null) {
                    data[j++] = oldData[i];
                }
            }
        } catch (Exception e) {
            isSuccess = false;
            System.out.println("error message is" + e);
        }
        return isSuccess;
    }


    public synchronized boolean removeElements(T[] elements) {
        if (elements == null) {
            throw new IllegalArgumentException("elements is not null");
        }
        if (elements.length == 0) {
            throw new IllegalArgumentException("elements not is empty");
        }
        boolean isSuccess = true;
        try {
            Object[] oldData = data;
            data = new Object[capatity];
            int eleLen = elements.length;
            int dataLen = oldData.length;
            for (int i = 0; i < eleLen; i++) {
                for (int j = 0; j < dataLen; j++) {
                    if (elements[i].equals(oldData[j])) {
                        oldData[j] = null;
                        size--;
                    }
                }
            }
            for (int i = 0, j = 0; i < dataLen; i++) {
                if (oldData[i] != null) {
                    data[j++] = oldData[i];
                }
            }
        } catch (Exception e) {
            isSuccess = false;
            System.out.println("error message is" + e);
        }
        return isSuccess;
    }

    public synchronized void display() {
        StringBuilder stringBuilder = new StringBuilder("elements of data is { ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(" ").append(i).append(" ===> ").append(data[i]);
        }
        stringBuilder.append(" }");
        System.out.println(stringBuilder.toString());
    }


    public synchronized String toString() {
        StringBuilder stringBuilder = new StringBuilder("elements is { ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(" ").append(data[i]).append(" ");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public int size() {
        return size;
    }
}
