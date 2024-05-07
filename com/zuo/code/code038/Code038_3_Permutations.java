package com.zuo.code.code038;

import java.util.ArrayList;
import java.util.List;

public class Code038_3_Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        f(nums, 0, ans);
        return ans;
    }

    private static void f(int[] nums, int i, ArrayList<List<Integer>> ans) {
        if (i == nums.length) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int num : nums) {
                cur.add(num);
            }
            ans.add(cur);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                f(nums, i + 1, ans);
                swap(nums, i, j);

            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
