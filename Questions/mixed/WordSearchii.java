import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by naiveCode on 17/2/16.
 */
public class WordSearchii {
    class Node {
        Node[] children;
        char data;
        boolean isLeaf;
        int numberOfChildren;

        Node(char d) {
            data = d;
            children = new Node[26];
            isLeaf = false;
            numberOfChildren = 0;
        }
    }


    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node('_');

        ans = new LinkedList<>();
        ansSet = new HashSet<>();
        createTrie(words, root);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                StringBuilder b = new StringBuilder();
                boolean[][] isVisited = new boolean[board.length][board[0].length];
                int d = board[i][j] - 'a';
                if (root.children[d] != null)
                    findList(i, j, root.children[d], board, b, isVisited);
            }
        }
        ans.addAll(ansSet);


        return ans;
    }

    private void createTrie(String[] words, Node root) {

        for (int i = 0; i < words.length; i++) {
            Node t = root;
            char[] s = words[i].toCharArray();
            for (int j = 0; j < words[i].length(); j++) {
                if (t.children[s[j] - 'a'] == null) {
                    t.children[s[j] - 'a'] = new Node(s[j]);
                    t.numberOfChildren++;
                } else {
                    t.numberOfChildren++;
                }
                t = t.children[s[j] - 'a'];
            }
            t.isLeaf = true;
            t.numberOfChildren++;
        }
    }

    static int[][] nextEl = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static List<String> ans;
    static Set<String> ansSet;

    private boolean findList(int i, int j, Node root, char[][] board, StringBuilder stringTillNow, boolean[][] isVisited) {
        if (root == null) {
            return false;
        }
        if (root.isLeaf) {
            StringBuilder temp = new StringBuilder();
            temp.append(stringTillNow);
            ansSet.add(temp.append(root.data).toString());
        }
        isVisited[i][j] = true;
        boolean somePathFound = false;
        for (int k = 0; k < 4; k++) {
            StringBuilder temp = new StringBuilder();
            int s = i + nextEl[k][0];
            int t = j + nextEl[k][1];
            temp.append(stringTillNow);
            if (checkIfInBoundaries(s, t, board.length, board[0].length) && root.numberOfChildren > 0 && !isVisited[s][t]) {
                char c = board[s][t];
                Node p = root.children[c - 'a'];
                if (p != null && p.numberOfChildren > 0) {
                    boolean pathFound = findList(s, t, p, board, temp.append(root.data), isVisited);
                    if (pathFound) {
                        root.children[c - 'a'].numberOfChildren--;
                    }
                    somePathFound |= pathFound;
                }

            }
        }
        isVisited[i][j] = false;
        return somePathFound;

    }

    private boolean checkIfInBoundaries(int i, int j, int rowSize, int colSize) {
        boolean ans = true;
        if (i >= rowSize || i < 0) {
            ans = false;
        }
        if (j >= colSize || j < 0) {
            ans = false;
        }
        return ans;
    }


}
