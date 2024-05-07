package com.zuo.code.code037;

public class Code037_5_ValidateBinarySearchTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static int MAXN = 10001;

    public static TreeNode[] stack = new TreeNode[MAXN];

    public static int r;

    // 提交时改名为isValidBST
    public static boolean isValidBST1(TreeNode head) {
        if (head == null) {
            return true;
        }
        TreeNode pre = null;
        r = 0;
        while (r > 0 || head != null) {
            if (head != null) {
                stack[r++] = head;
                head = head.left;
            } else {
                head = stack[--r];
                if (pre != null && pre.val >= head.val) {
                    return false;
                }
                pre = head;
                head = head.right;
            }
        }
        return true;
    }

    public static long min, max;

    public static boolean isValidBST2(TreeNode head) {
        if (head == null) {
            min = Integer.MIN_VALUE;
            max = Integer.MAX_VALUE;
            return true;
        }
        boolean leftB = isValidBST2(head.left);
        long lmin = min;
        long lmax = max;
        boolean rightB = isValidBST2(head.right);
        long rmin = min;
        long rmax = max;
        min = Math.min(Math.min(lmin, rmin), head.val);
        max = Math.max(Math.max(lmax, rmax), head.val);
        return leftB && rightB && head.val < rmin && head.val > lmax;

    }

}
