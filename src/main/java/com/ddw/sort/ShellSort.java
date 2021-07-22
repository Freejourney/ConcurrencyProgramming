package com.ddw.sort;

import java.util.Arrays;

public class ShellSort {

    static void shellSort(int[] arr) {
        // 在插入排序的基础上调整了步长，更好的利用了插入排序对有序序列效率高的问题
        for (int gap = arr.length/2; gap > 0; gap /= 2) {
            for (int i = 0; i < arr.length; i += gap) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && temp < arr[j-gap]; j -= gap) {
                    arr[j] = arr[j-gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 1, 2, 6, 9, 8, 7, 4, 3, 10};
        shellSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
