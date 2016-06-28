import java.util.ArrayList;
import java.util.Stack;

public class EvaluatePostfix {
    public int evalRPN(ArrayList<String> a) {
        Stack<String> stack = new Stack<>();
        for (String s:a){
            if(s.matches("[+-]?\\d+")){
                stack.push(s);
            }else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                switch (s.toCharArray()[0]){
                    case '+':
                        num2+=num1;
                        stack.push(String.valueOf(num2));
                        break;
                    case '-':
                        num2 = num2-num1;
                        stack.push(String.valueOf(num2));
                        break;
                    case '*':
                        num2 *=num1;
                        stack.push(String.valueOf(num2));
                        break;
                    case '/':
                        num2 = num2/num1;
                        stack.push(String.valueOf(num2));
                        break;
                }

            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        String[]arr = { "2", "1", "+", "3", "*" };
        for (int i=0;i<arr.length;i++){
            a.add(arr[i]);
        }
        EvaluatePostfix s = new EvaluatePostfix();
        System.out.println(s.evalRPN(a));
    }
}
