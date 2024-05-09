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
}
