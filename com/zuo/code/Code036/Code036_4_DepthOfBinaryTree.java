package com.zuo.code.Code036;

import java.util.List;

public class Code036_4_DepthOfBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static int maxDepth(TreeNode root) {
        return root == null ? 0 :
                Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int ldeep = Integer.MIN_VALUE;
        int rdeep = Integer.MIN_VALUE;
        if (root.left != null) ldeep = minDepth(root.left);
        if (root.right != null) rdeep = minDepth(root.right);
        return Math.min(ldeep, rdeep) + 1;
    }
}
