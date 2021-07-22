package com.ddw.sort;

import java.util.Arrays;

public class BubbleSort {

    void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            // 冒泡排序每次内层遍历找出一个最大/最小的值放在当前范围最后面
            for (int j = 0; j < len-1-i; j++) {
                if (arr[j] < arr[j+1]) {
                    arr[j] ^= arr[j+1];
                    arr[j+1] ^= arr[j];
                    arr[j] ^= arr[j+1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {9, 2, 1, 5, 6, 8};
        Arrays.stream(arr).forEach(x -> System.out.print(x+" "));
        System.out.println();
        new BubbleSort().bubbleSort(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x+" "));
        System.out.println();
    }
}
