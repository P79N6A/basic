package com.itcast.basic.collectiontype.impletmentclass;

/**
 * Created by qfl on 16/5/1.
 */
public class BasicLinkedList<E> {

    private Node<E> header;
    private Node<E> trail;
    private int modCount;
    private int size;

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    private void linkLast(E e) {
        Node<E> l = trail;
        Node<E> newNode = new Node<E>(e, null, l);
        trail = newNode;
        if (l == null)
            header = newNode;
        else
            l.next = newNode;
        modCount++;
        size++;
    }

    private void linkFirst(E e) {
        Node<E> f = header;
        Node<E> newNode = new Node<E>(e, f, null);
        header = newNode;
        if (f == null)
            trail = newNode;
        else
            f.prev = header;
        modCount++;
        size++;
    }

    public E pop() {
        return removeFirst();
    }

    private E removeFirst() {
        Node<E> h = header;
        if (h == null)
            throw new NullPointerException("空指针异常");
        return unLinkedFirst(h);
    }

    private E unLinkedFirst(Node<E> e) {
        E v = e.value;
        Node<E> nextE = e.next;
        e.prev = null;
        e.next = null;
        header = nextE;
        if (nextE == null)
            trail = null;
        else
            nextE.prev = null;
        return v;
    }

    public E poll() {
        return removeLast();
    }

    private E removeLast() {
        Node<E> t = trail;
        if (t == null)
            throw new NullPointerException("空指针");
        return unLinkedLast(t);
    }

    private E unLinkedLast(Node<E> e) {
        E v = e.value;
        Node<E> prevE = e.prev;
        trail = prevE;
        e.prev = null;
        e.next = null;
        if (prevE == null)
            header = null;
        else
            prevE.next = null;
        return v;
    }

    public boolean push(E e) {
        linkFirst(e);
        return true;
    }

    static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(E v, Node next, Node prev) {
            this.next = next;
            this.prev = prev;
            this.value = v;
        }
    }
}
