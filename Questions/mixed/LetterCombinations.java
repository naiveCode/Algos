import java.util.ArrayList;

public class LetterCombinations {
    public ArrayList<String> letterCombinations(String a) {
        ArrayList<String > ans = new ArrayList<>();
        StringBuilder b = new StringBuilder();
        helper(a,b,ans);
        return ans;
    }

    private void helper(String a, StringBuilder b, ArrayList<String> ans) {
        if(a.length()==0){
            ans.add(b.toString());
            return;
        }
        char[]data = a.toCharArray();
        StringBuilder t ;
        
            char c = data[0];
            switch (c){
                case '1':
                case '0':b.append(c);
                    helper(a.substring(1),b,ans);
                    break;

                case '2':
                    t = new StringBuilder(b);
                    t.append('a');
                    helper(a.substring(1),t,ans);

                    t = new StringBuilder(b);
                    t.append('b');
                    helper(a.substring(1),t,ans);
                    t = new StringBuilder(b);
                    t.append('c');
                    helper(a.substring(1),t,ans);


                    break;
                case '3':
                    t = new StringBuilder(b);
                    t.append('d');
                    helper(a.substring(1),t,ans);

                    t = new StringBuilder(b);
                    t.append('e');
                    helper(a.substring(1),t,ans);
                    t = new StringBuilder(b);
                    t.append('f');
                    helper(a.substring(1),t,ans);

                    break;
                case '4':
                    t = new StringBuilder(b);
                    t.append('g');
                    helper(a.substring(1),t,ans);

                    t = new StringBuilder(b);
                    t.append('h');
                    helper(a.substring(1),t,ans);
                    t = new StringBuilder(b);
                    t.append('i');
                    helper(a.substring(1),t,ans);
                    break;
                case '5':
                    t = new StringBuilder(b);
                    t.append('j');
                    helper(a.substring(1),t,ans);

                    t = new StringBuilder(b);
                    t.append('k');
                    helper(a.substring(1),t,ans);
                    t = new StringBuilder(b);
                    t.append('l');
                    helper(a.substring(1),t,ans);
                    break;
                case '6':
                    t = new StringBuilder(b);
                    t.append('m');
                    helper(a.substring(1),t,ans);

                    t = new StringBuilder(b);
                    t.append('n');
                    helper(a.substring(1),t,ans);
                    t = new StringBuilder(b);
                    t.append('o');
                    helper(a.substring(1),t,ans);
                    break;
                case '8':
                    t = new StringBuilder(b);
                    t.append('t');
                    helper(a.substring(1),t,ans);

                    t = new StringBuilder(b);
                    t.append('u');
                    helper(a.substring(1),t,ans);
                    t = new StringBuilder(b);
                    t.append('v');
                    helper(a.substring(1),t,ans);
                    break;

                case '7':
                    t = new StringBuilder(b);
                    t.append('p');
                    helper(a.substring(1),t,ans);

                    t = new StringBuilder(b);
                    t.append('q');
                    helper(a.substring(1),t,ans);
                    t = new StringBuilder(b);
                    t.append('r');
                    helper(a.substring(1),t,ans);
                    t = new StringBuilder(b);
                    t.append('s');
                    helper(a.substring(1),t,ans);
                    break;
                case '9':
                    t = new StringBuilder(b);
                    t.append('w');
                    helper(a.substring(1),t,ans);

                    t = new StringBuilder(b);
                    t.append('x');
                    helper(a.substring(1),t,ans);
                    t = new StringBuilder(b);
                    t.append('y');
                    helper(a.substring(1),t,ans);
                    t = new StringBuilder(b);
                    t.append('z');
                    helper(a.substring(1),t,ans);

                    break;
                default:
            }
        
    }
}
