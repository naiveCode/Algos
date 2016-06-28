/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode a) {
        if (a == null) {
            return 0;
        }
        return utilDepth(a);

    }

    private int utilDepth(TreeNode a) {
        if (a == null) {
            return 0;
        }
        int left = utilDepth(a.left);
        int right = utilDepth(a.right);
        return Math.max(left, right) + 1;
    }
}
