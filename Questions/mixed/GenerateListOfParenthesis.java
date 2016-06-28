import java.util.LinkedList;
import java.util.List;

/**
 * Created by naiveCode on 3/2/16.
 */
public class GenerateListOfParenthesis {

    public List<String> generateParenthesis(int n) {
        StringBuilder str = new StringBuilder();
        str.append("(");

        ans = new LinkedList<>();
        helperBuilder(str, n - 1, n);
        return ans;
    }

    List<String> ans;

    private void helperBuilder(StringBuilder str, int n, int i) {
        if (n >= i - 1 ) {
            helperBuilder(str.append("("), n - 1, i);

        }
        if (n >= i - 1 && i > 0)
            helperBuilder(str.append(")"), n, i - 1);


        if (n == 0 && i == 0) {
            System.out.println(str);
            ans.add(str.reverse().toString());
        }

    }

    public static void main(String[] args) {
        GenerateListOfParenthesis a = new GenerateListOfParenthesis();
        a.generateParenthesis(3);
    }
}
