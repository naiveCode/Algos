/**
 * Created by naiveCode on 4/1/16.
 */
public class PathSum {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public boolean hasPathSum(TreeNode root, int sum) {
        int currSum = 0;
        return findSum(root,currSum,sum);
    }

    private boolean findSum(TreeNode root, int currSum, int sum) {
        if(root == null){
            return false;
        }
        currSum += root.val;
        if(currSum == sum){
            return true;
        }else return (findSum(root.left,currSum,sum)||findSum(root.right,currSum,sum));

    }
}
