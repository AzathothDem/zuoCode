package com.zuo.code.code038;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code038_2_Combinations {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        f(nums, 0, new int[nums.length], 0, ans);
        return ans;
    }

    private static void f(int[] nums, int i, int[] path, int size, ArrayList<List<Integer>> ans) {
        if (i == nums.length) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                cur.add(path[j]);
            }
            ans.add(cur);
        } else {
            // 下一组的第一个数的位置
            int j = i + 1;
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            f(nums, j, path, size, ans);
            for (; i < j; i++) {
                path[size++] = nums[i];
                f(nums, j, path, size, ans);
            }
        }

    }
}
