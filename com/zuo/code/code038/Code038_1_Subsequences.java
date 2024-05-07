package com.zuo.code.code038;

import java.util.HashSet;

public class Code038_1_Subsequences {

    public static void f1(char[] s, int i, StringBuilder path, HashSet<String> set) {
        if (i == s.length) {
            set.add(path.toString());
        } else {
            path.append(s[i]);
            f1(s, i + 1, path, set);
            path.deleteCharAt(path.length() - 1);
            f1(s, i + 1, path, set);
        }
    }
}
