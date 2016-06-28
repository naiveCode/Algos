import java.util.ArrayList;

public class UniquePathWithObstaclesInAnArray {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
        if (a == null || a.size() == 0 || a.get(0).get(0) == 1) {
            return 0;
        }
        a.get(0).set(0, 1);

        for (int i = 1; i < a.get(0).size(); i++) {
            if (a.get(0).get(i) == 1) {
                a.get(0).set(i, 0);
            } else
                a.get(0).set(i, a.get(0).get(i - 1));
        }
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).get(0) == 1) {
                a.get(i).set(0, 0);
            } else
                a.get(i).set(0, a.get(i - 1).get(0));
        }
        for (int i = 1; i < a.size(); i++) {
            for (int j = 1; j < a.get(0).size(); j++) {
                if (a.get(i).get(j) == 1) {
                    a.get(i).set(j, 0);
                } else {
                    a.get(i).set(j, a.get(i - 1).get(j) + a.get(i).get(j - 1));
                }
            }
        }
        return a.get(a.size() - 1).get(a.get(0).size() - 1);
    }
}
