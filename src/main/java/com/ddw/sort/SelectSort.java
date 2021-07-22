package com.ddw.sort;

import java.util.Arrays;

public class SelectSort {

    /**
     * 每次找到最小值/最大值所在位置与首/尾相应元素进行交换
     * @param arr
     */
    static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 1, 2, 6, 9, 8, 7, 4, 3, 10};
        selectSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
