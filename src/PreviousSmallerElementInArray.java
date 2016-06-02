import java.util.ArrayList;
import java.util.Stack;

public class PreviousSmallerElementInArray {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int b : arr) {
            if (stack.isEmpty()) {
                stack.push(b);
                ans.add(-1);
            } else {
                int t = stack.peek();
                while (!stack.isEmpty()) {
                    t = stack.peek();
                    if (t >= b) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                if (stack.isEmpty()) {
                    ans.add(-1);
                } else {
                    ans.add(t);
//                    stack.pop();
                }
                stack.push(b);

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PreviousSmallerElementInArray s = new PreviousSmallerElementInArray();
        ArrayList<Integer> l = new ArrayList<>();
        int[] d = {34, 35, 27, 42, 5, 28, 39, 20, 28};
//        int[] d = {39, 27, 11, 4, 24, 32, 32, 1};
        for (int i = 0; i < d.length; i++) {
            l.add(d[i]);
        }
        System.out.println(s.prevSmaller(l));
    }
}
