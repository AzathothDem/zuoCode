package com.zuo.code;

import java.util.Deque;
import java.util.LinkedList;

public class Code15__DeQueue {
    class MyCircularDeque {
        public Deque<Integer> deque = new LinkedList<>();
        public int size;
        public int limit;

        public MyCircularDeque(int k) {
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                deque.addFirst(value);
                size++;
                return true;
            }
        }

        private boolean isFull() {
            return limit == size;
        }
    }

    class MyDeQue {
        public int[] deQue;
        public int limit, size;

        public int left; //左闭右闭
        public int right;

        public MyDeQue(int k) {
            deQue = new int[k];
            left = right = size = 0;
            limit = k;
        }

        public boolean insertFront(int v) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    left = right = 0;
                    deQue[0] = v;
                } else {
                    left = left == 0 ? (limit - 1) : (left - 1);
                    deQue[left] = v;
                }
                size++;
                return true;
            }
        }

        public boolean insertLast(int v) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    left = right = 0;
                    deQue[0] = v;
                } else {
                    right = right == limit - 1 ? 0 : right + 1;
                    deQue[right] = v;
                }
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                left = left == limit - 1 ? 0 : left + 1;
                size--;
                return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                right = right == 0 ? limit - 1 : right - 1;
                size--;
                return true;
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
