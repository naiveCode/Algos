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
public class PostOrderInorderBTFormation {
    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        int postStart = 0;
        int postEnd = postorder.size() - 1;
        int inStart = 0;
        int inEnd = inorder.size() - 1;

        return construct(postorder, postStart, postEnd, inorder, inStart, inEnd);
    }

    public TreeNode construct(ArrayList<Integer> postOrder, int postStart, int postEnd, ArrayList<Integer> inorder, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        int val = postOrder.get(postEnd);
        TreeNode p = new TreeNode(val);

        //find parent element index from inorder
        int k = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (val == inorder.get(i)) {
                k = i;
                break;
            }
        }
        p.left = construct( postOrder, postStart,
                postStart + k - (inStart + 1),inorder, inStart, k - 1);
        // Becuase k is not the length, it it need to -(inStart+1) to get the length
        p.right = construct( postOrder, postStart + k- inStart, postEnd - 1,inorder, k + 1, inEnd);
        // postStart+k-inStart = postStart+k-(inStart+1) +1


        return p;
    }
}
