package com.sj.dsa;

/**
 * ������нӿ�
 *
 * @author ShiJie
 * @since 2020-03-22
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
