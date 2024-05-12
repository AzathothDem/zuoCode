package com.zuo.code.code041;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Code041_1_GcdAndLcm {

    // 辗转相除法
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
