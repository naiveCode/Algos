public class GetSuccessorInABST {
    public TreeNode getSuccessor(TreeNode root, int b) {
        TreeNode res = null;
        while(root!=null) {
            if(root.val > b) {
                res = root;
                root = root.left;
            }
            else root = root.right;
        }
        return res;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
