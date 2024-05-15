package com.zuo.code.code045;

import com.zuo.code.code044.Code044_1_TrieTree;

import java.util.Arrays;

public class Code045_1_CountConsistentKeys {
    public static int[] countConsistentKeys(int[][] a, int[][] b) {
        build();
        StringBuilder builder = new StringBuilder();
        for (int[] nums : a) {
            builder.setLength(0);
            for (int i = 1; i < nums.length; i++) {
                builder.append(String.valueOf(nums[i] - nums[i - 1]) + "#");
            }
            insert(builder.toString());
        }
        int[] ans = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            builder.setLength(0);
            int[] nums = b[i];
            for (int j = 1; j < nums.length; j++) {
                builder.append(String.valueOf(nums[j] - nums[j - 1]) + "#");
            }
            ans[i] = count(builder.toString());
        }
        clear();
        return ans;
    }

    private static int count(String word) {
        int cur = 1;
        for (int i = 0, path; i < word.length(); i++) {
            path = path(word.charAt(i));
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return pass[cur];
    }

    public static int MAXN = 200001;

    public static int[][] tree = new int[MAXN][12];

    public static int[] end = new int[MAXN];

    public static int[] pass = new int[MAXN];

    public static int cnt;

    public static void build() {
        cnt = 1;
    }

    public static int path(char cha) {
        if (cha == '#') {
            return 10;
        } else if (cha == '-') {
            return 11;
        } else {
            return cha - '0';
        }
    }
    public static void insert(String word){
        int cur = 1;
        pass[cur]++;
        for (int i = 0, path; i < word.length(); i++) {
            path = path(word.charAt(i));
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
            pass[cur]++;
        }
        end[cur]++;
    }

    public static void clear() {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
            end[i] = 0;
            pass[i] = 0;
        }
    }
}
