/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class SumNumbersOnPathBinaryTree {

    int sum;

    public int sumNumbers(TreeNode a) {
        sum = 0;
        if (a == null) {
            return 0;
        }
        sumUtil(a, 0);
        return sum;
    }

    private void sumUtil(TreeNode a, int s) {
        if (a == null) {
            return;
        }
        if (a.right == null && a.left == null) {
            sum = (sum + (s * 10 + a.val)) % 1003;
            return;
        }
        sumUtil(a.left, (s * 10 + a.val)%1003);
        sumUtil(a.right, (s * 10 + a.val)%1003);
    }
}
