import java.util.ArrayList;
import java.util.HashMap;

public class DiffPossible {
    public int diffPossible(ArrayList<Integer> a, int b) {
        HashMap<Integer, Point> numberMap = new HashMap<>();
        ArrayList<Point> points = new ArrayList<>();
        boolean moreThanOneCount = false;
        for (int i = 0; i < a.size(); i++) {
            if (!numberMap.containsKey(a.get(i))) {
                Point p = new Point(a.get(i), i);
                points.add(p);
                numberMap.put(a.get(i), p);
            } else {
                numberMap.get(a.get(i)).count++;
                moreThanOneCount = true;
            }
        }
        if (b == 0) {
            if (moreThanOneCount) {
                return 1;
            } else return 0;
        }
        for (int i = 0; i < points.size(); i++) {
            int a1 = points.get(i).value;


            for (int j = i+1; j < points.size(); j++) {
                if (points.get(j).value - a1 == b) {
                    return 1;
                } else if (points.get(j).value - a1 > b) {
                    break;
                }
            }
        }
        return 0;


    }

    class Point {
        int value, index, count;

        Point(int v, int i) {
            value = v;
            index = i;
            count = 1;
        }

    }

    public static void main(String[] args) {
        int[] l = {1, 5};
        DiffPossible s = new DiffPossible();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            a.add(l[i]);
        }
        System.out.println(s.diffPossible(a, 4));
    }
}
