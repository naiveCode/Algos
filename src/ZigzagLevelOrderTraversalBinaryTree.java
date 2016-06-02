import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class ZigzagLevelOrderTraversalBinaryTree {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        boolean isLeft = false;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(a);
        while (!q.isEmpty()) {
            ArrayList<Integer> tempArray = new ArrayList<>();
            Deque<TreeNode> temp = new ArrayDeque<>();
            while (!q.isEmpty()) {
                TreeNode curr;
                if (isLeft) {
                    curr = q.removeFirst();
                    if (curr.left != null)
                        temp.addLast(curr.left);
                    if (curr.right != null)
                        temp.addLast(curr.right);

                } else {
                    curr = q.removeLast();
                    if (curr.right != null)
                        temp.addFirst(curr.right);
                    if (curr.left != null)
                        temp.addFirst(curr.left);

                }
                tempArray.add(curr.val);

            }
            ans.add(tempArray);
            q.addAll(temp);
            isLeft = !isLeft;
        }
        return ans;
    }
}
