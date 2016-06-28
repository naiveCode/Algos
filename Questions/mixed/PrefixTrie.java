import java.util.ArrayList;

public class PrefixTrie {
    public ArrayList<String> prefix(ArrayList<String> a) {
        TrieNode root = new TrieNode();
        TrieNode curr = root;
        for (String b : a) {
            curr = root;
            for (char c : b.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr.children[c - 'a'].pathBelow++;
                curr = curr.children[c - 'a'];

            }
        }
        ArrayList<String> ans = new ArrayList<>();
        for (String b:a){
            curr =root;
            StringBuilder d = new StringBuilder();
            for (char c : b.toCharArray()) {
                d.append(c);
                if (curr.children[c - 'a'].pathBelow == 1) {
                    break;
                }
                curr = curr.children[c-'a'];

            }
            ans.add(d.toString());
        }
        return ans;
    }

    class TrieNode {
        TrieNode[] children;
        int pathBelow;
        TrieNode() {
            children = new TrieNode[26];
            pathBelow = 0;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static void main(String[] args) {
        PrefixTrie s = new PrefixTrie();
        ArrayList<String> d = new ArrayList<>();
        d.add("zebra");
        d.add("dog");
        d.add("duck");
        d.add("dove");
        System.out.println(s.prefix(d));
    }
}
