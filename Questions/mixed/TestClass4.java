/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass4 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            char[] data = br.readLine().toCharArray();
            int rCount = 0, kCount = 0;
            for (int l = 0, r = data.length-1; r > l; l++, r--) {
                if (data[l] == 'R') {
                    rCount++;
                }
                if (data[r] == 'K') {
                    kCount++;
                }
            }
            if (rCount + kCount == data.length) {
                System.out.println(0);
            } else {
                if (data.length % 2 != 0) {

                    if (data[data.length / 2] == 'R') {
                        rCount++;
                    } else {
                        kCount++;
                    }

                }
                System.out.println(2*Math.min(rCount, kCount));
            }
        }

    }
}
