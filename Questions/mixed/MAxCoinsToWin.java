import java.util.ArrayList;

public class MAxCoinsToWin {
    public int maxcoin(ArrayList<Integer> arr) {

        int table[][] = new int[arr.size()][arr.size()];
        int gap, i, j, x, y, z;

        for (gap = 0; gap < arr.size(); ++gap)
        {
            for (i = 0, j = gap; j < arr.size(); ++i, ++j)
            {
                x = ((i+2) <= j) ? table[i+2][j] : 0;
                y = ((i+1) <= (j-1)) ? table[i+1][j-1] : 0;
                z = (i <= (j-2))? table[i][j-2]: 0;

                table[i][j] = Math.max(arr.get(i) + Math.min(x, y), arr.get(j) + Math.min(y, z));
            }
        }

        return table[0][arr.size()-1];
//        return utilSlow(a, l, r);
    }

    int dp[][];

    private int utilSlow(ArrayList<Integer> a, int l, int r) {

        if (l >= r) {
            return 0;
        }
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        int chooseLeft = a.get(l);
        if (a.get(l + 1) > a.get(r)) {
            chooseLeft += utilSlow(a, l + 2, r);
        } else {
            chooseLeft += utilSlow(a, l + 1, r - 1);
        }

        int chooseRight = a.get(r);
        if (a.get(l) > a.get(r - 1)) {
            chooseRight += utilSlow(a, l + 1, r - 1);
        } else {
            chooseRight += utilSlow(a, l, r - 2);
        }
        dp[l][r] = Math.max(chooseLeft, chooseRight);
        return dp[l][r];
    }
}
