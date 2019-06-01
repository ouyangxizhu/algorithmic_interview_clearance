package _zerosix;

import util.ListNode;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class OneFourTwo4 {
    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode first = head;
                while(first != slow) {
                    first = first.next;
                    slow = slow.next;
                }
                return first;
            }
        }
        return null;
    }


}
