import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by naiveCode on 26/5/16.
 * HAcker rank contest
 * week of code 20
 * Divisible sum pairs
 */
public class DivisibleSumPairs {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split("\\s");
        int n = Integer.parseInt(data[0]);
        int k = Integer.parseInt(data[1]);
        int arr[] = new int[n];
        data = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] + arr[j]) % k == 0)
                    count++;
            }
        }
        System.out.println(count);
    }
}
