import java.util.ArrayList;
import java.util.Collections;

public class WrongThreeSum {
    public int threeSumClosest(ArrayList<Integer> a, int b) {
        if (a.size() == 2) {
            return 1000000000;
        }
        Collections.sort(a);
        boolean elFound = false;
        int sum, prevSum = a.get(0) + a.get(1) + a.get(2);
        for (int i = 0; (i < a.size() - 2); i++) {

            sum = a.get(i) + a.get(i + 1) + a.get(i + 2);
            if (sum > b) {
                return prevSum;
            }
            int fix = a.get(i);
            int remSum = b - fix;
            int j = i + 1;
            int k = a.size() - 1;
            while (j < k) {
                if (a.get(j) + a.get(k) > remSum) {
                    k--;
                } else if (a.get(j) + a.get(k) < remSum) {
                    sum = a.get(i) + a.get(j) + a.get(k);
                    j++;
                } else {
                    elFound = true;
                    break;
                }
            }
            if (elFound) {
                return b;
            }

            prevSum = sum;
        }
        return prevSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        int[] l = {2, 1, -9, -7, -8, 2, -8, 2, 3, -8};
        for (int i = 0; i < l.length; i++) {
            a.add(l[i]);
        }
        WrongThreeSum s = new WrongThreeSum();
        System.out.println(s.threeSumClosest(a, -1));
    }
}
