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
public class CartesianBinaryTreeFroInorderOfCartesianTree {
    public TreeNode buildTree(ArrayList<Integer> a) {
        return buildTreeUtil(0, a.size() - 1, a);
    }

    private TreeNode buildTreeUtil(int start, int end, ArrayList<Integer> inorder) {
        if (start > end) {
            return null;
        }

        /* Find index of the maximum element from Binary Tree */
        int i = max(inorder, start, end);

        /* Pick the maximum value and make it root */
        TreeNode node = new TreeNode(inorder.get(i));

        /* If this is the only element in inorder[start..end],
         then return it */
        if (start == end) {
            return node;
        }

        /* Using index in Inorder traversal, construct left and
         right subtress */
        node.left = buildTreeUtil(start, i - 1, inorder);
        node.right = buildTreeUtil(i + 1, end, inorder);

        return node;
    }

    private int max(ArrayList<Integer> inorder, int start, int end) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = start; i <= end; i++) {
            if (max < inorder.get(i)) {
                max = inorder.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
