import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTree {
    public TreeNode flatten(TreeNode a) {
        TreeNode result = new TreeNode(0);
        TreeNode node = result;
        result.right = node;
        if(a == null)
            return null;

        Stack<TreeNode> stack =  new Stack<TreeNode>();
        stack.push(a);
        while(!stack.isEmpty()){
            TreeNode popped = stack.pop();

            node.right = popped;
            node.left = null;
            node = node.right;

            if(popped.right != null)
                stack.push(popped.right);
            if(popped.left != null)
                stack.push(popped.left);
        }
        return result.right;

    }
}
