package _10_12_PriorityQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * 滑动窗口最大值
 */
public class _12TwoThreeNine {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++){
            if(i >= k && q.getFirst() <= i - k) q.removeFirst();
            while(!q.isEmpty() && nums[q.getLast()] <= nums[i])
                q.removeLast();
            q.add(i);
            if (i >= k - 1)
                res[i - k + 1] = nums[q.getFirst()];

        }
        return res;
    }
}
