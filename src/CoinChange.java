
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return amount;
        }
        int dp[] = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    if (dp[i-coin]!=Integer.MAX_VALUE && 1 + dp[i - coin] < min) {
                        min = 1 + dp[i - coin];
                    }
                }
            }
            dp[i] = min;
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange a = new CoinChange();
        System.out.println(a.coinChange(new int[]{2}, 3));
        System.out.println(a.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(a.coinChange(new int[]{1, 3, 5}, 8));
//        System.out.println(a.removeDuplicateLetters("bcabc"));
    }


}