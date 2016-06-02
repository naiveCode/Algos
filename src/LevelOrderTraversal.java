import java.util.LinkedList;
import java.util.List;



public class LevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> thisLevelNodes = new LinkedList<>();
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            //Empty one full level
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                thisLevelNodes.add(curr.val);
                if(curr.left != null ){ nextLevel.add(curr.left);}
                if(curr.right != null) { nextLevel.add(curr.right);}
            }
            ans.add(0,thisLevelNodes);
            queue=nextLevel;
        }


        return ans;
    }


}