public class InterleaveStringMatch {
    public int isInterleave(String a, String b, String c) {
        int i = 0, j = 0;
        if (a.length() + b.length() != c.length()) {
            return 0;
        }
        for (int k = 0; k < c.length(); k++) {
            if (i < a.length() && a.charAt(i) == c.charAt(k) && j < b.length() && b.charAt(j) == c.charAt(k)) {
                if (i == a.length() - 1) {
                    i++;
                } else if (j == b.length() - 1) {
                    j++;
                } else {
                    if (a.charAt(i + 1) == c.charAt(k + 1)) {
                        i++;
                    } else if (b.charAt(j + 1) == c.charAt(k + 1)) {
                        j++;
                    } else {
                        i++;
                    }
                }
            } else if (i < a.length() && a.charAt(i) == c.charAt(k)) {
                i++;
            } else if (j < b.length() && b.charAt(j) == c.charAt(k)) {
                j++;
            } else {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        InterleaveStringMatch s = new InterleaveStringMatch();
        String c = "eUZCHhXr0SQsCgsB4O3B6TCWCDlAitYIHE7k6H3z8zrphz5EEBlIIAHqSWIY24D";
        String b = "UhSQsB6CWAHE6zzphz5BIAHqSWIY24D";
        String a = "eZCHXr0CgsB4O3TCDlitYI7kH38rEElI";
        System.out.println(s.isInterleave(a, b, c));
    }
}
