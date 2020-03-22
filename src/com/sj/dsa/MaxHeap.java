package com.sj.dsa;

/**
 * ���ݽṹ��Heap(MaxHeap or MinHeap)
 * 1��ʲô�����ȶ��У�
 * 2���ѵĻ�������ѵ�ʵ�ַ�ʽ�Ա�
 * 3���ѵĻ�����ʾ
 * 4����������Ԫ�غ�sift up����
 * 5���Ӷ���ȡ��Ԫ�غ�sift down����
 * 6��Heapify �� Replace
 * 7�����ڶѵ����ȶ���
 * 8��Java�е�PriorityQueueԴ�����
 * 9��Leetcode�����ȶ����������
 * 10���Ͷ���صĸ��໰��͹������
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

    // ���ض���Ԫ�صĸ���
    public int getSize() {
        return data.getSize();
    }
    // ����һ������ֵ����ʾ�����Ƿ�Ϊ��
    public boolean isEmpty() {
        return data.isEmpty();
    }
    // ������0��ʼ
    // ������ȫ�������������ʾ��,һ����������ʾ��Ԫ�صĸ��׽ڵ������
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn`t have parent.");
        }
        return (index - 1) / 2;
    }
    // ������ȫ�������������ʾ��,һ����������ʾ��Ԫ�صĸ��׽ڵ������������ȫ�������������ʾ��,һ����������ʾ��Ԫ�ص����ӽڵ������
    private int leftChild(int index) {
        return index * 2 + 1;
    }
    // ������ȫ�������������ʾ��,һ����������ʾ��Ԫ�صĸ��׽ڵ������������ȫ�������������ʾ��,һ����������ʾ��Ԫ�ص��Һ��ӽڵ������
    private int rightChild(int index) {
        return index * 2 + 2;
    }
    // ��������Ԫ��, ��һ������Ԫ���ϸ��Ĺ��̣�sift up
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

    // �Ҷ��е����Ԫ��
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    // ȡ�����е����Ԫ��
    // �Ѷѵ����һ��Ԫ����Ѷ�λ�ã�Ȼ�����һ��Ԫ���³��Ĺ��̣�sift down
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
            // data[j] ���� leftChild �� rightChild �е����ֵ
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            // �����Һ����еĽϴ��߱Ƚϣ����Ƿ���Ҫ����
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    // replace: ȡ�����Ԫ�غ󣬲����滻��һ����Ԫ��e
    // ʵ�֣�������extractMax, ��add, ����O(logn)�Ĳ���
    // ʵ�֣�����ֱ�ӽ��Ѷ�Ԫ���滻�Ժ�sift down��һ��O(logn)�Ĳ���
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    // heapify: ��������������ɶѵ���״
    // ���һ����Ҷ�ӽڵ�����������һ��Ҷ�ӽڵ�ĸ��ڵ���������
    // �����һ����Ҷ�ӽڵ㿪ʼ��һֱ��ǰ����ֱ�����ڵ㣬��ÿ����
    // �����Ľڵ����sift down�������Ϳ��԰�������������ɶ�
    // heapify���㷨���Ӷȷ�����
    // 1������n��Ԫ��������뵽һ���ն��У��㷨���Ӷ���O(nlogn)
    // 2��heapify�Ĺ��̣��㷨���Ӷ�ΪO(n)

}
