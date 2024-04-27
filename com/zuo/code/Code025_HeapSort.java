package com.zuo.code;

public class Code025_HeapSort {



    public static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int i, int size) {
        int l = i * 2 + 1;
        while (l < size) {
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;
            best = arr[best] > arr[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(arr, i, best);
            i = best;
            l = i * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {

    }
}
