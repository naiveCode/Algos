import java.util.Arrays;

/**
 * Created by naiveCode on 19/6/16.
 */
public class MaximumAmount {
    static long maximumAmount(int[] a, long k) {
        Arrays.sort(a);
        long amountTillNow = 0;

        int count = 1, i;
        for (i = a.length - 1; i > 0; i--, count++) {
            int diff = a[i] - a[i - 1];
//            System.out.println("diff is " + diff + " count is " + count + " k is " + k);

            if (diff * count <= k) {
                k -= diff * count;
                amountTillNow += count * (sumf(a[i], a[i - 1]));
//                System.out.println("amount is " + amountTillNow);
                a[i] = a[i - 1];
            } else {
                break;
            }
        }
        if (k > 0) {
            while (k > 0) {
                if (k - count >= 0) {
                    amountTillNow += count * a[i];
                    a[i] = a[i] - 1;
                    k = k - count;
                } else {
                    amountTillNow += k * a[i];
                    k = 0;
                }
            }
        }
        return amountTillNow;

    }


    static long sumf(int a, int b) {
        long sumFrom1toa = (a * (a + 1)) / 2;
        long sumFrom1tob = (b * (b + 1)) / 2;
        return sumFrom1toa - sumFrom1tob;
    }
}
