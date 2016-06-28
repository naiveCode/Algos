import java.util.ArrayList;
import java.util.List;

public class MissingAndRepeatingElementsInArray {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        long n = a.size();
        long sumShouldBe = 0;
        int[] arr = new int[a.size()];
        if (n % 2 == 0) {
            sumShouldBe = n / 2 * (n + 1);
        } else {
            sumShouldBe = (n + 1) / 2 * n;
        }
        long sumWhichIs = 0;
        for (int b : a) {
            sumWhichIs += b;
            arr[b - 1] = b;
        }
        long sumWithMissElem = 0;
        for (int i = 0; i < arr.length; i++) {
            sumWithMissElem += arr[i];
        }
        int B = (int) (sumShouldBe - sumWithMissElem);
        int A = (int)(B - (sumShouldBe-sumWhichIs));
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(A);
        ans.add(B);
        return ans;

    }
}
