package com.zuo.code;


public class Code021_MergeSort {

    public  void merge(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + (r - l) / 2;
        merge(arr, l, m);
        merge(arr, m + 1, r);
        mergeSort(arr, l, r, m);
    }

    private static void mergeSort(int[] arr, int l, int r, int m) {
        int i = l;
        int b = m + 1;
        int a = l;
        while (a <= m && b <= r) {

        }
    }

    public static void mergeSort2(int[] arr) {
        for (int l, m, r, step = 1; step < arr.length; step <<= 1) {
            l = 0;
            while (l < arr.length) {
                m = l + step - 1;
                if (m + 1 >= arr.length ) {
                    break;
                }
                r = Math.min(l + (step << 1) - 1, arr.length - 1);
                merge(arr,l,m,r);
                l = r + 1;
            }
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {

    }


}
