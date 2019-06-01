package _06_array_linkedlist;

import util.ListNode;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * k个一组反转列表
 */
public class _5TwoFive {
    /**
     * 思路一：
     *
     * 用栈，我们把 k 个数压入栈中，然后弹出来的顺序就是翻转的！
     * 这里要注意几个问题：
     * 第一，剩下的链表个数够不够 k 个（因为不够 k 个不用翻转）；
     * 第二，已经翻转的部分要与剩下链表连接起来
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true){
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k){
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if(count != k){
                p.next = head;
                break;
            }
            while (!stack.isEmpty()){
                p.next = stack.pop();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }

    /**
     * 思路二：
     *
     * 尾插法
     *
     * 直接举个例子：k = 3
     *
     * pre
     * tail    head
     * dummy    1     2     3     4     5
     * # 我们用tail 移到要翻转的部分最后一个元素
     * pre     head       tail
     * dummy    1     2     3     4     5
     * 	       cur
     * # 我们尾插法的意思就是,依次把cur移到tail后面
     * pre          tail  head
     * dummy    2     3    1     4     5
     * 	       cur
     * # 依次类推
     * pre     tail      head
     * dummy    3     2    1     4     5
     * 		   cur
     * ....
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (true){
            int count = 0;
            while (tail != null && count != k){
                count++;
                tail = tail.next;
            }
            if (tail == null) break;
            ListNode head1 = pre.next;
            while (pre.next != tail){
                ListNode cur = pre.next;
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
            pre = head1;
            tail = head1;
        }
        return dummy.next;
    }

    /**
     * 递归
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count != 0) {
                count--;
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }
}
