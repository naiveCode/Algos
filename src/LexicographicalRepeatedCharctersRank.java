/**
 * Created by naiveCode on 11/3/16.
 */
public class LexicographicalRepeatedCharctersRank {
    private static final int MOD = 1000003;

    public int findRank(String a) {
        boolean[] charSet = new boolean[255];
        int[] charCount = new int[255];
        int characterCount = 0;
        for (char b : a.toCharArray()) {
            charSet[b] = true;
            characterCount++;
            charCount[b]++;
        }
        int[] factorialTable = new int[a.length()];
        factorialTable[0] = 1;
        for (int i = 1; i < a.length(); i++) {
            factorialTable[i] = (factorialTable[i - 1] * i) % MOD;
        }
        int rank =  1;
        char[]S = a.toCharArray();
        for (int i = 0; i < S.length; i++) {
            // find number of permutations placing character smaller than S[i] at ith position
            // among characters from i to S.length
            int less = 0;
            int remaining = S.length - i - 1;
            for (int ch = 0; ch < S[i]; ch++) {
                if (charCount[ch] == 0) continue;
                // Lets try placing ch as the first character in remaining characters
                // and check the number of permutation possible.
                charCount[ch]--;
                int numPermutation = factorialTable[remaining-1];

                for (int c = 0; c < 255; c++) {
                    if (charCount[c] <= 1) continue;
                    numPermutation = (numPermutation * calcInverse(factorialTable[charCount[c]]));
                }

                charCount[ch]++;
                less = (less + numPermutation) % MOD;
            }

            rank = (rank + less) % MOD;
            // remove the current character from the set.
            charCount[S[i]]--;
        }
        return rank;

    }

    private int calcInverse(int num) {
        int ans = 1, base =  num;
        int power = MOD - 2;
        while (power > 0) {
            if (power == 1) {
                return (ans * base) % MOD;
            }
            if (power % 2 == 0) {
                base = (base * base) % MOD;
                power /= 2;
            } else {
                ans = (ans * base) % MOD;
                power--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        LexicographicalRepeatedCharctersRank s = new LexicographicalRepeatedCharctersRank();
        System.out.println(s.findRank("bbbbaaaa"));
    }

}
