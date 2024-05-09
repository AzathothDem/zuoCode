package com.zuo.code.code039;

import java.util.ArrayList;

public class Code039_1_BasicCalculatorIII {

    public static int where;

    public static int calculate(String str) {
        where = 0;
        return f(str.toCharArray(), 0);
    }

    private static int f(char[] str, int i) {

        int cur = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();
        while (i < str.length && str[i] != ')') {
            if (str[i] <= '9' && str[i] >= '0') {
                cur = cur * 10 + str[i++] - '0';
            } else if (str[i] != '(') {
                push(numbers, ops, cur, str[i++]);
                cur = 0;
            } else {
                cur = f(str, i + 1);
                i = where + 1;
            }
        }
        push(numbers, ops, cur, '+');
        where = i;
        return compute(numbers, ops);
    }

    private static int compute(ArrayList<Integer> numbers, ArrayList<Character> ops) {
        int n = numbers.size();
        int ans = numbers.get(0);
        for (int i = 1; i < n; i++) {
            ans += ops.get(i - 1) == '+' ? numbers.get(i) : -numbers.get(i);
        }
        return ans;
    }

    private static void push(ArrayList<Integer> numbers, ArrayList<Character> ops, int cur, char op) {
        int n = numbers.size();
        if (n == 0 || ops.get(n - 1) == '+' || ops.get(n - 1) == '-') {
            numbers.add(cur);
            ops.add(op);
        } else {
            int topNumber = numbers.get(n - 1);
            char topOp = ops.get(n - 1);
            if (topOp == '*') {
                numbers.set(n - 1, topNumber * cur);
            } else {
                numbers.set(n - 1, topNumber * cur);
            }
            ops.set(n - 1, op);
        }
    }
}
