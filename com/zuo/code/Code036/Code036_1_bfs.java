package com.zuo.code.Code036;

import com.sun.org.apache.bcel.internal.generic.PUSH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Code036_1_bfs {
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

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return null;
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> levels = new HashMap<>();
        queue.add(root);
        levels.put(root, 0);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            Integer level = levels.get(cur);
            if (ans.size() == level) {
                ans.add(new ArrayList<>());
            }
            ans.get(level).add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
                levels.put(cur.left, level + 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                levels.put(cur.right, level + 1);
            }
        }
        return ans;
    }

    public List<List<Integer>> levelOrder01(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode endNode = root;
            TreeNode nextEndNode = null;

            ArrayList<Integer> temp = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    nextEndNode = cur.left;
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    nextEndNode = cur.right;
                }
                temp.add(cur.val);
                if (endNode == cur) {
                    ans.add(temp);
                    temp = new ArrayList<>();
                    endNode = nextEndNode;
                }
            }
        }
        return ans;
    }

    public static int MAXN = 2001;

    public static TreeNode[] queue = new TreeNode[MAXN];
    public static int l, r;

    public List<List<Integer>> levelOrder02(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            l = r = 0;
            queue[r++] = root;
            while (l < r){
                int size = r - l;
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l++];
                    list.add(cur.val);
                    if (cur.left!=null){
                        queue[r++]=cur.left;
                    }
                    if (cur.right!=null){
                        queue[r++]=cur.right;
                    }
                }
                ans.add(list);
            }
        }
        return ans;
    }


}
