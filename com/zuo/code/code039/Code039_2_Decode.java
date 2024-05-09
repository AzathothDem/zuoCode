package com.zuo.code.code039;

public class Code039_2_Decode {

    public static int where;
    public static String decodeString(String str) {
        where = 0;
        return f(str.toCharArray(), 0);
    }

    private static String f(char[] s, int i) {
        StringBuilder path = new StringBuilder();
        int cnt = 0;
        while (i < s.length && s[i] != ']') {
            if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z')) {
                path.append(s[i++]);
            } else if (s[i] >= '0' && s[i] <= '9') {
                cnt = cnt * 10 + s[i++] - '0';
            } else {
                // 遇到 [
                // cnt = 7 * ?
                path.append(get(cnt, f(s, i + 1)));
                i = where + 1;
                cnt = 0;
            }
        }
        where = i;
        return path.toString();
    }

    private static String get(int cnt, String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            builder.append(str);
        }
        return builder.toString();
    }

}
