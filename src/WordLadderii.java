import java.util.*;

/**
 * Created by naiveCode on 13/2/16.
 */
public class WordLadderii {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        return findTheLadder(beginWord, endWord, wordList);
    }

    private List<List<String>> findTheLadder(String beginWord, String endWord, Set<String> wordList) {
        Node root = new Node(beginWord);
        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }
        if (!wordList.contains(endWord)) {
            wordList.add(endWord);
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Node> solNode = new LinkedList<>();
        boolean contentFound = false;
        while (!queue.isEmpty()) {
            Set<Node> temp = new HashSet<>();
            HashMap<String, Node> mapping = new HashMap<>();
            Set<String> removeList = new HashSet<>();
            while (!queue.isEmpty()) {

                root = queue.poll();
                beginWord = root.data;
                for (int i = 0; i < beginWord.length(); i++) {
                    for (int j = 0; j < 25; j++) {
                        StringBuilder b = new StringBuilder();
                        char charToAdd = (char) ('a' + j);
                        if (beginWord.charAt(i) != charToAdd) {
                            if (i > 0) {
                                b.append(beginWord.substring(0, i));
                            }
                            b.append(charToAdd);
                            if (i < beginWord.length()) {
                                b.append(beginWord.substring(i + 1, beginWord.length()));
                            }
                            String stringToCheck = b.toString();
                            if (wordList.contains(stringToCheck)) {
                                if (!stringToCheck.contentEquals(endWord)) {
                                    removeList.add(stringToCheck);
                                    if (mapping.containsKey(stringToCheck)) {
                                        mapping.get(stringToCheck).parent.add(root);
                                    } else {
                                        Node a = new Node(stringToCheck);
                                        a.parent.add(root);
                                        mapping.put(stringToCheck, a);
                                        temp.add(a);
                                    }
                                } else {
                                    if (mapping.containsKey(endWord)) {
                                        mapping.get(endWord).parent.add(root);
                                    } else {

                                        Node a = new Node(endWord);
                                        a.parent.add(root);
                                        solNode.add(a);
                                        mapping.put(endWord, a);
                                        contentFound = true;

                                    }
                                }
                            }
                        }
                    }
                }
            }
            wordList.removeAll(removeList);
            if (!contentFound) {
                queue.addAll(temp);
            }
        }


        LinkedList<String> s = new LinkedList<>();
        ans = new LinkedList<>();
        if (solNode.size() != 0) {
            getSolutionPaths(solNode.get(0), s);
        }


        return ans;
    }

    List<List<String>> ans;

    private void getSolutionPaths(Node solNode, LinkedList<String> s) {

        if (solNode.parent.size() == 0) {
            s.add(0, solNode.data);
            ans.add(s);
            return;
        }

        for (int i = 0; i < solNode.parent.size(); i++) {
            LinkedList<String> t = new LinkedList<>();
            t.addAll(s);
            t.add(0, solNode.data);
            getSolutionPaths(solNode.parent.get(i), t);
        }

    }

    class Node {
        String data;
        //        LinkedList<Node> neighbours;
        LinkedList<Node> parent;

        Node(String d) {
            data = d;
//            neighbours = new LinkedList<>();
            parent = new LinkedList<>();
        }
    }

//    public static void main(String[] args) {
//        WordLadderii a = new WordLadderii();
//        Set<String> s = new HashSet<>();
//        String beginWord = "hot", endWord = "dog";
//        String[] arr = new String[]{"hot", "dog", "dot","hog"};
//        System.out.println("Length is " + arr.length);
//        Collections.addAll(s, arr);
//        List<List<String>> l = a.findLadders(beginWord, endWord, s);
//        System.out.println("Break here");
//    }
}
