import java.util.ArrayList;

public class WordBreak {
    public int wordBreak(String a, ArrayList<String> b) {
        boolean[] presence = new boolean[a.length() + 1];
        presence[0] = true;
        for (int i = 0; i < a.length(); i++) {
            if (presence[i]) {
                for (String c : b) {
                    int len = c.length();
                    if (i + len <= a.length()) {
                        if (c.contentEquals(a.substring(i, i + len))) {
                            presence[i + len] = true;
                        }
                    }
                }
            }
        }
        return (presence[a.length()]) ? 1 : 0;
    }
}
