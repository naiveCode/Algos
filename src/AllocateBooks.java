import java.util.ArrayList;

public class AllocateBooks {
    public int books(ArrayList<Integer> a, int b) {
        if (a.size() < b) {
            return -1;
        }
        int[] t = new int[a.size()];

        for (int i = 0; i < a.size(); i++) {
            t[i] = a.get(i);
        }
        return solve(t, a.size(), b);
    }

    boolean isPossible(int arr[], int n, int m, long curMin) {

        int studentsRequired = 1;
        int curSum = 0;

        for (int i = 0; i < n; i++) {

            if (arr[i] > curMin) return false;

            if (curSum + arr[i] > curMin) {

                studentsRequired++;
                curSum = arr[i];
                if (studentsRequired > m) {
                    return false;
                }
            } else {
                curSum += arr[i];
            }
        }
        return true;
    }

    int solve(int arr[], int n, int m) {

        long sum = 0;
        if (n < m) return -1;

        for (int i = 0; i < n; ++i) sum += arr[i];


        long start = 0;
        long end = sum, mid;
        int ans = Integer.MAX_VALUE;

        while (start <= end) {

            mid = (start + end) / 2;

            if (isPossible(arr, n, m, mid)) {

                ans = Math.min(ans, (int) mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;

    }
}
