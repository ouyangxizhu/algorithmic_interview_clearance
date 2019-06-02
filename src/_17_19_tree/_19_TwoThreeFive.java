package _17_19_tree;

import util.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class _19_TwoThreeFive {
    /**
     * 可以从根节点遍历找到节点（在过程中记录路径，找到最后的共同节点）
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        // 要么在左子树，要么在右子树，要么就是根节点
        while(root != null){
            if(p.val>root.val&&q.val>root.val)
                root=root.right;
            else if(p.val<root.val&&q.val<root.val)
                root=root.left;
            else return root;
        }
        return root;
    }
    /**
     * 可以从根节点遍历找到节点（在过程中记录路径，找到最后的共同节点）
     * 递归写法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // 要么在左子树，要么在右子树，要么就是根节点

        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor1(root.right, p, q);
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor1(root.left, p, q);
        return root;
    }
}
