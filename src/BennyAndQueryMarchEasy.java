import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by naiveCode on 1/3/16.
 */
public class BennyAndQueryMarchEasy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split("\\s");
        int N = Integer.parseInt(data[0]), Q = Integer.parseInt(data[1]);
        int[] A = new int[N];
        data = br.readLine().split("\\s");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(data[i]);
        }
        while (Q--!=0) {
            data = br.readLine().split("\\s");
            int L = Integer.parseInt(data[0]) - 1;
            int R = Integer.parseInt(data[1]) - 1;
            int X = Integer.parseInt(data[2]);
            int max = A[L] ^ X;
            for (int i = L + 1; i <= R; i++) {
                if (max < (A[i] ^ X)) {
                    max = (A[i] ^ X);
                }
            }
            System.out.println(max);
        }
    }
}
