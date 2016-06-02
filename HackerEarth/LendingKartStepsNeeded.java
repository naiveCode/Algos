import java.io.*;

/**
 * Created by naiveCode on 22/5/16.
 */
public class LendingKartStepsNeeded {


    private static int[] steps;
    private int[] stepsNeeded;
    int calculatedTill = 2;

    public int rodCuttingProblem(int n) {

        if (calculatedTill > n) {
            return stepsNeeded[n];
        }


        for (int i = calculatedTill; i <= n; i++) {
            int t = i;
            while (steps[t] != 1 && t % 2 != 0 && t != 1) {
                t = t / 2;
            }
            if (t == 1 || steps[t] == 1) {
                steps[i] = 1;
            }
            stepsNeeded[i] = steps[i] + stepsNeeded[i - 1];

        }
        calculatedTill = n;
        return stepsNeeded[n];
    }

    LendingKartStepsNeeded() {
        steps = new int[10000000];
        stepsNeeded = new int[10000000];
    }


    public static void main(String[] args) throws IOException {

//        File f = new File("/home/naiveCode/IdeaProjects/hackerTest/test/test.txt");
//        BufferedReader br = new BufferedReader(new FileReader(f));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LendingKartStepsNeeded obj = new LendingKartStepsNeeded();
        int T = Integer.parseInt(br.readLine());
        int t = 0;
        while (t++ != T) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(obj.rodCuttingProblem(n));
        }
    }

}
