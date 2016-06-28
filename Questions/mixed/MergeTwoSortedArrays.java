import java.util.ArrayList;

/**
 * Created by naiveCode on 17/3/16.
 */
public class MergeTwoSortedArrays {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int a1 = 0, a2 = 0;
        while (a1!=a.size() && a2!= b.size()) {
            if (a.get(a1) < b.get(a2))
                a1++;
            else {
                a.add(a1,b.get(a2));
                a1++;a2++;
            }
        }
        if(a2!=b.size()){
            a.add(b.get(a2++));
        }
    }
}
