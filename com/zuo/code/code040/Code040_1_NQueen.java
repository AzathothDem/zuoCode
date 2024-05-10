package com.zuo.code.code040;

public class Code040_1_NQueen {

    public int NQueen01(int n) {
        if (n <= 0) return 0;
        int[] board = new int[n];
        return f0(board, 0, n);
    }

    private int f0(int[] path, int i, int n) {
        if (i == n) return 1;
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (check(path, i, j)) {
                path[i] = j;
                res += f0(path, i + 1, n);
            }
        }
        return res;
    }

    private boolean check(int[] path, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == path[k] || Math.abs(i - k) == Math.abs(j - path[k])){
                return false;
            }
        }
        return true;
    }

    public static int f2(int limit, int col, int left, int right) {
        if (col == limit) {
            // 所有皇后放完了！
            return 1;
        }
        // 总限制
        int ban = col | left | right;
        // ~ban : 1可放皇后，0不能放
        int candidate = limit & (~ban);
        // 放置皇后的尝试！
        int place = 0;
        // 一共有多少有效的方法
        int ans = 0;
        while (candidate != 0) {
            // 提取出最右侧的1
            // 0 0 1 1 1 0
            // 5 4 3 2 1 0
            // place :
            // 0 0 0 0 1 0
            // candidate :
            // 0 0 1 1 0 0
            // 5 4 3 2 1 0
            // place :
            // 0 0 0 1 0 0
            // candidate :
            // 0 0 1 0 0 0
            // 5 4 3 2 1 0
            // place :
            // 0 0 1 0 0 0
            // candidate :
            // 0 0 0 0 0 0
            // 5 4 3 2 1 0
            place = candidate & (-candidate);
            candidate ^= place;
            ans += f2(limit, col | place, (left | place) >> 1, (right | place) << 1);
        }
        return ans;
    }
}
