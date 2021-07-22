package com.ddw.sort;

import java.util.Arrays;

public class bucketSort {

    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static void bucketSort(int[] arr) {
        int num = 4;
        int min = arr[0], max = arr[0];
        for (int element : arr) {
            if (min > element) {
                min = element;
            }
            if (max < element) {
                max = element;
            }
        }
        Node[] nodes = new Node[4];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(0, null);
        }
        double division = (max-min)*1.0/num;
        System.out.println("区间粒度："+division);
        for (int element : arr) {
            for (int j = 1; j <= num; j++) {
                if (element >= (min+division*(j-1)) && element <= (min + division*j)) {
                    System.out.println("元素："+element+"进入区间：["+(min+division*(j-1))+","+(min + division*j)+"]");
                    Node temp = nodes[j-1];
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = new Node(element, null);
                    break;
                }
            }
        }

        Arrays.stream(nodes).forEach(node -> {
            while (node.next != null) {
                node = node.next;
                System.out.print(node.value+" ");
            }
            System.out.println();
        });

        int index = 0;
        for (Node node : nodes) {
            Node temp = node.next;
            while (temp != null) {
                arr[index] = temp.value;
                index++;
                temp = temp.next;
            }
        }
        Arrays.stream(arr).forEach(x -> {
            System.out.print(x+" ");
        });
    }


    public static void main(String[] args) {
        int arr[] = {5, 1, 2, 6, 9, 8, 7, 4, 3, 10};
        bucketSort(arr);
    }
}
