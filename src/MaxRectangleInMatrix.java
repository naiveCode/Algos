import java.util.ArrayList;
import java.util.Stack;

public class MaxRectangleInMatrix {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
        //max area in histogram
        int area = 0;
        int maxArea = 0;
        for (int i = 0; i < a.get(0).size(); i++) {
            if (a.get(0).get(i) == 1) {
                area++;
                if (area > maxArea) {
                    maxArea = area;
                }
            } else {
                area = 0;
            }


        }

        for (int i = 1; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) != 0) {
                    a.get(i).set(j, a.get(i).get(j) + a.get(i - 1).get(j));
                }
            }
            int areaT = maxAreaInHistogram(a.get(i));
            if (areaT > maxArea) {
                maxArea = areaT;
            }
        }
        return maxArea;
    }

    private int maxAreaInHistogram(ArrayList<Integer> integers) {
        Stack<Integer> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        while (i < integers.size())
            if (st.isEmpty() || integers.get(st.peek()) <= integers.get(i)) {
                st.push(i++);
            } else {

                int top = st.pop();
                int tArea = integers.get(top) * (st.isEmpty() ? i : (i - st.peek() - 1));
                if (tArea > maxArea) {
                    maxArea = tArea;
                }
            }


        while (!st.isEmpty())

        {
            int top = st.pop();
            int tArea = integers.get(top) * (st.isEmpty() ? i : (i - st.peek() - 1));
            if (tArea > maxArea) {
                maxArea = tArea;
            }

        }

        return maxArea;

    }

    public static void main(String[] args) {
        MaxRectangleInMatrix s = new MaxRectangleInMatrix();
        int[][] data = {
                {0, 0, 1, 0, 0, 0, 1, 0, 1},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 1, 0, 1},
                {0, 1, 0, 0, 0, 0, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 0, 1},

        };

        ArrayList<ArrayList<Integer>> d = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            ArrayList<Integer> t = new ArrayList<>();
            for (int j = 0; j < data[0].length; j++) {
                t.add(data[i][j]);
            }
            d.add(t);
        }
        System.out.println(s.maximalRectangle(d));
    }
}
