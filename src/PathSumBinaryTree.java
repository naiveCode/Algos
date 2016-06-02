/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class PathSumBinaryTree {
    public int hasPathSum(TreeNode a, int b) {
        if (utilPathSum(a, b, 0)) {
            return 1;
        }
        return 0;
    }

    private boolean utilPathSum(TreeNode a, int b, int c) {
        if (a != null) {
            if (b == c + a.val && a.left == null && a.right == null) {
                return true;
            }

            return (utilPathSum(a.left, b, c + a.val) | utilPathSum(a.right, b, c + a.val));

        } else {
            return false;
        }
    }
}
