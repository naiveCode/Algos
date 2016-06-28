import java.util.LinkedList;
import java.util.List;

/**
 * Created by naiveCode on 22/2/16.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[][] charPresent = new int[strs.length][26];
        for (int i=0;i<strs.length;i++){
            char[]d = strs[i].toCharArray();
            for (int j=0;j<d.length;j++)
            charPresent[i][d[j]]++;
        }
        return null;

    }
}
