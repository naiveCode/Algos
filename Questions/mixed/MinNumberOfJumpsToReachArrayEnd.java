import java.util.ArrayList;

public class MinNumberOfJumpsToReachArrayEnd {
    public int jump(ArrayList<Integer> a) {
        int t = minJumps(a, a.size());
        if (t == Integer.MAX_VALUE) {
            return -1;
        }
        return t;
    }

    int minJumps(ArrayList<Integer> arr, int n) {
        int[] jumps = new int[n];  // jumps[n-1] will hold the result
        int i, j;
        if(n==1 && arr.get(0)==0){
            return 0;
        }
        if (n == 0 || arr.get(0) == 0)
            return Integer.MAX_VALUE;

        jumps[0] = 0;

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr.get(j) && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }
}