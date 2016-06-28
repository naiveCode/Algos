package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClassSumOfPrimeWindow {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split("\\s");
        int num = Integer.parseInt(line[0]);
        line = br.readLine().split("\\s");
        int[] data = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            data[i] = Integer.parseInt(line[i]);
        }
        int maxLength = data.length;
        int maxPrime;
        int i = data.length;
        fillSieve(maxLength+1);
        while (!primes[i]) {
            i--;
        }
//        System.out.println(maxPrime);
        System.out.println(slidingMaximum(data, i));
    }

    static long slidingMaximum(int[] numbers, int windowSize) {
        long ans = 0;
        long max = 0;
        if (windowSize > numbers.length) {
            for (int i = 0; i < numbers.length; i++) {
                ans += numbers[i];
            }
        } else {
            for (int i = 0; i < windowSize; i++) {
                ans += numbers[i];
            }
            max = ans;
//            System.out.println("max is " + ans);
            for (int i = windowSize; i < numbers.length; i++) {
                ans = ans + numbers[i] - numbers[i - windowSize];
                if (ans > max) {
                    max = ans;
                    System.out.println("ans is " + ans);
                }
            }
        }

        return max;
    }

    static boolean[] primes;

    //set up the primesieve
    static void fillSieve(int num) {
        primes = new boolean[num];
        Arrays.fill(primes, true);        // assume all integers are prime.
        primes[0] = primes[1] = false;       // we know 0 and 1 are not prime.
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }


}
