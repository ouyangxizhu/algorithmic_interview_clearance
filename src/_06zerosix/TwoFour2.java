package _zerosix;

import util.ListNode;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class TwoFour2 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;
        pre.next = head;
        while (head != null && head.next != null){
            ListNode tmp = head.next.next;
            pre.next = head.next;
            pre.next.next = head;
            pre = head;
            head.next = tmp;
            head = tmp;
        }
        return newHead.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = head.next;
        head.next = swapPairs(head.next.next);
        tmp.next = head;
        return tmp;

    }

}
