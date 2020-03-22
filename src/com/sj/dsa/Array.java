package com.sj.dsa;

import com.sun.xml.internal.bind.AnyTypeAdapter;
import org.omg.CORBA.Any;

/**
 * Desc:
 *
 * @author ShiJie
 * @since 2020-03-20
 */
public class Array<E> {
    E[] data;
    int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index error, index must 0 <= index <size");
        }
        data[index] = e;
    }
    
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error, index must 0 <= index <= size");
        }
        
        if (size == data.length) {
            resize(data.length * 2);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }
    
    public void addLast(E e) {
        add(size, e);
    }
    
    public boolean contain(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index out of bound");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        if (size < data.length / 4 && data.length / 2 > 0) {
            resize(data.length / 2);
        }
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index == -1) {
            return;
        }
        remove(index);
    }

    public E removeFirst() {
        E e = data[0];
        remove(0);
        return e;
    }

    public E removeLast() {
        E e = data[size - 1];
        remove(size - 1);
        return e;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index out of bound");
        }
        return data[index];
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");

        E temp = data[j];
        data[j] = data[i];
        data[i] = temp;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = null;
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("size=").append(size)
                .append("capacity=").append(getCapacity())
                .append(". Array[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(',');
            }
        }
        res.append(']');
        return res.toString();
    }
}
