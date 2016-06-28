import java.util.LinkedList;
import java.util.List;

public class RangeSummary {
    public List<String> summaryRanges(int[] nums) {
        List<String> a = new LinkedList<>();
        int start = 0,end = 0;
        boolean startFound = false,endFound = false;
        for (int i = 0; i < nums.length; i++) {
            if(!startFound){
                start = nums[i];
                i++;
                startFound = true;
                endFound = false;
            }
            while (i!=nums.length && nums[i]==nums[i-1] + 1){
                i++;
            }
            if(i==nums.length){
                end = nums[nums.length-1];
                endFound = true;
            }else {
                end = nums[i-1];
                i--;
                startFound = false;
                endFound = true;
            }
            if(endFound){
                if(start!=end)
                {
                    a.add(start+"->"+end);
                }else {
                    a.add(start+"");
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        RangeSummary a = new RangeSummary();
        a.summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
    }
}