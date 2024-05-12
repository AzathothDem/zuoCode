package com.zuo.code.code043;

public class Code043_2_SuperPalindromes {
    public static int superpalindromesInRange1(String left, String right) {
        long l = Long.valueOf(left);
        long r = Long.valueOf(right);
        // l....r  long
        // x根号，范围limit
        long limit = (long) Math.sqrt((double) r);
        // seed : 枚举量很小，10^18 -> 10^9 -> 10^5
        // seed : 奇数长度回文、偶数长度回文
        long seed = 1;
        // num : 根号x，num^2 -> x
        long num = 0;
        int ans = 0;
        do {
            //  seed生成偶数长度回文数字
            // 123 -> 123321
            num = evenEnlarge(seed);
            if (check(num * num, l, r)) {
                ans++;
            }
            //  seed生成奇数长度回文数字
            // 123 -> 12321
            num = oddEnlarge(seed);
            if (check(num * num, l, r)) {
                ans++;
            }
            // 123 -> 124 -> 125
            seed++;
        } while (num < limit);
        return ans;
    }

    // 根据种子扩充到偶数长度的回文数字并返回
    public static long evenEnlarge(long seed) {
        long ans = seed;
        while (seed != 0) {
            ans = ans * 10 + seed % 10;
            seed /= 10;
        }
        return ans;
    }

    // 根据种子扩充到奇数长度的回文数字并返回
    public static long oddEnlarge(long seed) {
        long ans = seed;
        seed /= 10;
        while (seed != 0) {
            ans = ans * 10 + seed % 10;
            seed /= 10;
        }
        return ans;
    }

    // 判断ans是不是属于[l,r]范围的回文数
    public static boolean check(long ans, long l, long r) {
        return ans >= l && ans <= r && isPalindrome(ans);
    }

    // 验证long类型的数字num，是不是回文数字
    public static boolean isPalindrome(long num) {
        long offset = 1;
        // 注意这么写是为了防止溢出
        while (num / offset >= 10) {
            offset *= 10;
        }
        // num    : 52725
        // offset : 10000
        // 首尾判断
        while (num != 0) {
            if (num / offset != num % 10) {
                return false;
            }
            num = (num % offset) / 10;
            offset /= 100;
        }
        return true;
    }


}
