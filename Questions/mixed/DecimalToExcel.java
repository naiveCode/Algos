public class DecimalToExcel {
    public String convertToTitle(int n) {
        char a;
        String res = "";
        if (n < 26) {
            a = (char) ('A' + (n - 1) % 26);
            res += a;
            n = n / 26;
        }
        while (n > 26) {
            a = (char) ('A' + (n - 1) % 26);
            res += a;
            n = (n-1) / 26;
        }
        if (n > 0) {
            a = (char) ('A' + (n - 1) % 26);
            res += a;
        }
        StringBuilder input1 = new StringBuilder();


        input1.append(res);
        input1 = input1.reverse();

        return input1.toString();
    }
//    a = (char) ('A' + (n - 1) % 26);

    public static void main(String[] args) {
        DecimalToExcel a = new DecimalToExcel();
        System.out.println(a.convertToTitle(1));
        System.out.println(a.convertToTitle(5));
        System.out.println(a.convertToTitle(26));
        System.out.println(a.convertToTitle(27));
        System.out.println(a.convertToTitle(28));
        System.out.println(a.convertToTitle(756));
        System.out.println(a.convertToTitle(758));
        System.out.println(a.convertToTitle(676));
        System.out.println(a.convertToTitle(52));
/*A
E
Z
AA
AB
ACB
ACD
YZ
 */


    }
}
