package com.zuo.code.leetcode;

import com.zuo.code.ListNode;

import java.util.PriorityQueue;

public class LeetCode023 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        if (heap.isEmpty()) return null;

        ListNode h = heap.poll();
        ListNode pre = h;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()){
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next!=null){
                heap.add(cur.next);
            }
        }
        return h;
    }
}
