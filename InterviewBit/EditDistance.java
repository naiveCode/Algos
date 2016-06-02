public class EditDistance {
    public int minDistance(String a, String b) {
        int[][] table = new int[a.length() + 1][b.length() + 1];

        //forming empty string
        for (int i = 0; i <= a.length(); i++) {
            table[i][0] = i;
        }
        for (int i = 0; i <= b.length(); i++) {
            table[0][i] = i;
        }
        table[0][0] = 0;

        //finding edit distance
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = 1 + Math.min(table[i - 1][j], Math.min(table[i-1][j-1],table[i][j - 1]));
                }
            }
        }
        return table[a.length()][b.length()];
    }

    public static void main(String[] args) {
        EditDistance s = new EditDistance();
        String b="Anshuman";
        String a = "Antihuman";
        System.out.println(s.minDistance(a,b));
    }
}
