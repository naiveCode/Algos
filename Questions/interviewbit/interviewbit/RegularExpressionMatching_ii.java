package interviewbit;

/**
 * Created by naiveCode on 28/6/16.
 */
public class RegularExpressionMatching_ii {
    public int isMatch(String s, String p) {
        // base case
        if (p.length() == 0) {
            return (s.length() == 0)?1:0;
        }

        // special case
        if (p.length() == 1) {

            // if the length of s is 0, return false
            if (s.length() < 1) {
                return 0;
            }

            //if the first does not match, return false
            else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return 0;
            }

            // otherwise, compare the rest of the string of s and p.
            else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        // case 1: when the second char of p is not '*'
        if (p.charAt(1) != '*') {
            if (s.length() < 1) {
                return 0;
            }
            if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return 0;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        // case 2: when the second char of p is '*', complex case.
        else {
            //case 2.1: a char & '*' can stand for 0 element
            if (isMatch(s, p.substring(2))==1) {
                return 1;
            }

            //case 2.2: a char & '*' can stand for 1 or more preceding element,
            //so try every sub string
            int i = 0;
            while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s.substring(i + 1), p.substring(2))==1) {
                    return 1;
                }
                i++;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching_ii s = new RegularExpressionMatching_ii();
        System.out.println(s.isMatch("a", "."));
    }
}
