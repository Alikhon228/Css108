package com.example.demo18.Exercise24_2;

public interface MyList24_2<E> extends java.lang.Iterable<E> {
    public void add(E e);
    public boolean contains(E e);
    public E get(int index);
    public boolean isEmpty();
    public E remove(int index);
    public Object set(int index, E e);
    public int size();
    public int indexOf(E e);
    public void clear();
    public boolean remove(E e);
    public void add(int index, E e);
    public int lastIndexOf(E e);
}
