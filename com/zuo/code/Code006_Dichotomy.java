package com.zuo.code;

public class Code006_Dichotomy {

    // o(log n)
    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0, r = arr.length - 1, m = 0;
        while (l <= r) {
            m = l + (m - l) / 2;
            if (arr[m] == num) {
                return true;
            } else if (arr[m] > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    // 找>=num 的最左位置
    public static int findLeft(int[] arr, int num) {
        int l = 0;
        int r = arr.length - 1;
        int ans = -1;
        int m = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] < num) {
                l = m + 1;
            } else if (arr[m] >= num) {
                ans = m;
                r = m - 1;
            }

        }
        return ans;
    }


    // 找<=num 的最右位置
    public static int findRight(int[] arr, int num) {
        int l = 0;
        int r = arr.length - 1;
        int ans = -1;
        int m = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] <= num) {
                ans = m;
                l = m + 1;
            } else if (arr[m] > num) {
                r = m - 1;
            }

        }
        return ans;
    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int l = 1, r = n - 2, m = -1, ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m - 1] > nums[m]) {
                r = m - 1;
            } else if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                ans = m;
                break;
            }
        }
        return ans;
    }


}
