package com.ddw.sort;

import java.util.Arrays;

public class HeapSort {

    /**
     * 之所以有序是因为按数组的方式存储堆实际上是一种层序遍历，或者说我们按层序遍历的方式构造了堆
     * @param arr
     */
    void heapSort(int[] arr) {
        // 从最后一个非叶子节点开始将数组调整成堆
        for (int i = (arr.length-2)/2; i >= 0; i--) {
            shiftDown(arr, i, arr.length-1);
        }
        // 从最后一个元素开始与根交换重新构造堆
        for (int i = arr.length-1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            shiftDown(arr, 0, i-1);
        }
    }

    void shiftDown(int arr[], int start, int end) {
        int dad = start;
        int son = dad * 2 + 1;
        while (son <= end) {
            // 与最大的交换
            if (son + 1 <= end && arr[son] < arr[son+1]) {
                son++;
            }
            if (arr[dad] < arr[son]) {
                int temp = arr[dad];
                arr[dad] = arr[son];
                arr[son] = temp;
                dad = son;
                son = dad * 2 + 1;
            } else {
                // 从根节点到子节点都不用交换了
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 1, 2, 6, 9, 8, 7, 4, 3, 10};
        new HeapSort().heapSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
