public class ArrangeHorses {
    public int arrange(String a, int b) {
        int numOfHorses = a.length();
        if (numOfHorses < b)
            return -1;
        int dp[][] = new int[a.length()][b];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b; j++) {
                dp[i][j] = -1;
            }
        }
        int t = rec(a, 0, b - 1, dp);
        return t;
    }

    private int rec(String a, int startPoint, int stableRemaining, int[][] dp) {
        if (dp[startPoint][stableRemaining] != -1) {
            return dp[startPoint][stableRemaining];
        }
        int ans = Integer.MAX_VALUE;

        if (stableRemaining == 0) {
            return product(a.substring(startPoint));
        }
        for (int i = startPoint; i < a.length() - stableRemaining; i++) {
//            System.out.println("start " + i + " remst " + stableRemaining + " stp " + startPoint);
            ans = Math.min(ans, rec(a, i + 1, stableRemaining - 1, dp) +
                    product(a.substring(startPoint, i + 1 )));
        }
        dp[startPoint][stableRemaining] = ans;
        return ans;
    }

    int product(String A) {
//        System.out.print("*");
        int i, n = A.length();
        int w = 0, b = 0;
        for (i = 0; i < n; i++) {
            if (A.charAt(i) == 'W')
                w++;
            else b++;
        }
        return w * b;
    }

    public static void main(String[] args) {
        ArrangeHorses s = new ArrangeHorses();
        long time = System.currentTimeMillis();
        System.out.println("\n" + s.arrange("BWBWWWWBWBBWBWBWBBWBBBWWWBWBWBWWWBWBWBWBBWBW", 19));
//        System.out.println("Time taken : " + (System.currentTimeMillis() - time));
    }
}
