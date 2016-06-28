import java.util.ArrayList;

public class FuckedUpPrincessInDungeon {
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> dungeon) {
        if (dungeon.size() == 0 || dungeon.get(0).size() == 0)
            return 0;
        int m = dungeon.size();
        int n = dungeon.get(0).size();
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon.get(m - 1).get(n - 1));
        for (int j = n - 2; j >= 0; j--)
            dp[m - 1][j] = maxOfThree(1, 1 - dungeon.get(m - 1).get(j), -dungeon.get(m - 1).get(j) + dp[m - 1][j + 1]);
        for (int i = m - 2; i >= 0; i--)
            dp[i][n - 1] = maxOfThree(1, 1 - dungeon.get(i).get(n - 1), -dungeon.get(i).get(n - 1) + dp[i + 1][n - 1]);
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = maxOfThree(1, 1 - dungeon.get(i).get(j),
                        Math.min(-dungeon.get(i).get(j) + dp[i + 1][j], -dungeon.get(i).get(j) + dp[i][j + 1]));
            }
        }
        return dp[0][0];
    }

    public int maxOfThree(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        t.add(-2);
        t.add(-3);
        t.add(3);
        a.add(t);
        t = new ArrayList<>();
        t.add(-5);
        t.add(-10);
        t.add(1);
        a.add(t);
        t = new ArrayList<>();
        t.add(10);
        t.add(30);
        t.add(-5);
        a.add(t);
        FuckedUpPrincessInDungeon s = new FuckedUpPrincessInDungeon();
        System.out.println(s.calculateMinimumHP(a));

    }
}
