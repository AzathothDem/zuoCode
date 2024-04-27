package com.zuo.code;

public class Code022_SmallSum {
    public static long smallSum(int[] arr, int l, int r) {
        if (l == r) return 0;
        int m = l + (r - l) / 2;
        return smallSum(arr, l, m) + smallSum(arr, m + 1, r) + merge(arr, l, m, r);
    }

    private static long merge(int[] arr, int l, int m, int r) {
        int[] help = new int[arr.length];
        long ans = 0;
        for (int j = m + 1, i = l, sum = 0; j <= r; j++) {
            while (i <= m && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
        }
        int i = l;
        int a = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m){

        }
        while (b<=m){

        }
        return ans;
    }
}
