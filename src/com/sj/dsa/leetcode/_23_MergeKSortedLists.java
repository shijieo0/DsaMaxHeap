package com.sj.dsa.leetcode;

import java.util.PriorityQueue;

/**
 * @author ShiJie
 * @since 2020-03-23
 */
public class _23_MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(ListNode listNode: lists) {
            while(listNode != null) {
                priorityQueue.add(listNode.val);
                listNode = listNode.next;
            }
        }

        ListNode head = null;
        ListNode tail = null;
        while (!priorityQueue.isEmpty()) {
            ListNode currentNode = new ListNode(priorityQueue.poll());
            if (head == null) {
                head = currentNode;
                tail = currentNode;
            } else {
                tail.next = currentNode;
                tail = tail.next;
            }
        }
        return head;
    }
}
