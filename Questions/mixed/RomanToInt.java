/**
 * Created by naiveCode on 14/3/16.
 */
public class RomanToInt {

    /*

char[] roman = {'I','IV','V','IX','X','XL','L','XC','C','CD','D','CM','M'};
     */
    /*
    I 	1
    V 	5
    X 	10
    L 	50
    C 	100
    D 	500
    M 	1,000
     */
    public int romanToInt(String a) {
        int prev = 1001;
        int ans = 0;
        for (char b : a.toCharArray()) {
            int t = getIntValue(b);
            if(t<=prev){
                ans += t;
            }else {
                ans += t -prev - prev;
            }
            prev=t;
        }
        return ans;
    }

    public static void main(String[] args) {
        RomanToInt a = new RomanToInt();
        System.out.println(a.romanToInt(""));
        System.out.println(a.romanToInt("XI"));
        System.out.println(a.romanToInt("XII"));
        System.out.println(a.romanToInt("XIII"));
        System.out.println(a.romanToInt("XIV"));
        System.out.println(a.romanToInt("XV"));
        System.out.println(a.romanToInt("XVI"));
        System.out.println(a.romanToInt("XVII"));
        System.out.println(a.romanToInt("XVIII"));
        System.out.println(a.romanToInt("XIX"));
        System.out.println(a.romanToInt("MMCDLXXV"));


    }

    private int getIntValue(char b) {
        int l = 0;
        switch (b) {
            case 'I':
                l = 1;
                break;
            case 'V':
                l = 5;
                break;
            case 'X':
                l = 10;
                break;
            case 'L':
                l = 50;
                break;
            case 'C':
                l = 100;
                break;
            case 'D':
                l = 500;
                break;
            case 'M':
                l = 1000;
                break;
        }
        return l;
    }
}
