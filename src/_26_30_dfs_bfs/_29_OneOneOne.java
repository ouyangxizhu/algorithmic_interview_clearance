package _26_30_dfs_bfs;

import util.TreeNode;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class _29_OneOneOne {
    /**
     * 递归
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);

        int dLeft = minDepth(root.left);
        int dRight = minDepth(root.right);

        return 1 + Math.min(dLeft,dRight);
    }
}
