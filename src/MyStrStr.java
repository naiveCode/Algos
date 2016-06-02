/**
 * Created by naiveCode on 8/1/16.
 */
public class MyStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.equals(haystack)){
            return 0;
        }
        boolean needleFound = false;
        int index = -1;
        for (int i = 0; i < haystack.length(); i++) {
            index = i;
            if (needle.charAt(0) == haystack.charAt(i)) {
                int j = 0;
                while (j < needle.length()) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        break;
                    }
                }
                if (j == needle.length()) {
                    needleFound = true;
                }
            }
            if (needleFound) {
                break;
            }
            index = -1;
        }
        return index;
    }
}
