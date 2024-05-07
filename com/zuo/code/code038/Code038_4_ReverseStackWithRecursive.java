package com.zuo.code.code038;

import java.util.Stack;

public class Code038_4_ReverseStackWithRecursive {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int num = bottomOut(stack);
        reverse(stack);
        stack.push(num);
    }

    private static int bottomOut(Stack<Integer> stack) {
        int ans = stack.pop();
        if (stack.isEmpty()){
            return ans;
        }else {
            int last = bottomOut(stack);
            stack.push(ans);
            return last;
        }
    }
}
