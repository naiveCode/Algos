import java.util.ArrayList;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PrintPathsWithSumTree {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        utilPathSum(root,sum,0,path,ans);
        return ans;
    }
    private boolean utilPathSum(TreeNode a, int b, int c, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans) {
        ArrayList<Integer> temp = new ArrayList<>(path);
        if (a != null) {
            if (b == c + a.val && a.left == null && a.right == null) {
                temp.add(a.val);
                ans.add(temp);
                return true;
            }
            temp.add(a.val);

            return (utilPathSum(a.left, b, c + a.val, temp, ans) | utilPathSum(a.right, b, c + a.val, temp, ans));

        } else {
            return false;
        }
    }
}
