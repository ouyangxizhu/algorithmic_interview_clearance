package _26_30_dfs_bfs;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class _28_OneZeroTwo {
    /**
     * bfs
     *
     *      1.About Complexity
     *          1.1 Time Complexity is O(log n^2)
     *          1.2 Space Complexity is O(log n)
     *      2.how I solve
     *          2.1 use a queue to cache current floor's node
     *          2.2 circulate by queue is not empty
     *                   2.2.1 use a integer to record queue's size
     *                   2.2.2 circulate 1 to queue size to poll node from queue
     *                   2.2.3 add the polled node's val to a list
     *                   2.2.4 add the polled node's children to queue
     *                   2.2.5 add the vals list to result list
     *      3.About submit record
     *          3.1 3ms and 38.4MB memory in LeetCode China
     *          3.2 1ms and 37.4MB memory in LeetCode
     *      4.Q&A
     *      @param root
     *      @return
     *
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int count = q.size();
            List<Integer> list = new ArrayList<Integer>();
            while (count>0) {
                TreeNode temp = q.poll();
                list.add(temp.val);
                if (temp.left!=null) {
                    q.add(temp.left);
                }
                if (temp.right!=null) {
                    q.add(temp.right);
                }
                count--;

            }
            res.add(list);

        }
        return res;
    }

    /**
     * dfs也可以，但是需要记住层数
     * 时间复杂度O(n)，空间复杂度O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        levelOrderHelper(root, 0, ans);

        return ans;
    }

    private void levelOrderHelper(TreeNode root, int depth, List<List<Integer>> ans) {
        if (root == null)
            return;
        // 如果采用中序/后序遍历，需要将if改成while
        if (depth >= ans.size())
            ans.add(new ArrayList<>());

        ans.get(depth).add(root.val);

        levelOrderHelper(root.left, depth + 1, ans);
        levelOrderHelper(root.right, depth + 1, ans);
    }
}
