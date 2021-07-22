package com.ddw.sort;

public class quickSort {

    static void quickSort(int[] arr, int start, int end){
        if (start > end) {
            return;
        }
        int base = arr[start];

        int low = start;
        int high = end;

        while (low < high) {
            while (low < high && arr[high] > base) {
                high--;
            }
            while (low < high && arr[low] < base) {
                low++;
            }
            if (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }

        arr[start] = arr[low];
        arr[low] = base;

        quickSort(arr, start, low-1);
        quickSort(arr, low+1, high);
    }




    public static void main(String[] args) {

    }
}
