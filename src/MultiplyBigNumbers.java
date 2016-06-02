

public class MultiplyBigNumbers {
    public String multiply(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == 0 || len2 == 0) {
            return "";
        }
        if ((len1 == 1 && Integer.parseInt(str1) == 0) || (len2 == 1 && Integer.parseInt(str2) == 0)) {
            return "0";
        }
        String[] multTill9 = new String[9];
        StringBuilder fAns = new StringBuilder("0");
        if (len1 > len2) {
            for (int i = 0; i < 9; i++) {
                multTill9[i] = multiplyW(str1, i + 1);
            }

            for (char t : str2.toCharArray()) {
                if ((t - '0') != 0)
                    fAns = addInt(fAns.toString(), multTill9[t - '1']);
                fAns.append("0");

            }
        } else {
            for (int i = 0; i < 9; i++) {
                multTill9[i] = multiplyW(str2, i + 1);
            }

            for (char t : str1.toCharArray()) {
                if ((t - '0') != 0)
                    fAns = addInt(fAns.toString(), multTill9[t - '1']);
                fAns.append("0");

            }
        }
        int index = 0;
        for (int i=0;i<fAns.length();i++){
            if(fAns.charAt(i)!='0'){
                break;
            }
            index++;
        }
        return fAns.substring(index, fAns.length() - 1);
        //1000089999
        //9999800001
        //9999800001
    }

    private StringBuilder addInt(String a, String b) {
        int rem = 0;
        char[] x1 = a.toCharArray();
        char[] x2 = b.toCharArray();
        StringBuilder ans = new StringBuilder();
        int i, j;
        for (i = x1.length - 1, j = x2.length - 1; i >= 0 && j >= 0; i--, j--) {
            int l = x1[i] - '0';
            int m = x2[j] - '0';
            int sum = rem + l + m;

            if (sum > 9) {
                ans.append(sum % 10);
                rem = sum / 10;
            } else {
                ans.append(sum);
                rem = 0;
            }
        }
        if (i == -1 && j == -1 && rem == 0) {
            return ans.reverse();
        } else if (i == -1 && j == -1 && rem == 1) {
            return ans.append(1).reverse();
        } else if (i == -1) {
            convert(j, x2, rem, ans);
        } else {
            convert(i, x1, rem, ans);
        }
        return ans.reverse();
    }

    private void convert(int index, char[] x2, int rem, StringBuilder ans) {


        for (int i = index; i >= 0; i--) {
            int m = x2[i] - '0';
            int sum = rem + m;
            if (sum > 9) {
                ans.append(sum % 10);
                rem = 1;
            } else {
                ans.append(sum);
                rem = 0;
            }
        }
        if (rem == 1)
            ans.append(1);
    }

    private String multiplyW(String str1, int i) {
        int rem = 0;
        StringBuilder ans = new StringBuilder();
        for (int l = str1.length() - 1; l >= 0; l--) {
            int a = str1.charAt(l) - '0';
            int mul = a * i + rem;
            if (mul > 9) {
                rem = mul / 10;
                ans.append(mul % 10);
            } else {
                ans.append(mul);
                rem = 0;
            }
        }
        if (rem != 0) {
            ans.append(rem);
        }
        return ans.reverse().toString();

    }


    public static void main(String[] args) {
        MultiplyBigNumbers s = new MultiplyBigNumbers();
        System.out.println(s.multiply("6020453667958309279424408570378228292268488402", "0021473700594524297017810575200827941459805716642468749607585313713214621412"));
    }
}
