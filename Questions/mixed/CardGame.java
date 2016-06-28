/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;

class CardGame {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        int test = 0;

        while (test++ != tests) {
            int numberOfCards = Integer.parseInt(br.readLine());
            String[] dataS = br.readLine().split("\\s");
            String[] dataP = br.readLine().split("\\s");
            int[] S = new int[numberOfCards];
            int[] P = new int[numberOfCards];
            int unequalCount = 0;
            for (int i = 0; i < numberOfCards; i++) {
                S[i] = Integer.parseInt(dataS[i]);
                P[i] = Integer.parseInt(dataP[i]);
                if (S[i] != P[i]) {
                    unequalCount++;
                }
            }
            String guysWhoGoesFirst = br.readLine();
            if (unequalCount % 2 == 0) {
                if ((unequalCount / 2)  == 1) {
                    System.out.println(guysWhoGoesFirst);
                } else {
                    if (guysWhoGoesFirst.contentEquals("Devu")) {
                        System.out.println("Churu");
                    } else {
                        System.out.println("Devu");
                    }
                }
            }else {
                if (guysWhoGoesFirst.contentEquals("Devu")) {
                    System.out.println("Churu");
                } else {
                    System.out.println("Devu");
                }
            }

//            if((unequalCount/2)%2==1){
//                System.out.println(guysWhoGoesFirst);
//            }else {
//                if(guysWhoGoesFirst.contentEquals("Devu")){
//                    System.out.println("Churu");
//                }else {
//                    System.out.println("Devu");
//                }
//            }
        }

    }
}
