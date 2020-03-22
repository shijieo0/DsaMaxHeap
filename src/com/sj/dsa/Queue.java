package com.sj.dsa;

/**
 * 定义队列接口
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
