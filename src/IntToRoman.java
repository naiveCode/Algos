/**
 * Created by naiveCode on 14/3/16.
 */
public class IntToRoman {

    /*

    char[] roman = {'I','IV','V','IX','X','XL','L','XC','C','CD','D','CM','M'};
     *//*
    In order for a number written in Roman numerals to be considered valid there are three basic rules which must be followed.

    Numerals must be arranged in descending order of size.
    M, C, and X cannot be equalled or exceeded by smaller denominations.
    D, L, and V can each only appear once.
     */

    public String intToRoman(int number) {
        StringBuilder br = new StringBuilder("");
        while (number != 0) {
            if (number >= 1000) {
                br.append("M");
                number -= 1000;
            } else if (number >= 900) {
                br.append("CM");
                number -= 900;
            } else if (number >= 500) {
                br.append("D");
                number -= 500;
            } else if (number >= 400) {
                br.append("CD");
                number -= 400;
            } else if (number >= 100) {
                br.append("C");
                number -= 100;
            } else if (number >= 90) {
                br.append("XC");
                number -= 90;
            } else if (number >= 50) {
                br.append("L");
                number -= 50;
            } else if (number >= 40) {
                br.append("XL");
                number -= 40;
            } else if (number >= 10) {
                br.append("X");
                number -= 10;
            } else if (number >= 9) {
                br.append("IX");
                number -= 9;
            } else if (number >= 5) {
                br.append("V");
                number -= 5;
            } else if (number >= 4) {
                br.append("IV");
                number -= 4;
            } else if (number >= 1) {
                br.append("I");
                number -= 1;
            }
        }
        return br.toString();
    }

    public static void main(String[] args) {


    }
}
