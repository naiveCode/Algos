import java.util.ArrayList;

public class MinimumSumInATriangle {
    int min = Integer.MAX_VALUE;

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int[] minPath = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            minPath[i] = a.get(a.size() - 1).get(i);
        }
        for (int row = a.size() - 2; row >= 0; row--) {
            for (int i=0;i<=row;i++){
                minPath[i] = a.get(row).get(i) + Math.min(minPath[i],minPath[i+1]);
            }
        }
        return minPath[0];

//        int row = 0, col = 0;
//        dp = new int[a.size()][a.size()];
//        for (int i = 0; i < a.size(); i++) {
//            for (int j = 0; j <= i; j++) {
//                dp[i][j] = -1;
//            }
//        }
//        return minimumTotalHelperNotWorking(a, row, col, 0);

    }

    int dp[][];

    private int minimumTotalHelperNotWorking(ArrayList<ArrayList<Integer>> a, int row, int col, int sum) {
        if (row >= a.size()) {
            return sum;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int left;
        left = minimumTotalHelperNotWorking(a, row + 1, col, sum + a.get(row).get(col));
        int right;
        right = minimumTotalHelperNotWorking(a, row + 1, col + 1, sum + a.get(row).get(col));


        dp[row][col] = Math.min(left, right);
        return dp[row][col];
    }

    public static void main(String[] args) {
        MinimumSumInATriangle s = new MinimumSumInATriangle();
        ArrayList<ArrayList<Integer>> da = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        t.add(2);
        da.add(t);
        System.out.println(t);
        t = new ArrayList<>();
        t.clear();
        t.add(6);
        t.add(6);
        da.add(1, t);
        System.out.println(t);
        t = new ArrayList<>();
        t.clear();
        t.add(7);
        t.add(8);
        t.add(4);
        da.add(2, t);
        System.out.println(t);
        System.out.println(s.minimumTotal(da));
    }
}
