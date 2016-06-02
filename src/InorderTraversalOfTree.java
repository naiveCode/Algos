import java.util.ArrayList;

/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class InorderTraversalOfTree {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        TreeNode current = root;
        ArrayList<Integer> ans = new ArrayList<>();
        while (current != null) {
            if (current.left == null) {
                ans.add(current.val);
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
                    ans.add(current.val);
                    inorderPredecessor.right = null;
                    current = current.right;
                }
            }
        }
        return ans;
    }


}
