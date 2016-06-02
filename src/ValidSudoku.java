import java.util.HashSet;
import java.util.List;

public class ValidSudoku {
    public int isValidSudoku(final List<String> a) {
        HashSet<Integer>[] squareSet = new HashSet[9];
        HashSet<Integer>[] rowSet = new HashSet[9];
        HashSet<Integer>[] colSet = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            squareSet[i] = new HashSet<>();
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }
        for (int i = 0; i < a.size(); i++) {
            String row = a.get(i);
            for (int j = 0; j < row.length(); j++) {
                int digitSetNuber = (i/3)*3 + j / 3;
                int n = row.charAt(j) - '0';
                if (n >= 1 && n <= 9) {
                    if (squareSet[digitSetNuber].contains(n) || rowSet[i].contains(n) || colSet[j].contains(n)) {
                        return 0;
                    } else {
                        squareSet[digitSetNuber].add(n);
                        rowSet[i].add(n);
                        colSet[j].add(n);
                    }
                }
            }
        }
        return 1;
    }
}
