package com.zuo.code;

public class Code032_1_BitsSet {

    public static class Bitset {
        public int[] set;

        public Bitset(int n) {
            set = new int[(n + 31) / 32];
        }

        public void add(int num) {
            set[num / 32] = set[num / 32] | 1 << (num % 32);
        }

        public void remove(int num) {
            set[num / 32] = set[num / 32] & ~(1 << (num % 32));
        }

        public void reverse(int num) {
            set[num / 32] = set[num / 32] ^ (1 << (num % 32));
        }

        public boolean contains(int num) {
            return ((set[num / 32] >> (num % 32)) & 1) == 1;
        }
    }
}
