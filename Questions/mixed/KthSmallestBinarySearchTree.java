/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallestBinarySearchTree {
    public int kthsmallest(TreeNode root, int k) {
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                k--;
                if (k == 0)
                    return current.val;
                current = current.right;
            } else {
                TreeNode inorderPredecessor = current.left;
                while (inorderPredecessor.right != null && inorderPredecessor.right != current) {
                    inorderPredecessor = inorderPredecessor.right;
                }
                if (inorderPredecessor.right == null) {
                    inorderPredecessor.right = current;
                    current = current.left;
                } else {
                    k--;
                    if (k == 0) {
                        return current.val;
                    }
                    inorderPredecessor.right = null;
                    current = current.right;
                }
            }
        }
        return -1;

    }
}
