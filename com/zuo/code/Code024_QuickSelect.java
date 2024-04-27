package com.zuo.code;

// 算出第几大 / 第几小
public class Code024_QuickSelect {
    public static int randomizedSelect(int[] arr, int i) {
        int ans = 0;
        /*for (int l = 0, r = arr.length - 1; l <= r) {
            partition(arr, l, r, arr[l + (int) (Math.random() * (r - l + 1))]);

        }*/
        return ans;
    }

    private static void partition(int[] arr, int l, int r, int x) {
        int first = l;
        int last = r;
        int i = l;
        while (i <= last){
            if (arr[i] == x){
                i++;
            }else if (arr[i]<x){
               // swap(arr,first++,i++);
            }else {
               // swap(arr,i,last--);
            }
        }
    }
}
