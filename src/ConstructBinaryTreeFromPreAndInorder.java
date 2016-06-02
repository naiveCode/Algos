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
public class ConstructBinaryTreeFromPreAndInorder {
    //    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
//        if (preorder == null) {
//            return null;
//        }
//        TreeNode root = buildTreeUtil(0,preorder.size()-1, preorder, inorder, 0, inorder.size() - 1);
//        return root;
//
//    }
//
//    private TreeNode buildTreeUtil(int index, int rPre, ArrayList<Integer> pre, ArrayList<Integer> ino, int left, int right) {
//
//        if (left > right && (index < 0 || index >= pre.size())) {
//            return null;
//        }
//        int rootData = pre.get(index);
//        int mid = 0;
//        for (int i = left; i <= right; i++) {
//            if (ino.get(i) == rootData) {
//                mid = i;
//                break;
//            }
//        }
//        TreeNode t = new TreeNode(rootData);
//        t.left = buildTreeUtil(index + 1, preorder.size() - 1, pre, ino, left, mid - 1);
//        t.right = buildTreeUtil(mid - left + 1, preorder.size() - 1, pre, ino, mid + 1, right);
//        return t;
//
//    }
//
//    public static void main(String[] args) {
//        ConstructBinaryTreeFromPreAndInorder s = new ConstructBinaryTreeFromPreAndInorder();
//        ArrayList<Integer> pre = new ArrayList<>();
//        pre.add(1);
//        pre.add(2);
//        pre.add(3);
//        ArrayList<Integer> ino = new ArrayList<>();
//        ino.add(2);
//        ino.add(1);
//        ino.add(3);
//
//        TreeNode root = s.buildTree(pre, ino);
//        print(root, 0);
//    }
//
//    private static void print(TreeNode t, int i) {
//
//        if (t != null) {
//            print(t.left, i + 1);
//            System.out.println(i + " -> " + t.val);
//            print(t.right, i + 1);
//        }
//
//    }
    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        int preStart = 0;
        int preEnd = preorder.size() - 1;
        int inStart = 0;
        int inEnd = inorder.size() - 1;

        return construct(preorder, preStart, inorder, inStart, inEnd);
    }

    public TreeNode construct(ArrayList<Integer> preorder, int preStart, ArrayList<Integer> inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int val = preorder.get(preStart);
        TreeNode p = new TreeNode(val);

        //find parent element index from inorder
        int k = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (val == inorder.get(i)) {
                k = i;
                break;
            }
        }

        p.left = construct(preorder, preStart + 1, inorder, inStart, k - 1);
        p.right = construct(preorder, preStart + (k - inStart) + 1, inorder, k + 1, inEnd);

        return p;
    }
}
