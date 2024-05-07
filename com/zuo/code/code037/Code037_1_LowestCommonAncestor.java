package com.zuo.code.code037;

import com.zuo.code.Code036.Code037_7_CompleteTreeNum;
import com.zuo.code.TreeNode;

public class Code037_1_LowestCommonAncestor {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode l = lowestCommonAncestor(root.left, p,  q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) {
            return root;
        }
        if (l == null && r == null) {
            return null;
        }
        return l!=null ? l : r;
    }
}
