import java.util.ArrayList;
import java.util.List;

/**
 * Created by naiveCode on 23/2/16.
 */
public class CountOfSmallestNumberAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> a = new ArrayList<>();
        int[]ans = new int[nums.length];
        a.add(0,0);
        for (int i=nums.length-2;i>=0;i--){
            int j= i+1;
            while (j<nums.length && nums[j]>nums[i]){
                j++;
            }
            ans[i] = ans[j]+1;
            a.add(0,ans[i]);
//            System.out.println(ans[i]);
        }
        return a;

    }

    public static void main(String[] args) {
        CountOfSmallestNumberAfterSelf c = new CountOfSmallestNumberAfterSelf();
        int []arr = {5,2,6,1};
        System.out.println(c.countSmaller(arr));
    }
}
