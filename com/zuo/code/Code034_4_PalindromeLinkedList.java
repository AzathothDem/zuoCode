package com.zuo.code;

import java.util.List;

public class Code034_4_PalindromeLinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    // 提交如下的方法
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = slow;
        ListNode cur = pre.next;
        ListNode next = null;
        pre.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        boolean ans = true;
        ListNode left = head;
        ListNode right = pre;

        while (left != null && right != null) {
            if (left.val != right.val) {
                ans = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        cur = pre.next;
        pre.next = null;
        next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return ans;

    }
}
