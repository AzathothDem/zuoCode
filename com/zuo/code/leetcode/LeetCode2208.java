package com.zuo.code.leetcode;

import java.util.PriorityQueue;

public class LeetCode2208 {
    public int halveArray(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int ans = 0;
        PriorityQueue<Double> heap = new PriorityQueue<Double>((a, b) -> b.compareTo(a));
        double sum = 0;
        for (int num : nums) {
            heap.add((double) num);
            sum += num;
        }
        sum /= 2;
        for (double minus = 0, cur; minus < sum; ans++, minus += cur) {
            cur = heap.poll() / 2;
            heap.add(cur);
        }
        return ans;


    }
}
