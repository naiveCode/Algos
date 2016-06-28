import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumClosest {

    public int threeSumClosest(ArrayList<Integer> a, int b) {

        Collections.sort(a);

        int min = Integer.MAX_VALUE;

        int result = 0;

        for (int i = 0; i < a.size(); i++) {

            int j = i + 1;

            int k = a.size() - 1;


            while (j < k) {

                int sum = a.get(i) + a.get(j) + a.get(k);

                int diff = Math.abs(sum - b);

                if (diff == 0) return sum;

                if (diff < min) {

                    min = diff;

                    result = sum;

                }

                if (sum > b) k--;

                else if (sum < b) j++;

            }


        }

        return result;

    }


}