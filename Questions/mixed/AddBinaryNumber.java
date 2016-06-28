public class AddBinaryNumber {
    public String addBinary(String a, String b) {
        int rem = 0;
        char[] x1 = a.toCharArray();
        char[] x2 = b.toCharArray();
        StringBuilder ans = new StringBuilder();
        int i, j;
        for (i = x1.length - 1, j = x2.length - 1; i >= 0 && j >= 0; i--, j--) {
            int l = x1[i] - '0';
            int m = x2[j] - '0';
            int sum = rem + l + m;

            if (sum >= 2) {
                ans.append(sum&1);
                rem = 1;
            } else {
                ans.append(sum);
                rem = 0;
            }
        }
        if (i == -1 && j == -1 && rem == 0) {
            return ans.reverse().toString();
        } else if (i == -1 && j == -1 && rem == 1) {
            return ans.append(1).reverse().toString();
        } else if (i == -1) {
            convert(j, x2, rem, ans);
        } else {
            convert(i, x1, rem, ans);
        }
        return ans.reverse().toString();
    }

    private void convert(int index, char[] x2, int rem, StringBuilder ans) {



        for (int i = index; i >=0; i--) {
            int m = x2[i] - '0';
            int sum = rem + m;
            if (sum >=2) {
                ans.append(sum & 1);
                rem = 1;
            } else {
                ans.append(sum);
                rem = 0;
            }
        }
        if(rem==1)
            ans.append(1);
    }

    public static void main(String[] args) {
        AddBinaryNumber s = new AddBinaryNumber();
        System.out.println(s.addBinary("1","1"));
    }
}
