package _zerosix;

import util.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 反转链表
 */
public class TwoZeroSix1 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
