package com.zuo.code.code045;

import java.util.Arrays;

public class Code045_2_TwoNumbersMaximumXor {

    public static int findMaximumXOR1(int[] nums) {
        build(nums);
        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, maxXor(num));
        }
        clear();
        return ans;
    }
    public static void clear() {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);

        }
    }

    private static int maxXor(int num) {
        int ans = 0;
        int cur = 1;
        for (int i = left, status, want; i >= 0; i--) {
            status = (num >> i) & 1;
            want = status ^ 1;
            if (tree[cur][want] == 0){
                want ^= 1;
            }
            ans |= (status ^ want)<<i;
            cur = tree[cur][want];
        }
        return ans;
    }

    public static int MAXN = 300001;

    public static int[][] tree = new int[MAXN][2];


    // 数字只需要从哪一位开始考虑
    public static int left;

    public static int cnt;

    public static void build(int[] nums) {
        cnt = 1;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        left = 31 - Integer.numberOfLeadingZeros(max);
        for (int num : nums) {
            insert(num);
        }
    }

    private static void insert(int num) {
        int cur = 1;
        for (int i = left, path; i >= 0; i--) {
            path = (num >> i) & 1;
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cur;
            }
            cur = tree[cur][path];
        }
    }
}
