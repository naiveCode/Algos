import java.util.ArrayList;

public class MinPathSumInArray {
    public int minPathSum(ArrayList<ArrayList<Integer>> a) {
        if (a == null) {
            return 0;
        }
        int[][] cost = new int[a.size()][a.get(0).size()];
        //init first col
        cost[0][0] = a.get(0).get(0);
        for (int i = 1; i < a.size(); i++) {
            cost[i][0] = a.get(i).get(0) + cost[i-1][0];
        }
        //init first Row
        for (int j = 1; j < a.get(0).size(); j++) {
            cost[0][j] = a.get(0).get(j) + cost[0][j-1];
        }
        for (int i = 1; i < a.size(); i++) {
            for (int j = 1; j < a.get(0).size(); j++) {
                cost [i][j] = a.get(i).get(j) + Math.min(cost[i-1][j],cost[i][j-1]);
            }
        }
        return cost[a.size()-1][a.get(0).size()-1];
    }
}
