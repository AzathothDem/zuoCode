package com.zuo.code;

public class Code030_MissingNumber {
    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int eorAll = 0, eorHas = 0;
        for (int i = 0; i < nums.length; i++) {
            eorAll ^= i;
            eorHas ^= nums[i];
        }
        eorAll ^= nums.length;
        return eorAll ^ eorHas;
    }

}
