import java.util.ArrayList;

public class CoinChange2 {
    public int coinchange2(ArrayList<Integer> a, int b) {
        int[][] dp = new int[b][b];
        return count(a, a.size(), b);


    }

    int count(ArrayList<Integer> S, int m, int n) {
        int[][] table = new int[n + 1][m];
        for (int i = 0; i < m; i++) {
            table[0][i] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                int x = (i - S.get(j) >= 0) ? table[i - S.get(j)][j] : 0;
                int y = (j >= 1) ? table[i][j - 1] : 0;
                table[i][j] = (x + y) % 1000007;
            }
        }
        return table[n][m-1];

    }
//    {
//        int i, j, x, y;
//
//        // We need n+1 rows as the table is consturcted in bottom up manner using
//        // the base case 0 value case (n = 0)
//        int[][] table= new int[n+1][m];
//
//        // Fill the enteries for 0 value case (n = 0)
//        for (i=0; i<m; i++)
//            table[0][i] = 1;
//
//        // Fill rest of the table enteries in bottom up manner
//        for (i = 1; i < n+1; i++)
//        {
//            for (j = 0; j < m; j++)
//            {
//                // Count of solutions including S[j]
//                x = (i-S.get(j) >= 0)? table[i - S.get(j)][j]: 0;
//
//                // Count of solutions excluding S[j]
//                y = (j >= 1)? table[i][j-1]: 0;
//
//                // total count
//                table[i][j] = (x + y) % 1000007;
//            }
//        }
//        return table[n][m-1] % 1000007;
//    }
}
