import java.util.Arrays;

/**
 * Created by naiveCode on 15/1/16.
 */
public class MaxProductOfWordLength {
    public int maxProduct(String[] words) {
        int[][] numeralConvert = new int[words.length][2];
        for (int i = 0; i < words.length; i++) {
            boolean[] wordAdded = new boolean[26];
            for (int j = 0; j < words[i].length(); j++) {
                numeralConvert[i][1]++;
                if (!wordAdded[words[i].charAt(j) - 'a']) {
                    numeralConvert[i][0] |= 1 << (words[i].charAt(j) - 'a');
                    wordAdded[words[i].charAt(j) - 'a'] = true;
                }
            }
        }
        int max = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if ((numeralConvert[i][0] & numeralConvert[j][0]) == 0) {
                    if (numeralConvert[i][1] * numeralConvert[j][1] > max) {
                        max = numeralConvert[i][1] * numeralConvert[j][1];
                    }
                }
            }
        }


        return max ;
    }

    public static void main(String[] args) {
        MaxProductOfWordLength m = new MaxProductOfWordLength();
        System.out.println(m.maxProduct(new String[]{"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"}));
        System.out.println(m.maxProduct(new String[]{"z", "ab", "abc", "d", "cd", "bcd", "abcd"}));
    }
}
