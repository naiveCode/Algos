public class DecodingNumber {
    public int numDecodings(String a) {
        if (a == null || a.length() == 0 || a.charAt(0) == '0') {
            return 0;
        }
        int count[] = new int[a.length() + 1]; // A table to store results of subproblems
        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= a.length(); i++) {
            count[i] = 0;

            // If the last digit is not 0, then last digit must add to
            // the number of words
            if (a.charAt(i - 1) > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller than 2 and last digit is
            // smaller than 7, then last two digits form a valid character
            if ((a.charAt(i-2)>'0' && a.charAt(i - 2) < '2') || (a.charAt(i - 2) == '2' && a.charAt(i - 1) < '7'))
                count[i] += count[i - 2];

            if (count[i] == 0) {

                return 0;
            }
        }
        return count[a.length()];
    }

    public static void main(String[] args) {
        DecodingNumber s = new DecodingNumber();
        System.out.println(s.numDecodings("2611055971756562"));
    }

}
