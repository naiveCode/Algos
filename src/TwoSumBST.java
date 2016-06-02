import java.util.Stack;

/**
 * Created by naiveCode on 22/4/16.
 */
public class TwoSumBST {
    private Stack<TreeNode> increasingStack;
    private Stack<TreeNode> decreasingStack;

    public int t2Sum(TreeNode A, int B) {
        if (A == null) {
            return 0;
        }
        getStacks(A);
        int g = 1, s = 0;
        s = nextSmaller();
        g = nextGreater();
        while (s < g) {

            if (s + g > B) {
                if (hasNextGreater()) {
                    g = nextGreater();
                } else {
                    return 0;
                }

            } else if (s + g < B) {
                if (hasNextSmaller()) {
                    s = nextSmaller();
                } else {
                    return 0;
                }
            } else {
                return 1;
            }

        }
        return 0;
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(558);
        TreeNode curr = root;
        curr.left = new TreeNode(134);
        curr.right = new TreeNode(765);
        TreeNode a = curr.left;
        TreeNode b = curr.right;
        a.left = new TreeNode(35);
        a.left.right = new TreeNode(55);
        b.right = new TreeNode(868);
        b.left = new TreeNode(741);
        b.left.left = new TreeNode(729);
        b.left.right = new TreeNode(761);
        TwoSumBST s = new TwoSumBST();
        System.out.println(s.t2Sum(root,253));

    }
}
