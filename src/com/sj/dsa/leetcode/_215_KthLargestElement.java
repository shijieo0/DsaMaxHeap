package com.sj.dsa.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ShiJie
 * @since 2020-03-23
 */
public class _215_KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length, Comparator.comparingInt(Integer::intValue).reversed());
        for (int num: nums) {
            priorityQueue.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }
        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        _215_KthLargestElement solution = new _215_KthLargestElement();
        System.out.println(solution.findKthLargest(nums, 4));
    }
}
