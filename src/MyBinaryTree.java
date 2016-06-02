import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by naiveCode on 4/1/16.
 */
public class MyBinaryTree {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public int minDepth(TreeNode root) {

        int level = 1;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        if(root == null )
            return 0;
        while (!q.isEmpty()){
            level++;
            Stack<TreeNode> t = new Stack<>();
            while (!q.isEmpty()){
                TreeNode curr = q.poll();
                if (curr != null && curr.left == null && curr.right ==null){
                    return level;
                }
            }

        }
        return level;

    }
}
