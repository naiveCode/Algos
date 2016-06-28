import java.util.Stack;

public class ValidateBraces {
    public int braces(String a) {
        Stack<Character> stack = new Stack<>();
        int ct=0;
        for (char b : a.toCharArray()) {
            if(b != ')')
                stack.push(b);
            else
            {
                ct = 0;
                while(stack.size()!=0 && stack.peek() != '(')
                {
                    stack.pop();
                    ct++;
                }
                stack.pop();
                if(ct == 0 || ct == 1)
                    return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ValidateBraces s = new ValidateBraces();
        System.out.println(s.braces("(a)"));
    }
}
