package com.zuo.code.code037;

import static javax.swing.Spring.height;

public class Code037_4_BalancedBinaryTree {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static boolean balance;

    public static boolean isBalance(TreeNode root) {
        balance = true;
        height(root);
        return balance;
    }

    private static int height(TreeNode root) {
        if (!balance || root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh - rh) > 1) {
            balance = false;
        }
        return Math.max(lh, rh) + 1;
    }
}
