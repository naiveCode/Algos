public class NumArray {

    int[] numberArray;

    public NumArray(int[] nums) {
        numberArray = nums;
        for (int i = 1; i < numberArray.length; i++) {
            numberArray[i] += numberArray[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if(i==0){
            return numberArray[j];
        }
        return numberArray[j] - numberArray[i-1];
    }

    public static void main(String[] args) {
        int[]num = {-2,0,3,-5,2,-1};
        NumArray n = new NumArray(num);
        System.out.println(n.sumRange(0,2));
        System.out.println(n.sumRange(2,5));
        System.out.println(n.sumRange(0,5));
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);