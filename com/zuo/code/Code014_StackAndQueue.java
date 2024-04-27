package com.zuo.code;

import java.util.Stack;

public class Code014_StackAndQueue {
    class MyQueue{
        public Stack<Integer> in;
        public Stack<Integer> out;

        public MyQueue(){
            in = new Stack<>();
            out = new Stack<>();
        }

        private void inToOut(){
            if (out.isEmpty()){
                while (!in.empty()){
                    out.push(in.pop());
                }
            }
        }

        public void push(int x){
            in.push(x);
            inToOut();
        }
        public int pop(){
            inToOut();
            return out.pop();
        }

        public int peek(){
            inToOut();
            return out.peek();
        }
    }
}
