import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayIntersection {
    // DO NOT MODIFY THE LISTS
    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0, j = 0; i < a.size() && j < b.size(); ) {
            if (a.get(i).intValue() == b.get(j).intValue()) {
                ans.add(a.get(i));
                i++;
                j++;
            } else if (a.get(i) > b.get(j)) {
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayIntersection s = new ArrayIntersection();
        List<Integer> a = new LinkedList<>();
        //1 2 3 3 4 5 6
        a.add(1);a.add(2);a.add(3);a.add(3);a.add(4);a.add(5);a.add(6);

        List<Integer> b = new LinkedList<>();
        b.add(3);b.add(3);b.add(5);
        System.out.println(s.intersect(a,b));
    }
}
