package com.zuo.code;
// 荷兰国旗
public class Code023_QuickSort {

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + (int) (Math.random() * (r - l + 1))];
        int mid = partion(arr, l, r, x);
    }

    private static int partion(int[] arr, int l, int r, int x) {
        int a = l, xi = 0;
        for (int i = l; i <= r; i++) {
            if (arr[i] <= x) {
                //swap(a,i)
                if (arr[a] == x) {
                    xi = a;
                }
                a++;
            }
        }
        //swap(xi, a - 1);
        return a - 1;
    }
}
