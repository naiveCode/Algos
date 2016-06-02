public class KMP {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int ans = -1;
        int checkLength = haystack.length() - needle.length();
        if (checkLength < 0) {
            return ans;
        }
        int[] kpArray = new int[needle.length()];
        int index = 0;
        for (int i = 1; i < needle.length(); ) {
            if (needle.charAt(i) == needle.charAt(index)) {
                kpArray[i] = index + 1;
                i++;
                index++;
            } else {
                if (index != 0) {
                    index = kpArray[index - 1];
                } else {
                    kpArray[i] = 0;
                    i++;
                }
            }

        }
        int cIndex = kpArray[0];
        for (int i = 0; i <= checkLength; i++) {
            if (haystack.charAt(i) == needle.charAt(cIndex)) {
                i++;
                cIndex++;
                if (cIndex == needle.length() - 1) {
                    ans = i;
                    break;
                }
            } else {
                if (cIndex != 0)
                    cIndex = kpArray[cIndex - 1];
            }
        }
        return ans;
    }
}