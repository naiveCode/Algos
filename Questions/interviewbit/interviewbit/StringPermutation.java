package interviewbit;

/**
 * Created by naiveCode on 13/7/16.
 */
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> input) {
        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int integer : input) {
            countMap.compute(integer, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        int str[] = new int[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        int result[] = new int[input.size()];
        permuteUtil(str, count, result, 0, resultList);
        return resultList;
    }

    public void permuteUtil(int str[], int count[], int[] result, int level, ArrayList<ArrayList<Integer>> resultList) {
        if (level == result.length) {
            ArrayList<Integer> t = new ArrayList<>();
            for (int p:result){
                t.add(p);
            }
            resultList.add(t);
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1, resultList);
            count[i]++;
        }
    }


}
