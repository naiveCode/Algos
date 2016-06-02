/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class ValidBST {
    public int isValidBST(TreeNode a) {
        if (isSubtreeProper(a, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return 1;
        }
        return 0;
    }

    private boolean isSubtreeProper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < max && root.val > min
                && isSubtreeProper(root.left, min, root.val)
                && isSubtreeProper(root.right, root.val, max)) {
            return true;
        }
        return false;


    }
}
