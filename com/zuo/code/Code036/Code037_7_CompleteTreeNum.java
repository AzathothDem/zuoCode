package com.zuo.code.Code036;



public class Code037_7_CompleteTreeNum {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int countNodes(TreeNode head) {
        if (head == null) return 0;
        return f(head, 1, mostLeft(head, 1));
    }

    private static int f(TreeNode cur, int level, int h) {
        if (level == h) return 1;
        if (mostLeft(cur.right, level + 1) == h) {
            return (1 << (h - level))+ f(cur.right, level + 1, h);
        } else {
            return (1 << (h - level - 1)) + f(cur.left, level + 1, h);
        }
    }

    private static int mostLeft(TreeNode cur, int level) {
        while (cur != null) {
            level++;
            cur = cur.left;
        }
        return level - 1;
    }
}
