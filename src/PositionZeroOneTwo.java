import java.util.ArrayList;

public class PositionZeroOneTwo {
    public void sortColors(ArrayList<Integer> a) {
        int left =0,right=a.size()-1;
        while (left<=right){
            if(a.get(left)==0){
                left++;
            }else if(a.get(right)!=0){
                right--;
            }else {
                int t = a.get(left);
                a.set(left,a.get(right));
                a.set(right,t);
                left++;right--;
            }
        }
//        right = a.size()-1;
//        left++;
//        while (left<right){
//            if(a.get(left)==1){
//                left++;
//            }else if(a.get(right)==2){
//                right--;
//            }else {
//                int t = a.get(left);
//                a.set(left,a.get(right));
//                a.set(right,t);
//                left++;right--;
//            }
//        }
        System.out.println("done!");

    }

    public static void main(String[] args) {
        PositionZeroOneTwo s = new PositionZeroOneTwo();
        int []arr = {0, 0, 2, 2, 2, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 2, 1, 1, 1, 0, 1, 1, 2, 2, 2, 2, 1, 1, 1, 0, 2, 0, 2, 2, 1, 2, 1, 1, 1, 2, 0, 2, 0, 0, 0, 1, 2, 0, 1, 0, 1, 1, 1, 2, 0, 2, 1, 2, 1, 2, 0, 1, 2, 2, 0, 2, 0, 2, 2, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 2, 2, 0, 2, 2, 1, 1, 1, 0, 0, 2, 1, 1, 1, 2, 1, 0, 1, 0, 0, 1, 0, 1, 1, 2, 2, 2, 1, 1, 1, 2, 1, 0, 1, 2, 1, 0, 1, 0, 0, 2, 1, 0, 2, 2, 0, 2, 1, 2, 2, 0, 2, 0, 2, 0, 0 };
        ArrayList<Integer> b = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            b.add(arr[i]);
        }

        s.sortColors(b);
    }
}
