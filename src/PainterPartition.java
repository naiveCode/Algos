import java.util.ArrayList;

public class PainterPartition {
    public int paint(int a, int b, ArrayList<Integer> c) {
        long sum = 0;
        for (int d : c) {
            sum += d;
        }
        long ans = Integer.MAX_VALUE;
        long start = 0, end = sum, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if(isPossible(c,c.size(),a,mid)){
                ans = (int) Math.min(ans,mid);
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return (int) ((ans*b)%10000003);
    }
    boolean isPossible(ArrayList<Integer> arr, int n, int m, long curMin) {

        int studentsRequired = 1;
        int curSum = 0;

        for (int i = 0; i < n; i++) {

            if (arr.get(i) > curMin) return false;

            if (curSum + arr.get(i) > curMin) {

                studentsRequired++;
                curSum = arr.get(i);
                if (studentsRequired > m) {
                    return false;
                }
            } else {
                curSum += arr.get(i);
            }
        }
        return true;
    }
}
