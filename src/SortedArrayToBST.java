import java.util.LinkedList;
import java.util.List;

/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        TreeNode root;
        if (a == null) {
            return null;
        }
        int left = 0;
        int right = a.size() - 1;

        root = sortedArrayToBSTUtil(a, left, right);

        return root;
    }

    private TreeNode sortedArrayToBSTUtil(List<Integer> a, int left, int right) {

        if(left>right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode t = new TreeNode(a.get(mid));
        t.left = sortedArrayToBSTUtil(a,left,mid-1);
        t.right = sortedArrayToBSTUtil(a,mid+1,right);
        return t;

    }

    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        SortedArrayToBST s = new SortedArrayToBST();
        TreeNode t = s.sortedArrayToBST(l);
        if (t != null) {
            print(t,0);
        }

    }

    private static void print(TreeNode t, int i) {

        if (t != null) {
            print(t.left, i+1);
            System.out.println(i + " -> " + t.val);
            print(t.right, i+1);
        }

    }
}

