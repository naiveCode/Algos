import java.util.LinkedList;
import java.util.List;

public class FindMin {
    // DO NOT MODIFY THE LIST
    public int findCount(final List<Integer> a, int b) {
        int left = findIndexFromStart(a,b,true);
        int right;
        if(left!=-1){
            right = findIndexFromStart(a,b,false);
            return right-left+1;
        }else {
            return -1;
        }



    }

    private int findIndexFromStart(List<Integer> a, int b, boolean findLeft) {
        int left = 0,right = a.size()-1,middle = -1,result = -1;
        while (left<=right){
            middle = (left + right)/2;
            if(a.get(middle)==b){
                result = middle;
                if(findLeft){
                    right = middle-1;
                }else {
                    left = middle + 1;
                }
            }else if(a.get(middle)<b){
                left = middle + 1;
            }else {
                right = middle -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int []arr = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10 };
        List<Integer> a = new LinkedList<>();
        for (int i=0;i<arr.length;i++){
            a.add(arr[i]);
        }
        FindMin s = new FindMin();
        s.findCount(a,1);
    }
}
