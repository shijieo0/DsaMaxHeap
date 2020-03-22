package com.sj.dsa;

/**
 * 数据结构：Heap(MaxHeap or MinHeap)
 * 1、什么是优先队列？
 * 2、堆的基础概念及堆的实现方式对比
 * 3、堆的基础表示
 * 4、向堆中添加元素和sift up过程
 * 5、从堆中取出元素和sift down过程
 * 6、Heapify 和 Replace
 * 7、基于堆的优先队列
 * 8、Java中的PriorityQueue源码分析
 * 9、Leetcode上优先队列相关问题
 * 10、和堆相关的更多话题和广义队列
 * @author ShiJie
 * @since 2020-03-22
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    // 返回堆中元素的个数
    public int getSize() {
        return data.getSize();
    }
    // 返回一个布尔值，表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }
    // 索引从0开始
    // 返回完全二叉树的数组表示中,一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn`t have parent.");
        }
        return (index - 1) / 2;
    }
    // 返回完全二叉树的数组表示中,一个索引所表示的元素的父亲节点的索引返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }
    // 返回完全二叉树的数组表示中,一个索引所表示的元素的父亲节点的索引返回完全二叉树的数组表示中,一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }
    // 向堆中添加元素, 有一个堆中元素上浮的过程，sift up
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(parent(k), k);
            k = parent(k);
        }
    }

    // 找堆中的最大元素
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    // 取出堆中的最大元素
    // 把堆的最后一个元素填到堆顶位置，然后进行一波元素下沉的过程，sift down
    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {
        while(leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            // data[j] 代表 leftChild 和 rightChild 中的最大值
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            // 和左右孩子中的较大者比较，看是否需要交换
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    // replace: 取出最大元素后，并且替换成一个新元素e
    // 实现：可以先extractMax, 再add, 两次O(logn)的操作
    // 实现：可以直接将堆顶元素替换以后sift down，一次O(logn)的操作
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    // heapify: 将任意数组整理成堆的形状
    // 最后一个非叶子节点的索引：最后一个叶子节点的父节点索引即是
    // 从最后一个非叶子节点开始，一直向前遍历直到根节点，对每个遍
    // 历到的节点进行sift down操作，就可以把任意数组整理成堆
    // heapify的算法复杂度分析：
    // 1）若将n个元素逐个插入到一个空堆中，算法复杂度是O(nlogn)
    // 2）heapify的过程，算法复杂度为O(n)

}
