package com.zuo.code.code037;

import java.util.ArrayList;
import java.util.List;

public class Code037_3_PathSum {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static List<List<Integer>> pathSum(TreeNode root, int aim) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            ArrayList<Integer> path = new ArrayList<>();
            process(root, aim, 0, path, ans);
        }
        return ans;
    }

    private static void process(TreeNode h, int aim, int sum, ArrayList<Integer> path, ArrayList<List<Integer>> ans) {
        if (h.left == null && h.right == null) {
            if (h.val + sum == aim) {
                path.add(h.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
        } else {
            path.add(h.val);
            if (h.left != null) {
                process(h.left, aim, sum + h.val, path, ans);
            }
            if (h.right != null) {
                process(h.right, aim, sum + h.val, path, ans);
            }
            path.remove(path.size() - 1);
        }


    }
}
