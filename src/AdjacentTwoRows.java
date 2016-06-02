import java.util.ArrayList;


public class AdjacentTwoRows {

    public int adjacent(ArrayList<ArrayList<Integer>> a) {
        if (a.size() == 0 || a.get(0).size() == 0) {
            return 0;
        }
        // initialize
        int cols = a.get(0).size();
        int offset = 3;
        int[] dp = new int[cols + offset];
        int result = 0;

        // dp
        for (int i = 0; i < cols; i++) {
            int max = Math.max(a.get(0).get(i), a.get(1).get(i));
            int count = max + Math.max(dp[i], dp[i + 1]);
            dp[i + offset] = count;
            result = Math.max(count, result);
        }
        return result;
    }

}