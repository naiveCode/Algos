import java.util.ArrayList;

/**
 * Created by naiveCode on 8/5/16.
 */
public class RodCutUnableToSolve {
    public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
        B.add(0, 0);
        B.add(B.size(), A);

        dp = new int[B.size() + 1][B.size() + 1];
        ans = new ArrayList<>();
        System.out.println(computeMinCost(B, 0, B.size()-1));
        return ans;
    }
    int dp[][];
    ArrayList<Integer> ans;
    private int computeMinCost(ArrayList<Integer> b, int i, int j) {
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int k = i + 1; k < j ; k++) {
            int cost = b.get(j) - b.get(i) + computeMinCost(b, i, k) + computeMinCost(b, k, j);
            if(cost<min){
                min = cost;
                minIndex = k;
            }
        }

        ans.add(b.get(minIndex));
        dp[i][j] = min;
        return dp[i][j];

    }

    public static void main(String[] args) {
        RodCutUnableToSolve s = new RodCutUnableToSolve();
        int A = 6;
        ArrayList<Integer> p = new ArrayList<>();
        p.add(1);
        p.add(2);
        p.add(5);
        System.out.println(s.rodCut(A, p));
    }
}
