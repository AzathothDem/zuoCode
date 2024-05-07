package com.zuo.code.code037;

public class Code037_6_TrimBinarySearchTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static TreeNode trimBST(TreeNode cur, int low, int high) {
        if (cur == null) return null;
        if (cur.val < low) {
            return trimBST(cur.right, low, high);
        }
        if (cur.val > high) {
            return trimBST(cur.left, low, high);
        }
        cur.left = trimBST(cur.left, low, high);
        cur.right = trimBST(cur.right, low, high);
        return cur;
    }
}
