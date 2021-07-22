package com.ddw.sort;

import java.util.Arrays;
import java.util.HashMap;

public class CountSort {

    /**
     * 计数排序：统计元素出现的次数最后输出
     * @param arr
     */
    static void countSort(int[] arr) {
        int max = 0;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        int[] counter = new int[max+1];
        for (int i = 0; i < counter.length; i++) {
            counter[i] = 0;
        }

        for (int num : arr) {
            counter[num] ++;
        }

        int index = 0;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i] != 0) {
                arr[index++] = i;
                counter[i]--;
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 1, 2, 6, 9, 8, 7, 4, 3, 3, 4, 4, 10};
        countSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
