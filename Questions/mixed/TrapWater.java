import java.util.LinkedList;
import java.util.List;

public class TrapWater {
    // DO NOT MODIFY THE LIST
    public int trap(final List<Integer> a) {
        int left[] = new int[a.size()];
        int right[] = new int[a.size()];
        int water = 0;
        left[0] = a.get(0);
        right[a.size()-1] = a.get(a.size()-1);
        for (int i=1,j=a.size()-2;i<a.size();i++,j--){
            left[i] = Math.max(left[i-1],a.get(i));
            right[j] = Math.max(a.get(j),right[j+1]);
        }
        for (int i=0;i<a.size();i++){
            water += Math.min(left[i],right[i]) - a.get(i);
        }
        return water;

    }

    public static void main(String[] args) {
        TrapWater s = new TrapWater();
        List<Integer> a = new LinkedList<>();
        int[] b = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        for (int i = 0; i < b.length; i++) {
            a.add(b[i]);
        }
        System.out.println(s.trap(a));
    }
}
