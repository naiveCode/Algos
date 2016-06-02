/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split("\\s");
        int M = 1299709;
        int L = Integer.parseInt(line[0]);//number of levels in crazy tree
        int Q = Integer.parseInt(line[1]);//number of queries
        long N[] = new long[Q];
        long X[] = new long[Q];
        long Y[] = new long[Q];
        for (int i = 0; i < Q; i++) {
            line = br.readLine().split("\\s");
            N[i] = Long.parseLong(line[0]);
            X[i] = Long.parseLong(line[1]);
            Y[i] = Long.parseLong(line[2]);

        }
        int totalNumberOfNodesNeeded = (int) (Math.pow(2, L) - 1);
        int firstLeafIndex = (int) (Math.pow(2, L - 1) - 1);
        long crazyTre[] = new long[totalNumberOfNodesNeeded];
        long crazyTreSum[] = new long[totalNumberOfNodesNeeded];
        long val = 2;
        crazyTre[firstLeafIndex]=1;
        crazyTreSum[firstLeafIndex] = 1;
        for (int i = firstLeafIndex + 1; i < totalNumberOfNodesNeeded; i++) {
            crazyTre[i] = val++;
            crazyTreSum[i] = crazyTre[i] + crazyTreSum[i-1];

        }
        crazyTreSum[0] = crazyTre[0];
        for (int i = firstLeafIndex - 1; i >= 0; i--) {
            crazyTre[i] = ((crazyTre[2 * i + 1] )%M * (crazyTre[2 * i + 2])%M)%M;
            int c= i+1;
            if((c&c-1)!=0){
                crazyTreSum[i] = (crazyTreSum[i]%M + crazyTreSum[i-1]%M)%M;
            }
        }
//        for (int i=0;i<totalNumberOfNodesNeeded;i++){
//            System.out.print( i + " " + crazyTre[i] + " -> ");
//        }
//        System.out.println();

        //this will print the o/p
        for (int i = 0; i < X.length; i++) {
            long level = N[i];
            int startIndex = (int) (Math.pow(2, level - 1) - 1);
            if (X[i] == 1) {
                System.out.println((crazyTreSum[((int) (startIndex + Y[i] - 1))] % M));
            } else {
                System.out.println(((crazyTreSum[((int) (startIndex + Y[i] - 1))] - crazyTreSum[((int) (startIndex + X[i] - 2))]) % M));
            }

        }
//        for (int level = 1;level<lMax;level++){
//            for (int j=(int)Math.pow(2,level);j<(int)Math.pow(2,level);j++){
//
//            }
//        }


    }
}
