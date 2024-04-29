package com.zuo.code;

public class Code031_1_PowerOfTwo {

    public static boolean isPowerOfTwo(int n ){
        return n > 0 && n == (n & -n);
    }
}
