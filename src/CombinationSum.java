import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (candidates == null || candidates.size() == 0) return result;

        ArrayList<Integer> current = new ArrayList<Integer>();
        HashSet<ArrayList<Integer>> numSet = new HashSet<>();
        Collections.sort(candidates);
//        HashSet<Integer> numSet = new HashSet<>();
//        ArrayList<Integer> key = new ArrayList<>();
//        for(Integer a:candidates){
//            if(!numSet.contains(a)){
//                key.add(a);
//                numSet.add(a);
//            }
//        }
//        candidates = key;


        combinationSum(candidates, target, 0, current, result, numSet);

        return result;
    }

    public void combinationSum(ArrayList<Integer> candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result, HashSet<ArrayList<Integer>> numSet) {
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
            if (!numSet.contains(temp)){
                result.add(temp);
                numSet.add(temp);
            }

            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = j; i < candidates.size(); i++) {
            if (target < candidates.get(i))
                return;

            curr.add(candidates.get(i));
            combinationSum(candidates, target - candidates.get(i), i + 1, curr, result, numSet);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum s = new CombinationSum();
        int b = 28;
        ArrayList<Integer> a = new ArrayList<>();
        int[] data = {8, 10, 6, 11, 1, 16, 8};
        for (int i = 0; i < data.length; i++) {
            a.add(data[i]);
        }
        System.out.println(s.combinationSum(a, b));
    }


}
