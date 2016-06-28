import java.util.List;

public class LongestIncreasingSubsequenceNSquare {
    public int lis(final List<Integer> a) {
        int []lisArray = new int[a.size()];
        lisArray[0] = 1;
        int max = 1;
        for (int i=1;i<a.size();i++){
            lisArray[i]=1;
            for (int j=0;j<i;j++){
                if(a.get(i)>a.get(j) && lisArray[i] < lisArray[j] + 1){
                    lisArray[i] = lisArray[j] + 1;
                    max = Math.max(max,lisArray[i]);
                }
            }
        }
        return max;
    }
}
