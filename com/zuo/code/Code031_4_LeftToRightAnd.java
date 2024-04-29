package com.zuo.code;

public class Code031_4_LeftToRightAnd {

    public static int LeftToRightAnd(int right, int left) {
        while (left < right) {
            right -= right & -right;
            // right 不停减掉最右测的1
        }
        return right;
    }
}
