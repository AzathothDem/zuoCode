package com.zuo.code.code037;

public class Code037_2_LowestCommonAncestor {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root.val != p.val && root.val != q.val) {

            if (Math.min(p.val, q.val) < root.val && Math.max(p.val, q.val) > root.val) {
                break;
            }
            root = root.val < Math.min(p.val, q.val) ? root.right : root.left;
        }
        return root;
    }
}
