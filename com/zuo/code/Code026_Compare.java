package com.zuo.code;

import java.util.Comparator;

public class Code026_Compare {
    // 实现comparator 比较器接口 定义自己的compare方法
    // 负数 o1 的优先级高
    // 正数 o2 的优先级高
    public static class EmplopyeeComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    }
}
