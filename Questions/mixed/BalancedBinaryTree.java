/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    public int isBalanced(TreeNode root) {
        if(depth(root)==0){
            return 0;
        }
        return 1;
    }

    private int depth(TreeNode a) {
        if (a == null) {
            return 1;
        }
        int left = depth(a.left);
        int right = depth(a.right);
        if (Math.abs(left - right) > 1 && left!=0 && right!=0) {
            return 0;
        }
        return Math.max(left, right) + 1;


    }
}
