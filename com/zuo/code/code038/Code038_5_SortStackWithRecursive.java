package com.zuo.code.code038;

import java.util.Stack;

public class Code038_5_SortStackWithRecursive {
    public static void sort(Stack<Integer> stack) {
        int deep = deep(stack);
        while (deep > 0) {
            int max = max(stack, deep);
            int k = times(stack, deep, max);
            down(stack, deep, max, k);
            deep -= k;
        }
    }

    // 返回栈的深度
    // 不改变栈的数据状况
    public static int deep(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return 0;
        }
        int num = stack.pop();
        int deep = deep(stack) + 1;
        stack.push(num);
        return deep;
    }

    // 从栈当前的顶部开始，往下数deep层
    // 返回这deep层里的最大值
    public static int max(Stack<Integer> stack, int deep) {
        if (deep == 0) {
            return Integer.MIN_VALUE;
        }
        int num = stack.pop();
        int restMax = max(stack, deep - 1);
        int max = Math.max(num, restMax);
        stack.push(num);
        return max;
    }

    // 从栈当前的顶部开始，往下数deep层，已知最大值是max了
    // 返回，max出现了几次，不改变栈的数据状况
    public static int times(Stack<Integer> stack, int deep, int max) {
        if (deep == 0) {
            return 0;
        }
        int num = stack.pop();
        int restTimes = times(stack, deep - 1, max);
        int times = restTimes + (num == max ? 1 : 0);
        stack.push(num);
        return times;
    }

    // 从栈当前的顶部开始，往下数deep层，已知最大值是max，出现了k次
    // 请把这k个最大值沉底，剩下的数据状况不变
    public static void down(Stack<Integer> stack, int deep, int max, int k) {
        if (deep == 0) {
            for (int i = 0; i < k; i++) {
                stack.push(max);
            }
        } else {
            int num = stack.pop();
            down(stack, deep - 1, max, k);
            if (num != max) {
                stack.push(num);
            }
        }
    }

    // 为了测试
    // 生成随机栈
    public static Stack<Integer> randomStack(int n, int v) {
        Stack<Integer> ans = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            ans.add((int) (Math.random() * v));
        }
        return ans;
    }

    // 为了测试
    // 检测栈是不是从顶到底依次有序
    public static boolean isSorted(Stack<Integer> stack) {
        int step = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            if (step > stack.peek()) {
                return false;
            }
            step = stack.pop();
        }
        return true;
    }
}
