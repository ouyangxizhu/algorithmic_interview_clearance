package _17_19_tree;


import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _18_NineEight {
    /**
     * 中序遍历之后比较
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<Integer>();
        search(root,list);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i)>=list.get(i+1)) {
                return false;
            }
        }
        return true;
    }
    public static void search(TreeNode root, List<Integer> list){
        if (root==null) {
            return;
        }
        search(root.left, list);
        list.add(root.val);
        search(root.right, list);
    }
    /**
     * 中序遍历之后比较
     * 但是可以只存一个中间数进行比较，不需要存储全部元素
     *
     * * 1.About Complexity
     *      *     1.1 Time Complexity is O(log n)
     *      *     1.2 Space Complexity is O(1)
     *      * 2.how I solve
     *      *     2.1 this solution is base on inorder traversal
     *      *     2.2 root's val is less than right children's val and greater than left children's val
     *      * 3.About submit record
     *      *     3.1 1ms and 37.7MB memory in LeetCode China
     *      *     3.2 0ms and 38.2MB memory in LeetCode
     *      * 4.Q&A
     * @param root
     * @return
     */
    long last = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if(isValidBST2(root.left)){
            if (last < root.val){
                last = root.val;
                return isValidBST2(root.right);
            }
        }
        return false;
    }

    /**
     *
     *  验证当前节点是否满足条件，否返回false，是则验证左右子节点。
     *
     * @param root
     * @return
     */

    public boolean isValidBST3(TreeNode root) {
        return isValidBST4(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST4(TreeNode root, long min, long max) {
        if (root == null) return true;
        //该节点的值必须在最小值和最大值之间
        if (root.val >= max || root.val <= min) return false;
        return isValidBST4(root.left, min, root.val) && isValidBST4(root.right, root.val, max);
    }

}
