import java.util.ArrayList;
import java.util.HashSet;

public class SolveSudoku {
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {

        ArrayList<int[]> blankSpace = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            ArrayList<Character> row = a.get(i);
            for (int j = 0; j < row.size(); j++) {
                int n = row.get(j) - '0';
                if (n >= 1 && n <= 9) {

                } else {
                    int p[] = {i, j};
                    blankSpace.add(p);
                }
            }
        }

        helper(blankSpace, a);


    }

    private boolean helper(ArrayList<int[]> blankSpace, ArrayList<ArrayList<Character>> a) {

        ArrayList<int[]> temp = new ArrayList<>(blankSpace);
        if (temp.size() == 0) {
            return true;
        }
        int[] t = temp.get(0);
        temp.remove(0);
        int row = t[0];
        int col = t[1];
        for (int i = 0; i < 9; i++) {
            a.get(row).set(col, (char) ('1' + i));
            if (isValidSudoku(a)) {
                if (helper(temp, a))
                    return true;
            }
        }
        a.get(row).set(col, '.');
        return false;

    }

    private boolean isValidSudoku(ArrayList<ArrayList<Character>> a) {
        HashSet<Integer>[] squareSet = new HashSet[9];
        HashSet<Integer>[] rowSet = new HashSet[9];
        HashSet<Integer>[] colSet = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            squareSet[i] = new HashSet<>();
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }
        for (int i = 0; i < a.size(); i++) {
            ArrayList<Character> row = a.get(i);
            for (int j = 0; j < row.size(); j++) {
                int digitSetNuber = (i / 3) * 3 + j / 3;
                int n = row.get(j) - '0';
                if (n >= 1 && n <= 9) {
                    if (squareSet[digitSetNuber].contains(n) || rowSet[i].contains(n) || colSet[j].contains(n)) {
                        return false;
                    } else {
                        squareSet[digitSetNuber].add(n);
                        rowSet[i].add(n);
                        colSet[j].add(n);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolveSudoku s = new SolveSudoku();
        ArrayList<ArrayList<Character>> te = new ArrayList<>();
        String[] t = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        ArrayList<ArrayList<Character>> c  = new ArrayList<>();
        for (int i=0;i<9;i++){
            ArrayList<Character> p = new ArrayList<>();
            for (int j=0;j<9;j++){
                p.add(t[i].charAt(j));
            }
            te.add(p);
        }

        s.solveSudoku(te);
    }
}
