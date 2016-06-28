package interviewbit;

public class RegularExpressionMatch {
    public int isMatch(final String s, final String p) {
        boolean[][] table = new boolean[s.length() + 1][p.length() + 1];
        table[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            table[i][0] = false;
        }
        for (int i = 1; i < p.length(); i++) {
            if(p.charAt(i-1)=='*'){
                table[0][i] |= table[0][i-1];
            }else
            table[0][i] = false;


        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j-1) == '?') {
                    table[i][j] = table[i - 1][j - 1];
                } else if (p.charAt(j-1) == '*') {
                    table[i][j] = table[i-1][j] | table[i][j-1] | table[i-1][j-1];
                }else {
                    table[i][j] = false;
                }
            }
        }
        return (table[s.length()][p.length()])?1:0;
    }
}
