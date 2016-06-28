import java.util.ArrayList;

public class RotateMAtrixBy90Degrees {
    public ArrayList<ArrayList<Integer>> rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(n / 2.0); j++) {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(n - j - 1).get(i));
                a.get(n - j - 1).set(i, a.get(n - i-1).get(n - j - 1));
                a.get(n - i - 1).set(n - j-1, a.get(j).get(n - i - 1));
                a.get(j).set(n - i - 1, temp);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayList<ArrayList<Integer>> abc = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> ro = new ArrayList<>();
            for (int j = 0; j < a.length; j++) {
                ro.add(a[i][j]);
            }
            abc.add(ro);
        }
        RotateMAtrixBy90Degrees p = new RotateMAtrixBy90Degrees();
        System.out.println(p.rotate(abc));
    }
}
