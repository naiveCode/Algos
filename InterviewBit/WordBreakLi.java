import java.util.*;

public class WordBreakLi {
    public static ArrayList<String> wordBreak(String s, ArrayList<String> b) {
        HashSet<String> dict = new HashSet<>();
        for (int i = 0;i<b.size();i++){
            dict.add(b.get(i));
        }
        //create an array of ArrayList<String>
        ArrayList<String> dp[] = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<String>();

        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == null)
                continue;

            for (String word : dict) {
                int len = word.length();
                int end = i + len;
                if (end > s.length())
                    continue;

                if (s.substring(i, end).equals(word)) {
                    if (dp[end] == null) {
                        dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);
                }
            }
        }

        ArrayList<String> result = new ArrayList<>();
        if (dp[s.length()] == null)
            return result;

        ArrayList<String> temp = new ArrayList<String>();
        dfs(dp, s.length(), result, temp);
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        return result;
    }

    public static void dfs(ArrayList<String> dp[], int end, List<String> result, ArrayList<String> tmp) {
        if (end == 0) {
            StringBuilder path = new StringBuilder();
            path.append(tmp.get(tmp.size()-1));
            for (int i = tmp.size() - 2; i >= 0; i--) {
                path.append(" " + tmp.get(i));
            }

            result.add(path.toString());
            return;
        }

        for (String str : dp[end]) {
            tmp.add(str);
            dfs(dp, end - str.length(), result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        WordBreakLi s = new WordBreakLi();

        String p = "aaabaaaaab";
        ArrayList<String> t = new ArrayList<>();
        String[] l = {"aabbbaaa", "aaba", "a", "b", "a", "babbbabb", "baaaab"};
        for (int i = 0; i < l.length; i++) {
            t.add(l[i]);
        }
        System.out.println(s.wordBreak(p, t));
//        ArrayList<String> n = s.wordBreak(p, t);
//        for (int i=0;i<n.size();i++){
//            System.out.println(n.get(i));
//        }
    }
}
