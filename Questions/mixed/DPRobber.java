public class DPRobber {
    public int rob(int[] nums) {
        int sumIfRobCurrentHouse = 0,sumIfNotRobCurrentHouse = 0;
        for (int num : nums){
            int currSum = sumIfNotRobCurrentHouse + num;
            sumIfNotRobCurrentHouse=Math.max(sumIfNotRobCurrentHouse,sumIfRobCurrentHouse);
            sumIfRobCurrentHouse = currSum;
        }
        return Math.max(sumIfNotRobCurrentHouse,sumIfRobCurrentHouse);
    }
}