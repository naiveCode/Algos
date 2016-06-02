import java.util.ArrayList;
import java.util.HashMap;

public class LargestZeroSumInArray {
    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int start = -1;
        int end = -1;
        int sum = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);

            if (map.get(sum) != null) {
                if (maxLength < (i - map.get(sum))) {
                    start = map.get(sum) + 1;
                    end = i;
                    maxLength = i - map.get(sum);
//                    System.out.printf("start = %d, end = %d, maxLength = %d \n", start, end, maxLength);

                }

            } else
                map.put(sum, i);
        }

        if (start >= 0 && end >= 0) {
            for (int i = start; i <= end; i++) {
                result.add(A.get(i));
            }
        }
        return result;
    }
}
