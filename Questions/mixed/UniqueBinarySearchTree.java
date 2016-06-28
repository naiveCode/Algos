import java.util.LinkedList;
import java.util.List;

/**
 * Created by naiveCode on 3/2/16.
 */
public class UniqueBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public List<TreeNode> generateTrees(int n) {

        int[] G = new int[n + 1];
        List<TreeNode> ans = new LinkedList<>();

        G[0] = G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                TreeNode t = new TreeNode(G[i]);
            }
        }
        return null;


    }

    public static void main(String[] args) {
        UniqueBinarySearchTree u = new UniqueBinarySearchTree();
        for (int i = 1; i < 5; i++)
            System.out.println(u.numTrees(i));
    }
}
