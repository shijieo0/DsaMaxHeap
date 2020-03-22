package com.sj.dsa.leetcode;

import java.util.*;

/**
 * @author ShiJie
 * @since 2020-03-22
 */
public class _347_TopKFrequentElements {

    class Node implements Comparable<Node> {
        int num;
        int frequent;

        public Node(int num, int frequent) {
            this.num = num;
            this.frequent = frequent;
        }

        @Override
        public int compareTo(Node o) {
            if (this.num == o.num || this.frequent == o.frequent) {
                return 0;
            } else if (this.frequent > o.frequent) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elementFrequentMap = new HashMap<>();
        for (int num: nums) {
            if (elementFrequentMap.containsKey(Integer.valueOf(num))) {
                elementFrequentMap.put(num, elementFrequentMap.get(num) + 1);
            } else {
                elementFrequentMap.put(num, 1);
            }
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue();
        for (Map.Entry<Integer, Integer> entry: elementFrequentMap.entrySet()) {
            priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
        }
        List<Integer> topKList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topKList.add(priorityQueue.poll().num);
        }
        return topKList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        _347_TopKFrequentElements solution = new _347_TopKFrequentElements();
        System.out.println(solution.topKFrequent(nums, 2));
    }
}
