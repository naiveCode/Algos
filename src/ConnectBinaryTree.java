import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectBinaryTree {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        q.add(root);
        while (!q.isEmpty()) {
            Queue<TreeLinkNode> temp = new ArrayDeque<>();
            while (!q.isEmpty()) {
                TreeLinkNode t = q.poll();
                TreeLinkNode s = null;
                if (!q.isEmpty())
                    s = q.peek();
                t.next = s;
                if (t.left != null) {
                    temp.add(t.left);
                }
                if (t.right != null) {
                    temp.add(t.right);
                }
            }
            q.addAll(temp);
        }

    }


    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
