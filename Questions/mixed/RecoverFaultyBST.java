import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class RecoverFaultyBST {
    private Stack<TreeNode> increasingStack;
    private Stack<TreeNode> decreasingStack;

    public ArrayList<Integer> recoverTree(TreeNode a) {
        getStacks(a);
        ArrayList<Integer> ans = new ArrayList<>();
        int f = nextSmaller();
        int s = nextSmaller();
        while (s>f){
            f=s;
            s = nextSmaller();
        }

        int f1 = nextGreater();
        int s1 = nextGreater();
        while (f1>s1){
            f1 = s1;
            s1 = nextGreater();
        }
        ans.add(f1);
        ans.add(f);





        return ans;
    }
    public void getStacks(TreeNode root) {
        TreeNode curr = root;
        decreasingStack = new Stack<>();
        increasingStack = new Stack<>();
        while (root != null) {
            increasingStack.push(root);
            root = root.left;
        }

        while (curr != null) {
            decreasingStack.push(curr);
            curr = curr.right;
        }
    }

    public boolean hasNextSmaller() {
        return !increasingStack.isEmpty();
    }

    public int nextSmaller() {
        TreeNode node = increasingStack.pop();
        int result = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                increasingStack.push(node);
                node = node.left;
            }
        }
        return result;
    }

    public boolean hasNextGreater() {
        return !decreasingStack.isEmpty();
    }

    public int nextGreater() {
        TreeNode node = decreasingStack.pop();
        int result = node.val;
        if (node.left != null) {
            node = node.left;
            while (node != null) {
                decreasingStack.push(node);
                node = node.right;
            }
        }
        return result;
    }
}
