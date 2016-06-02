import java.util.LinkedList;
import java.util.List;

public class MAxProductSubArray {
    public int maxProduct(final List<Integer> A) {
            if(A==null || A.size()==0)
                return 0;

            int maxLocal = A.get(0);
            int minLocal = A.get(0);
            int global = A.get(0);

            for(int i=1; i<A.size(); i++){
                int temp = maxLocal;
                maxLocal = Math.max(Math.max(A.get(i)*maxLocal, A.get(i)), A.get(i)*minLocal);
                minLocal = Math.min(Math.min(A.get(i)*temp, A.get(i)), A.get(i)*minLocal);
                global = Math.max(global, maxLocal);
            }
            return global;
    }

    public static void main(String[] args) {
        List<Integer> an = new LinkedList<>();
        int[] data = {2,-2,-2};
        for (int i = 0; i < data.length; i++) {
            an.add(data[i]);
        }
        MAxProductSubArray s = new MAxProductSubArray();
        System.out.println(s.maxProduct(an));
    }
}
