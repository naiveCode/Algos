public class KMPAlgo {
    public int strStr(final String haystack, final String needle) {
        if (haystack.length() == 0 || needle.length() == 0) {
            return -1;
        }
        int[] lsp = new int[needle.length()];
        char[] needlaeArray = needle.toCharArray();
        int i = 1, j = 0;

        while (i < lsp.length) {
            if (needlaeArray[i] == needlaeArray[j]) {
                lsp[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lsp[j - 1];
                } else {
                    i++;
                }

            }
        }
        char[] haystackArray = haystack.toCharArray();
        i = 0;
        j = 0;
        while (i < haystackArray.length && j < needlaeArray.length) {
            if (haystackArray[i] == needlaeArray[j]) {
                i++;
                j++;
            } else {
                if (j != 0)
                    j = lsp[j - 1];
                else {

                    i++;
                }
            }
        }
        if(j==needlaeArray.length){
            return i-needlaeArray.length;
        }else return -1;
    }

    public static void main(String[] args) {
        KMPAlgo s = new KMPAlgo();
        System.out.println(s.strStr("naive","naiveCode"));
    }
}
