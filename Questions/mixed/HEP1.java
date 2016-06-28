/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class HEP1 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int t = 0;
        while (t++ != T) {
            String[] data = br.readLine().split("\\s");
            int N = Integer.parseInt(data[0]);
            int K = Integer.parseInt(data[1]);
            int[][] input = new int[K][N];
            for (int i = 0; i < K; i++) {
                data = br.readLine().split("\\s");
                for (int j = 0; j < N; j++) {
                    input[i][j] = Integer.parseInt(data[j]);
                }
            }
            int[][] dp = new int[N][K];
            int min = Integer.MAX_VALUE, minP = 1, max = Integer.MIN_VALUE, maxP = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < K; j++) {
                    dp[0][i] += input[j][i];
                    if(min>dp[0][i]){
                        min = dp[0][i];
                    }
                    if(max<dp[0][i]){
                        max = dp[0][i];
                    }
                }

            }
            for (int i = 1; i < N; i++) {
                for (int j = 1; j <= K - i; j++) {
                    dp[i][j] = (dp[i - 1][j] * dp[i - 1][j - 1]);
                    if(min>dp[i][j]/j){
                        min = dp[i][j]/(j+1);
                        minP = j;
                    }

                    if(max<dp[i][j]){
                        max = dp[i][j]/j;
                        maxP = j;
                    }
                }
            }
//            System.out.println("Max is " + max + " " + min +  " " + maxP +" " + minP);
            System.out.println((max^min) + " " + (maxP^minP));
        }
    }
}
