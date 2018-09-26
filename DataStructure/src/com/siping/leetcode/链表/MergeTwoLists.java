package com.siping.leetcode.链表;

/**
 * 21.合并两个有序链表
 */
public class MergeTwoLists {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode target = new ListNode(0); // 设置头节点
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode node = target;
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                target.next = l2;
                break;
            }
            if(l2 == null) {
                target.next = l1;
                break;
            }
            if(l1.val > l2.val) {
                target.next = l2;
                l2 = l2.next;
            }else {
                target.next = l1;
                l1 = l1.next;
            }
            target = target.next;
        }
        return node.next;
    }
    
}
