/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class CombinationThree {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            int[] R = new int[N];
            String[] rdata = br.readLine().split("\\s");
            for (int j = 0; j < rdata.length; j++) {
                R[j] = Integer.parseInt(rdata[j]);
            }
            int length = rdata.length;
            long count = 0;
//            for (int l=0;l<=length-3;l++){
//                for(int m = l+1;m<=length-2;m++){
//                    for (int n=m+1;n<=length-1;n++){
//                        // Rl < Rn < Rm for 1 <= l < m < n
////                        System.out.println(" " + R[l] + " " + R[n] + " " + R[m]);
//                        if(R[l]<R[n]&&R[n]<R[m]){
////                            System.out.println("trio  " + R[l] + " " + R[m] + " " + R[n]);
//                            if(count+1==1000000007){
//                                count=0;
//                            }else count++;
//                        }
//                    }
//                }
//            }

            for (int n = 2; n < R.length - 1; n++) {

                long countOfSmallerNumber = 0;
                long countOfBiggerNumber = 0;
                // Rl < Rn < Rm for 1 <= l < m < n





            }


            System.out.println(count);


        }


    }
}
