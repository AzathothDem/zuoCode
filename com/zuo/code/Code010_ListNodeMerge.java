package com.zuo.code;

import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

public class Code010_ListNodeMerge {


    // 两个有序的链表合并
    public static ListNode ListNodeByOrderMerge(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.val <= head2.val ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;

            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    public ListNode addTwoNumbers(ListNode hea1, ListNode hea2) {
        ListNode ans = null, cur = null;
        int carry = 0;
        for (int sum, val;
             hea1 != null || hea2 != null;
             hea1 = hea1 == null ? null : hea1.next,
                     hea2 = hea2 == null ? null : hea2.next) {

            sum = (hea1 == null ? 0 : hea1.val) + (hea2 == null ? 0 : hea2.val) + carry;

            val = sum % 10;
            carry = sum / 10;
            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }

        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return ans;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, leftTail = null;
        ListNode rightHead = null, rightTail = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                } else {
                    leftTail.next = head;
                }
                leftTail = head;
            } else {
                if (rightHead == null) {
                    rightHead = head;

                } else {
                    rightTail.next = head;
                }
                rightTail = head;
            }
            head = next;
        }
        if (leftHead == null) {
            return rightHead;
        }
        if (rightHead == null) {
            return leftHead;
        }
        leftTail.next = rightHead;
        return leftHead;
    }
}
