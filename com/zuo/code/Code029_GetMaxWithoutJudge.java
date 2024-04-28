package com.zuo.code;

public class Code029_GetMaxWithoutJudge {

    // 必须保证n一定是0 或者 1
    public static int flip(int n) {
        return n ^ 1;
    }

    // 非负数为1 负数为0
    public static int sign(int n) {
        return flip(n >>> 31);
    }

    /**
     * 有溢出的风险
     *
     * @param a
     * @param b
     * @return
     */
    public static int getMax1(int a, int b) {
        int c = a - b;
        int ReturnA = sign(c);
        int ReturnB = flip(ReturnA);
        return a * ReturnA + b * ReturnB;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        // 判断a 和 b 的符号是不是不一样
        int diffAB = sa ^ sb;
        int sameAB = flip(diffAB);
        // a 和 b 不一样 且 a非负   a 和 b符号一样 且c非负
        int returnA = diffAB * sa + sameAB * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }


}
