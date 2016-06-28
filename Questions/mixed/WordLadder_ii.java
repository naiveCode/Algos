import java.util.*;

public class WordLadder_ii {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        boolean[] visited = new boolean[wordList.size() + 1];
        return findTheLadder(beginWord, endWord, wordList, visited);


    }

    private List<List<String>> findTheLadder(String beginWord, String endWord, Set<String> wordList, boolean[] visited) {

        int[] distanceMatrix = new int[wordList.size()];
        int[] indexReachedFrom = new int[wordList.size()];
        LinkedList<Integer> indexQueue = new LinkedList<Integer>();
        LinkedList<Integer> finalPointReachingQueue = new LinkedList<>();
        String start = beginWord;

        String[] strSet = new String[wordList.size()];
        if(wordList.contains(beginWord)){
            wordList.remove(beginWord);
        }
        if (!wordList.contains(endWord)) {
            wordList.add(endWord);
            strSet = new String[wordList.size() + 1];

            distanceMatrix = new int[wordList.size() + 1];
            indexReachedFrom = new int[wordList.size() + 1];
        }

        wordList.toArray(strSet);
        int index = -1;
        LinkedList<String> queue = new LinkedList<>();
        queue.add(start);
        boolean endFound = false;
        List<List<String>> a = new LinkedList<>();
        LinkedList<String> ans = new LinkedList<>();
        ans.add(start);

        boolean lastEnd = false;

        while (!queue.isEmpty()) {
//            System.out.println("start is " + start);
            LinkedList<String> tempQueue = new LinkedList<>();

//            tempQueue.add(s);
            while (!queue.isEmpty()) {

                start = queue.poll();

                for (int j = 0; j < strSet.length; j++) {
                    String w = strSet[j];

                    int d = 0;
                    if (visited[j]) {
                        distanceMatrix[j] = d;
                        continue;
                    }

                    for (int i = 0; i < start.length(); i++) {
                        if (Math.abs(start.charAt(i) - w.charAt(i)) != 0) {
                            d += 1;
                        }
                    }
                    distanceMatrix[j] = d;
                    if (d == 1) {
                        indexQueue.add(j);
                        if (!endWord.contentEquals(strSet[j])) {
                            visited[j] = true;
                            tempQueue.add(strSet[j]);

                        }
                        indexReachedFrom[j] = index;


//                        System.out.println("distance 1 at " + j);
                        if (w.contentEquals(endWord)) {
                            endFound = true;
                            finalPointReachingQueue.add(index);
//                            System.out.println("found at ");
                        }


                    }
                }
                if(indexQueue.size()==0){
                    return null;
                }
                index = indexQueue.poll();
            }
            if (!lastEnd) {
                if (endFound) {
                    queue.addAll(tempQueue);
                    lastEnd = true;
                } else {
                    queue.addAll(tempQueue);
                }
            }

        }
        while (!finalPointReachingQueue.isEmpty()) {
            ans = new LinkedList<>();
            ans.add(beginWord);
            int p = finalPointReachingQueue.poll();
            if(p==-1){
                ans.add(ans.size(), endWord);
            }else {
                ans.add(ans.size(), strSet[p]);
                while (indexReachedFrom[p] != -1) {
                    p = indexReachedFrom[p];
                    ans.add(1, strSet[p]);
                }
                ans.add(ans.size(), endWord);
            }

            a.add(ans);
        }
        return a;

    }

    public static void main(String[] args) {
        WordLadder_ii a = new WordLadder_ii();
//        String beginWord = "hit";
//        String endWord = "cog";
//        Set<String> wordList = new HashSet<>();
//        boolean b = Collections.addAll(wordList, new String[]{"hot", "dot", "dog", "lot", "log"});
//
        String beginWord = "a";
        String endWord = "c";
        Set<String> wordList = new HashSet<>();
        boolean b = Collections.addAll(wordList, new String[]{"a", "b", "c"});

        a.findLadders(beginWord, endWord, wordList);
    }

}