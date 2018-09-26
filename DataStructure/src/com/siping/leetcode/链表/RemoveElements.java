package com.siping.leetcode.链表;

/**
 * 203. 删除链表中的节点
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        while (head.next != null) {
            if(head.val == val) {
                head.val = head.next.val;
                head.next = head.next.next;
            }
        }
        return null;
    }
}
