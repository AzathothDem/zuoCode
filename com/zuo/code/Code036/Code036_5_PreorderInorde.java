package com.zuo.code.Code036;

import java.util.HashMap;

public class Code036_5_PreorderInorde {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    private static TreeNode f(int[] pre, int l1, int r1, int[] in, int l2, int r2, HashMap<Integer, Integer> map) {
        if (l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[l1]);
        if (l1 == r1) return head;

        int k = map.get(pre[l1]);
        head.left = f(pre, l1 + 1, l1 + k - l2,
                in, l2, k - 1, map);
        head.right = f(pre, l1 + k - l2 + 1, r1, in, k + 1, r2, map);
        return head;
    }
}
