import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumIndexGap {
    // DO NOT MODIFY THE LIST
    public int maximumGap(final List<Integer> a) {
        ArrayList<PositionValue> pv = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            pv.add(new PositionValue(i, a.get(i)));
        }
        Collections.sort(pv);
        int maxPos = Integer.MIN_VALUE;
        int minPos = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < pv.size(); i++) {
            if (pv.get(i).position < minPos) {
                minPos = pv.get(i).position;
                maxPos = minPos;
            }
            if (maxPos <= pv.get(i).position) {
                maxPos = pv.get(i).position;
                if (maxPos - minPos > max) {
                    max = maxPos - minPos;
                }
            }
        }
        return max;

    }

    class PositionValue implements Comparable<PositionValue> {
        int position, value;

        PositionValue(int p, int v) {
            position = p;
            value = v;
        }

        @Override
        public int compareTo(PositionValue o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) {
        MaximumIndexGap s = new MaximumIndexGap();
        int []arr = {3,5,4,2};
        List<Integer> b = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            b.add(arr[i]);
        }

        s.maximumGap(b);
    }
}
