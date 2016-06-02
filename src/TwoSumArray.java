import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TwoSumArray {
    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (numberMap.containsKey(a.get(i))) {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(i);
                t.add(numberMap.get(a.get(i)));
                numberMap.put(b - a.get(i), i);
                sol.add(t);
            } else {
                if(!numberMap.containsKey(b-a.get(i))){
                    numberMap.put(b - a.get(i), i);
                }

//                numberMap.put(a.get(i)-b,i);
            }
        }
        if (sol.size() == 0) {
            return new ArrayList<>();
        }
        int index1 = Integer.MAX_VALUE, index2 = Integer.MAX_VALUE;
        for (int i = 0; i < sol.size(); i++) {
            ArrayList<Integer> t = sol.get(i);
            int i2 = t.get(0);
            int i1 = t.get(1);
            if (i2 < index2 || (index2 == i2 && i1 < index1)) {
                index2 = i2;
                index1 = i1;
            }
        }
        ArrayList<Integer> an = new ArrayList<>();
        an.add(index1 + 1);
        an.add(index2 + 1);
        return an;
    }

    public static void main(String[] args) {
        TwoSumArray s = new TwoSumArray();
        int b = -3;
        List<Integer> a = new LinkedList<>();
        int []d = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        for (int i=0;i<d.length;i++){
            a.add(d[i]);
        }

        System.out.println(s.twoSum(a,b));
    }
}
