import java.util.ArrayList;

public class RodCutDPPTryFail {
    public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
        if (B.get(0) != 0) {
            B.add(0, 0);
        }
        if (B.get(B.size() - 1) != A) {
            B.add(A);
        }
        for (int i=0;i<B.size();i++){
            System.out.println(" -> " + B.get(i));
        }
        Helper[][] dp = new Helper[B.size()][B.size()];
        for (int i = 0; i < B.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                dp[i][j] = new Helper();
                dp[i][j].formers = new ArrayList<>();
            }
        }
//        int[][] dp = new int[B.size()][B.size()];
        for (int i = 1; i < B.size(); i++) {
            dp[i][i].value = B.get(i);
            dp[i][i].formers.add(B.get(i));
        }
        for (int len = 2; len < B.size() ; len++) {
            for (int i = 1; i < B.size() - len; i++) {
                int j = i + len - 1;
                dp[i][j].value = B.get(j) - B.get(i);
                dp[i][j].formers.add(B.get(j));
                dp[i][j].formers.add(B.get(i));
                if (dp[i][j - 1].value < dp[i + 1][j].value) {
                    dp[i][j].value += dp[i][j - 1].value;
                    dp[i][j].formers.addAll(dp[i][j - 1].formers);
                } else {
                    dp[i][j].value += dp[i + 1][j].value;
                    dp[i][j].formers.addAll(dp[i + 1][j].formers);
                }


            }
        }
//        for (int i=0;i<dp.length;i++){
//            for (int j=0;j<dp[0].length;j++){
//                System.out.println(dp[i][j].formers);
//            }
//        }
        return dp[1][B.size() - 2].formers;

    }

    class Helper {
        int value;
        ArrayList<Integer> formers;

    }

    public static void main(String[] args) {
        RodCutDPPTryFail s = new RodCutDPPTryFail();
        int A = 6;
        ArrayList<Integer> p = new ArrayList<>();
        p.add(1);
        p.add(2);
        p.add(5);
        System.out.println(s.rodCut(A, p));
    }
}
