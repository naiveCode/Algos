import java.util.ArrayList;
import java.util.Stack;

public class PrettyJsonPrint {
    public ArrayList<String> prettyJSON(String a) {
        ArrayList<String> ans = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        char[] ch = a.toCharArray();
        StringBuilder addInStart = new StringBuilder();
        StringBuilder temp = null;
        for (int i = 0; i < ch.length; i++) {
            switch (ch[i]) {
                case '{':
                case '[':
                    if (temp != null && temp.toString().replace("\t","").length()!=0)
                        ans.add(temp.toString());
                    temp = new StringBuilder();
                    ans.add(addInStart.toString() + String.valueOf(ch[i]));
                    addInStart.append("\t");
                    temp.append(addInStart);

                    break;
                case '}':
                case ']':
                    if (temp != null && temp.toString().replace("\t","").length()!=0) {
                        ans.add(temp.toString());
                    }
                    temp = new StringBuilder();
                    String t = addInStart.substring(0, addInStart.length() - 1);
                    addInStart = new StringBuilder();
                    addInStart.append(t);

                    if(i+1<ch.length && ch[i+1]==','){
                        ans.add(addInStart.toString() + String.valueOf(ch[i]) + ",");
                        i++;
                    }else {
                        ans.add(addInStart.toString() + String.valueOf(ch[i]));
                    }

                    temp.append(addInStart);
                    break;
                case ',':
                    temp.append(ch[i]);
                    ans.add(temp.toString());
                    temp = new StringBuilder();
                    temp.append(addInStart);
                    break;
                default:
                    temp.append(ch[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PrettyJsonPrint s = new PrettyJsonPrint();
        ArrayList<String> b = s.prettyJSON("{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}");
        for (String p : b) {
            System.out.println(p);
        }
    }
}
