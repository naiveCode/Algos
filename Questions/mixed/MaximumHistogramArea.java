import java.util.ArrayList;
import java.util.Stack;

public class MaximumHistogramArea {
    public int largestRectangleArea(ArrayList<Integer> a) {
        Stack<Integer> stack = new Stack<>();
        int ans = Integer.MIN_VALUE;
        int area;
        int i;
        for (i = 0; i < a.size();) {
            if (stack.isEmpty() || a.get(i) >= a.get(stack.peek())) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = a.get(top) * i;
                } else {
                    area = a.get(top) * (i - stack.peek() - 1);
                }
                if (area > ans) {
                    ans = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                area = a.get(top) * i;
            } else {
                area = a.get(top) * (i - stack.peek() - 1);
            }
            if (area > ans) {
                ans = area;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        int[] data = {90, 58, 69, 70, 82, 100, 13, 57, 47, 18};
        for (int i = 0; i < data.length; i++) {
            a.add(data[i]);
        }
        MaximumHistogramArea s = new MaximumHistogramArea();
        System.out.println(s.largestRectangleArea(a));

    }
}
