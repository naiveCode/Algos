import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by naiveCode on 18/2/16.
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {

        if (points.length <= 1) {
            return points.length;
        }


        Slope[] slopes = new Slope[(points.length * (points.length - 1)) / 2];
        int index = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i; j < points.length; j++) {
                int x = Math.abs(points[i].x - points[j].x);
                int y = Math.abs(points[i].y - points[j].y);
                int gcd = gcd(x, y);
                slopes[index++] = new Slope(i, j, y / gcd, x / gcd);
            }
        }
        Arrays.sort(slopes, new Comparator<Slope>() {
            @Override
            public int compare(Slope o1, Slope o2) {
                return o1.y / o1.x - o2.y / o2.x;
            }
        });
        return 0;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    class Slope implements Comparable<Slope> {
        int x, y;
        int n, d;

        Slope(int x, int y, int t, int b) {
            this.x = x;
            this.y = y;
            n = t;
            d = b;
        }

        @Override
        public int compareTo(Slope o) {
            return this.y / this.x - o.y / o.x;
        }
    }

    public static void main(String[] args) {
        MaxPointsOnALine p = new MaxPointsOnALine();
        Point[] q = new Point[5];
        q[0] = new Point(0, 0);
        q[1] = new Point(1, 1);
        p.maxPoints(q);
    }
}

class ModPoint extends Point {

}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}
