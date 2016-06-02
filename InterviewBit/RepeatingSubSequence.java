public class RepeatingSubSequence {
    public int anytwo(String a) {

        return findLongestCommonSubsequence(a, a);
    }

    private int findLongestCommonSubsequence(String first, String second) {
        int[][] table = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i < first.length(); i++) {
            table[i][0] = 0;
            table[0][i] = 0;
        }
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1) && i != j) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return (table[first.length()][second.length()] > 1) ? 1 : 0;
    }
}
