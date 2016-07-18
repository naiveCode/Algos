package interviewbit;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by naiveCode on 13/7/16.
 */
public class NextGreater {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(0, -1);
        int size = a.size()-1;
        stack.push(a.get(size));
        while ( size-- > 0) {
            int peek = stack.peek();
            while (!stack.isEmpty() && peek <= a.get(size)) {
                stack.pop();
                if (!stack.isEmpty())
                    peek = stack.peek();
            }
            if (!stack.isEmpty())
                answer.add(0, peek);
            else {
                answer.add(0, -1);

            }
            stack.push(a.get(size));

        }
        return answer;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        int[]data = {39, 27, 11, 4, 24, 32, 32, 1};
        for (int d:data){
            input.add(d);
        }
        NextGreater s = new NextGreater();
        System.out.println(s.nextGreater(input));
    }
}
