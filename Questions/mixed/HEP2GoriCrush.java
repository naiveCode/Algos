import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by naiveCode on 23/1/16.
 */
public class HEP2GoriCrush {
    private Node root;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] d = br.readLine().split("\\s");
        int N = Integer.parseInt(d[0]);
        int Q = Integer.parseInt(d[1]);
        int K = Integer.parseInt(d[2]);
        int[] FA = new int[N];
        d = br.readLine().split("\\s");
        for (int i = 0; i < N; i++) {
            FA[i] = Integer.parseInt(d[i]);
        }
        for (int i = 0; i < Q; i++) {
            d = br.readLine().split("\\s");
            switch (d[0].charAt(0)) {
                case '0':
                    FA[Integer.parseInt(d[1]) - 1] = Integer.parseInt(d[2]);
                    break;
                case '1':
                    if (calculateCommonElement(FA, Integer.parseInt(d[1]), Integer.parseInt(d[2]),
                            Integer.parseInt(d[3]), Integer.parseInt(d[4])) >= K) {
                        System.out.println("Propose");
                    } else {
                        System.out.println("Do not propose");
                    }
                    break;
            }
        }
    }

    private static int calculateCommonElement(int[] fa, int l1, int r1, int l2, int r2) {
        int count = 0;
        Arrays.sort(fa);
        int m = Math.max(r1, r2);
        int i;
        for (i = 0; i < fa.length && fa[i] <= m; i++) {
            if (fa[i] >= l1 && fa[i] <= r1 && fa[i] >= l2 && fa[i] <= r2) {
                count++;
            }
        }
        return count;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node temp = root, prev = null;
            char lOrR = 0;
            while (temp != null) {
                if (temp.data > data) {
                    prev = temp;
                    lOrR = '0';
                    temp = temp.left;
                } else {
                    lOrR = '1';
                    prev = temp;
                    temp = temp.right;
                }
            }
            switch (lOrR) {
                case '0':
                    prev.left = new Node(data);
                    break;
                case '1':
                    prev.right = new Node(data);
                    break;
            }

        }
    }

    public void delete(Node r, int data) {
        Node temp = r, prev = null;
        int lOrR = 0;
        while (temp.data != data) {
            if (temp.data > data) {
                lOrR = 0;
                prev = temp;
                temp = temp.left;
            } else {
                lOrR = 1;
                prev = temp;
                temp = temp.right;
            }
        }
        if (temp.left == null && temp.right == null) {
            switch (lOrR) {
                case 0:
                    prev.left = null;
                    break;
                case 1:
                    prev.right = null;
                    break;
            }
            temp = null;
        } else if (temp.left == null) {
            switch (lOrR) {
                case 0:
                    prev.left = temp.right;
                    break;
                case 1:
                    prev.right = temp.right;
                    break;
            }
        } else if (temp.right == null) {
            switch (lOrR) {
                case 0:
                    prev.left = temp.left;
                    break;
                case 1:
                    prev.right = temp.left;
                    break;
            }
        } else {
            int d = temp.data;
            temp.data = temp.right.data;
            temp.right.data = d;
            delete(temp.right, data);
        }
    }

    class Node {
        int data;
        Node left;
        Node right;
        int nodesBelow;

        Node(int d) {
            data = d;
            left = null;
            right = null;
            nodesBelow = 0;
        }
    }

}
