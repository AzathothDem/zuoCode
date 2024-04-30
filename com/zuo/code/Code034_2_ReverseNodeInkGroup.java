package com.zuo.code;

import java.util.List;

public class Code034_2_ReverseNodeInkGroup {

    public static ListNode reverseKGroup(ListNode head,int k){
        ListNode start = head;
        ListNode end = teamEnd(start,k);
        if (end == null) return head;

        head = end;
        reverse(start,end);

        ListNode lastTeamEnd = start;
        while (lastTeamEnd.next!=null){
            start = lastTeamEnd.next;
            end = teamEnd(start,k);
            if (end == null) return head;
            reverse(start,end);
            lastTeamEnd.next = end;
            lastTeamEnd = start;
        }
        return head;
    }



    private static ListNode teamEnd(ListNode start, int k) {
        while (--k!=0 && start!=null){
            start = start.next;
        }
        return start;
    }

    // s -> a -> b -> c -> e -> 下一组的开始节点
    // 上面的链表通过如下的reverse方法调整成 : e -> c -> b -> a -> s -> 下一组的开始节点
    public static void reverse(ListNode s, ListNode e) {
        e = e.next;
        ListNode pre = null, cur = s, next = null;
        while (cur != e) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        s.next = e;
    }
}
