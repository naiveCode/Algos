public class ZigZag {
    public String convert(String s, int numRows) {
        StringBuilder[] a = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            a[i] = new StringBuilder();
        }
        for (int i = 0; i < s.length(); i++) {
            int j= i%(numRows+1);
            if (j==numRows) {
                a[(numRows-1) / 2].append(s.charAt(i));
            } else
                a[j].append(s.charAt(i));
        }
        StringBuilder sol = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sol.append(a[i]);
        }
        return sol.toString();
    }

    public static void main(String[] args) {
        ZigZag s = new ZigZag();
        System.out.println(s.convert("ABCD", 2));
        System.out.println(s.convert("ABC", 2));
        System.out.println(s.convert("PAYPALISHIRING",3));
    }
}
//PPIINAASRGYLHI
//PAHNAPLSIIGYIR