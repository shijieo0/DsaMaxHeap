package com.sj.dsa;

import java.util.Random;

public class Main {

    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (int num: testData) {
                maxHeap.add(num);
            }
        }

        verifyMaxHeap(maxHeap, testData.length);

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000_000_000.0;
    }

    public static void main(String[] args) {
        int n = 1000_000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
//        }
//        verifyMaxHeap(maxHeap, n);

        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double test1 = testHeap(testData, false);
        double test2 = testHeap(testData, true);
        System.out.println("without heapify: " + test1 + "s");
        System.out.println("heapify: " + test2 + "s");
    }

    private static void verifyMaxHeap(MaxHeap<Integer> maxHeap, int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");
    }
}
