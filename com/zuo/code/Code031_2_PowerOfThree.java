package com.zuo.code;

public class Code031_2_PowerOfThree {

    public static boolean isPowerOfThree(int n){
        return n > 0 && 1162261467 % n == 0;
    }
}
