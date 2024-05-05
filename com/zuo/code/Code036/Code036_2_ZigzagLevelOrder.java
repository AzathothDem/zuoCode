package com.zuo.code.Code036;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.ArrayList;
import java.util.List;

public class Code036_2_ZigzagLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int MAXN = 2001;

    public static TreeNode[] queue = new TreeNode[MAXN];
    public static int l, r;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            l = r = 0;
            queue[r++] = root;
            boolean reverse = false;
            while (l < r) {
                int size = r - l;
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = reverse ? r - 1 : l, j = reverse ? -1 : 1, k = 0;
                     k < size;
                     i += j, k++
                ) {
                    TreeNode cur = queue[i];
                    list.add(cur.val);
                }
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l++];
                    if (cur.left != null) {
                        queue[r++] = cur.left;
                    }
                    if (cur.right != null) {
                        queue[r++] = cur.right;
                    }
                }
                ans.add(list);
                reverse = !reverse;
            }
        }
        return ans;

    }
}
