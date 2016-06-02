import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlindingWindowMaximum {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
        int min = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        if (b <= 0) {
            return new ArrayList<>();
        }
        if (a.size() <= b) {
            for (int i = 0; i < a.size(); i++)
                min = Math.max(min, a.get(i));
            ans.add(min);
            return ans;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < b; i++) {
            while (!deque.isEmpty() && a.get(i) >= a.get(deque.getLast())) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (int i = b; i < a.size(); ++i) {
            ans.add(a.get(deque.getFirst()));

            // Remove the elements which are out of this window
            while ((!deque.isEmpty()) && deque.getFirst() <= i - b)
                deque.removeFirst();  // Remove from front of queue

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!deque.isEmpty()) && a.get(i) >= a.get(deque.getLast()))
                deque.removeLast();

            // Add current element at the rear of Qi
            deque.addLast(i);
        }
        if (!ans.isEmpty())
            ans.add(a.get(deque.getFirst()));
        return ans;
    }

    public static void main(String[] args) {
        int[]data = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        ArrayList<Integer> a = new ArrayList<>();
        for (int i=0;i<data.length;i++){
            a.add(data[i]);
        }
        SlindingWindowMaximum s = new SlindingWindowMaximum();
        System.out.println(s.slidingMaximum(a,2));
    }
}
