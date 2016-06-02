/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricBinaryTree {
    public int isSymmetric(TreeNode a) {
        if(a==null){
            return 1;
        }
        return symUtil(a.left,a.right);
    }

    private int symUtil(TreeNode left, TreeNode right) {
        if(left==null && right==null){
            return 1;
        }
        if (left ==null || right==null){
            return 0;
        }
        if(left.val==right.val){
            return (symUtil(left.left,right.right) & symUtil(left.right,right.left));
        }else return 0;
    }
}
