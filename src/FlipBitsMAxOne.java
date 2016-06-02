import java.util.ArrayList;

public class FlipBitsMAxOne {
    public ArrayList<Integer> flip(String A) {
        char arr[] = A.toCharArray();
        int sum = 0, maxsum = 0, num = 0;
        int startIndex = 0, stopIndex = 0, prevIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                num = -1;
            } else if (arr[i] == '0') {
                num = 1;
            }
            sum = sum + num;
            if (maxsum < sum) {
                maxsum = sum;
                prevIndex = startIndex;
                stopIndex = i;
            } else if (sum < 0) {
                sum = 0;
                startIndex = i + 1;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if (maxsum > 0) {
            ans.add(prevIndex + 1);
            ans.add(stopIndex + 1);
        }


        return ans;

    }
}
