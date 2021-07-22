package com.ddw.sort;

import java.util.Arrays;

public class InsertSort {

    void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                int temp = arr[i];
                // 从后往前比较有序序列大小并覆盖当前元素
                int j;
                for (j = i-1; j >= 0 && arr[j] > temp; j--) {
                    arr[j+1] = arr[j];
                }
                arr[j+1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {9, 2, 1, 5, 6, 8};
        Arrays.stream(arr).forEach(x -> System.out.print(x+" "));
        System.out.println();
        new InsertSort().insertSort(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x+" "));
        System.out.println();
    }
}
