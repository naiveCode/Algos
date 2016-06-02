/**
 * Created by naiveCode on 20/1/16.
 */
public class ArrayMultipleExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow!=fast){
            slow = nums[slow];
            fast=nums[nums[fast]];
        }
        int t= nums[0];
        while (nums[fast]!=slow){
            fast = nums[fast];
            t = nums[t];
        }
        int head = nums[0];
        while (nums[t]!=head ){
            head = nums[head];
            t=nums[t];
        }
        return head;
    }

    public static void main(String[] args) {
        int[] m = {1, 2, 3, 3};
        ArrayMultipleExceptSelf a = new ArrayMultipleExceptSelf();
//        a.productExceptSelf(m);
//        System.out.println(a.findDuplicate(m));
        System.out.println(a.findDuplicate(m));
        m = new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
//        m = new int[]{1, 3, 4, 2, 2};
        System.out.println(a.findDuplicate(m));
    }
}
