import java.util.ArrayList;
import java.util.Objects;

/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestor {
    public int lca(TreeNode a, int val1, int val2) {
        ArrayList<Integer> path1 = new ArrayList<Integer>();
        ArrayList<Integer> path2 = new ArrayList<Integer>();
        if(!findPath(a, path1, val1) || !findPath(a, path2, val2))
            return -1;
        int i = 0;
        for(i = 0; i < path1.size() && i < path2.size(); i++){
            if(!Objects.equals(path1.get(i), path2.get(i))){
                break;
            }
        }

            return path1.get(i-1);
    }

    public boolean findPath(TreeNode node, ArrayList<Integer> path, int val){
        if(node == null)
            return false;
        path.add(node.val);
        if(node.val == val)
            return true;
        if((node.left != null && findPath(node.left, path, val) )||
                (node.right != null && findPath(node.right, path, val)))
            return true;
        path.remove(path.size()-1);
        return false;
    }
}
