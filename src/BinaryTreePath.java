import java.util.LinkedList;
import java.util.List;

/**
 * Created by naiveCode on 8/1/16.
 */
public class BinaryTreePath {
    List<String> ans;

    public List<String> binaryTreePaths(TreeNode root){


        ans = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        if(root==null){
            return ans;
        }
        str.append(root.val);
        if(root.left==null && root.right==null){
            ans.add(str.toString());
        }
        findPaths(str, root.left);
        findPaths(str, root.right);
        return ans;

    }

    private void findPaths(StringBuilder str, TreeNode root) {
        if(root==null){
            return;
        }
        if (root!=null && root.left == null && root.right==null) {
            StringBuilder t = new StringBuilder();
            t.append(str);
            t.append("->"+root.val);
            ans.add(t.toString());
        }else {
            StringBuilder t = new StringBuilder();
            t.append(str);
            t.append("->"+root.val);
            findPaths(t,root.left);
            findPaths(t,root.right);
        }
    }


}
