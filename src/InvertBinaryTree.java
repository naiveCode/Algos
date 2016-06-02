/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        invertUtil(root,root.left,root.right);
        return root;
    }

    private void invertUtil(TreeNode root, TreeNode left, TreeNode right) {
        if(root==null){
            return;
        }
        TreeNode temp = right;
        root.right = left;
        root.left = temp;
        if(root.right!=null){
            invertUtil(root.right,root.right.left,root.right.right);
        }
        if(root.left!=null){
            invertUtil(root.left,root.left.left,root.left.right);
        }


    }
}
