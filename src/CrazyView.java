import java.util.ArrayList;


public class CrazyView {
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < a; i++) {

            int t = a + 1;
            boolean startChanging = true;
            ArrayList<Integer> row = new ArrayList<>(2 * a - 1);
            for (int j = 0; j < 2 * a - 1; j++) {
                if (startChanging) {
                    if (j < a) {
                        t--;
                    } else {
                        t++;
                    }
                }
                if (i == j && (i + j == 2 * a - 1)) {
                    startChanging = true;
                    t++;
                } else if (i == j) {
                    startChanging = false;
                } else if (i + j == 2 * a - 1) {
                    startChanging = true;

                    t++;
                }
                row.add(t);
            }
            ans.add(row);
        }
        int j=ans.size();
        for (int i=ans.size()-2;i>=0;i--){
            ans.add(j++,ans.get(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        CrazyView a = new CrazyView();
        System.out.println(a.prettyPrint(3));
    }
}
