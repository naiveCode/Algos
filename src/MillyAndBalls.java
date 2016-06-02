import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by naiveCode on 21/2/16.
 */
public class MillyAndBalls {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        int test = 0;
        while (test++ != tests) {
            String[] data = br.readLine().split("\\s");
            int N = Integer.parseInt(data[0]);
            int K = Integer.parseInt(data[1]);
            K=K%N;
            for (int i=1;i<=N;i++){
                if(K>0){

                }
            }


        }
    }
}

