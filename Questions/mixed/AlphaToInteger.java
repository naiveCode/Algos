public class AlphaToInteger {
    public int atoi(final String a) {
        long max = 0x7fffffff;
        long ans = 0;
        int sign = 1;
        boolean signFound = false;
        boolean firstNonSpaceFound = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) >= '0' && a.charAt(i) <= '9') {
                firstNonSpaceFound = true;
                if(sign == 1 && (a.charAt(i) - '0') + (10 * ans) > max){
                    ans = max;
                    return (int) ans;
                }

                if(sign == -1 && (a.charAt(i) - '0') + (10 * ans) > max){
                    ans = max+1;
                    return (int) ans;
                }

                ans = (a.charAt(i) - '0') + (10 * ans);

            } else if (a.charAt(i) == '-' && !signFound) {
                firstNonSpaceFound = true;
                signFound = true;
                sign = -1;
            } else if (a.charAt(i) == '+' && !signFound) {
                firstNonSpaceFound = true;
                signFound = true;
                sign = +1;
            }else if(!firstNonSpaceFound && a.charAt(i)==' '){
                continue;
            }
            else {
                break;
            }
        }
        return ((int) (sign * ans));
    }

    public static void main(String[] args) {
        AlphaToInteger a = new AlphaToInteger();
        System.out.println(a.atoi("-5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3 5 14703818 776366059B9O43393"));
    }
}
