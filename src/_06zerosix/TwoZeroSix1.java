package _zerosix;

import util.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 反转链表
 */

public class TwoZeroSix1 {
    /**
     * 方法一：迭代
     *
     * 假设存在链表 1 → 2 → 3 → Ø，我们想要把它改成 Ø ← 1 ← 2 ← 3。
     *
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。
     * 由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。
     * 不要忘记在最后返回新的头引用！
     *
     * 时间复杂度：O(n)，假设 nn 是列表的长度，时间复杂度是 O(n)O(n)。
     * 空间复杂度：O(1)。
     * @param head
     * @return
     */
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

    /**
     * 递归版本稍微复杂一些，其关键在于反向工作。假设列表的其余部分已经被反转，现在我该如何反转它前面的部分？
     *
     * 假设列表为：
     * n1->...nk-1->nk -> nk+1 -> ...nm -> null
     *
     * 若从nk+1到nm已经反转，我们正处于nk。
     * n1->...nk-1->nk -> nk+1 <-...nm
     *
     * 我们希望nk+1指向nk
     * 即nk.next.next = nk;
     * ​
     *   要小心n1的下一个必须指向 null。如果你忽略了这一点，你的链表中可能会产生循环。
     *   如果使用大小为 2 的链表测试代码，则可能会捕获此错误。
     *
     *
     *  时间复杂度：O(n)，假设 nn 是列表的长度，那么时间复杂度为 O(n)O(n)。
     * 空间复杂度：O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到 nn 层。
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
