package com.zuo.code;

// 提取二进制状态中最右位的1 n & (-n)
public class Code029_3_SingleNumber {
    //    给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
    public int[] singleNumber(int[] nums) {
        int eor1 = 0;
        for (int num : nums) {
            eor1 ^= num;
        }
        int rightOne = eor1 & (-eor1);

        int eor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightOne) == 0) {
                eor2 ^= nums[i];
            }
        }

        return new int[]{eor2, eor1 ^ eor2};


    }
}
