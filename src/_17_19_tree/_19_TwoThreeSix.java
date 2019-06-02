package _17_19_tree;

import util.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class _19_TwoThreeSix {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归的出口
        if (root == null || p == root || q == root) {
            return root;
        }
        // 递归调用
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 左子树
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 右子树
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;

    }
}
