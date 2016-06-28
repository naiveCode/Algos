package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by naiveCode on 26/5/16.
 */
public class SolutionHR {
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
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> index = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] + arr[j]) % k != 0) {
                    boolean first = true, second = true;
                    for (int b : list) {
                        if ((b + arr[i])%k==0) first = false;
                        if ((b + arr[j]) %k==0) second = false;
                    }
                    if(first&&!index.contains(arr[i])){
                        list.add(arr[i]);
                        index.add(i);
                    }
                    if(second&&!index.contains(arr[j])){
                        list.add(arr[j]);
                        index.add(j);
                    }
                }

            }
        }
        System.out.println(list.size());
    }
}
