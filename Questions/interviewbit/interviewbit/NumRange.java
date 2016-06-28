package interviewbit;

import java.util.ArrayList;


/**
 * Created by naiveCode on 28/6/16.
 */
public class NumRange {
    public int numRange(ArrayList<Integer> A, int B, int C) {
        int count = 0;
        int sz = A.size();
        for (int i = 0; i < sz; i++) {
            int j = i;
            int sum = 0;
            while (j < sz) {
                sum = sum + A.get(j);
                if (sum >= B && sum <= C) {
                    count++;
                }
                if (sum > C) {
                    break;
                }
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumRange s = new NumRange();
        int c = 269;
        int b = 99;
        ArrayList<Integer> a = new ArrayList<>();
        int d[] = {80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90};
        for (int e : d) {
            a.add(e);
        }
        System.out.println(s.numRange(a, b, c));
    }
}