public class SegmentTree {

    int[] numberArray;
    int length;

//    public SegmentTree(int[] nums) {
//        numberArray = new int[4*nums.length];
//        length = nums.length;
//        createNewArray(0, nums.length - 1, nums, 1);
////        for (int i = 0; i < numberArray.length; i++) {
////            System.out.print("-> " + numberArray[i]);
////        }
//    }

    private int createNewArray(int l, int r, int[] nums, int index) {
        if (l == r && index <= 4*length) {
            numberArray[index] = nums[l];
            return numberArray[index];
        }
        if (index <= 4*length) {
            numberArray[index] = createNewArray(l, (l + r) / 2, nums, index * 2)
                    + createNewArray((l + r) / 2 + 1, r, nums, index * 2 + 1);
            return numberArray[index];
        }
        if (index <= 4*length)
            return numberArray[index];
        else return 0;
    }


    public int sumRange(int i, int j) {
        return findInArray(i, j, 0, length - 1, 1);
    }

    private int findInArray(int i, int j, int l, int r, int index) {
        if (index >= 4*length) {
            return 0;
        }
        if (i == l && j == r) {
            return numberArray[index];
        } else if (i >= l && j <= (l + r) / 2) {
            return findInArray(i, j, l, (l + r) / 2, 2 * index);
        } else if (j <= r && i > (l + r) / 2) {
            return findInArray(i, j, (l + r) / 2 + 1, r, 2 * index + 1);
        } else {
            return findInArray(i, (l + r) / 2, l, (l + r) / 2, 2 * index) +
                    findInArray(((l + r) / 2 + 1), j, (l + r) / 2 + 1, r, 2 * index + 1);
        }
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        numberArray = new int[4*nums.length];
        length = nums.length;
        createNewArray(0, nums.length - 1, nums, 1);
//        SegmentTree a = new SegmentTree(nums);
        int count =0;
        for (int i=0;i<2*nums.length;i++){
            if(numberArray[i]>lower && numberArray[i]<upper){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num = {-4, -5};

        SegmentTree s = new SegmentTree();
        System.out.println(s.countRangeSum(new int[]{-2, 5, -1},-2,2));
//        SegmentTree a = new SegmentTree(num);
//        System.out.println();
//        System.out.println(a.sumRange(0, 0));
//        System.out.println(a.sumRange(1, 1));
//        System.out.println(a.sumRange(0, 1));
//        System.out.println(a.sumRange(1, 1));
//        System.out.println(a.sumRange(0, 0));
////        System.out.println(a.sumRange(1,4));
//        int[] num2 = {-2,0,3,-5,2,-1};
//        SegmentTree b = new SegmentTree(num2);
//        //[-2,0,3,-5,2,-1],
//        System.out.println(b.sumRange(0,2));
//        System.out.println(b.sumRange(2,5));
//        System.out.println(b.sumRange(0,5));

    }
}


// Your SegmentTree object will be instantiated and called as such:
// SegmentTree numArray = new SegmentTree(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);