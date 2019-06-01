package _10_12_PriorityQueue;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
public class _11SevenZeroThree {
    final PriorityQueue<Integer> q;
    final int k;
    public _11SevenZeroThree(int k, int[] nums) {
        this.k = k;
        this.q = new PriorityQueue<>(k);
        for(int a : nums) add(a);

    }

    public int add(int val) {
        if(q.size() < k)
            q.offer(val);
        else if (q.peek() < val){
            q.poll();
            q.offer(val);
        }
        return q.peek();

    }
}
