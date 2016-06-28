import java.util.ArrayList;

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        helper(1, n, k, ans, t,k);
        return ans;
    }

    private void helper(int i, int n, int k, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> t, int k1) {
        if (k == 0 && t.size()==k1) {
            ans.add(t);
            return;
        }
        if(i>n){
            return;
        }
        for (int j=i;j<=n;j++) {
            ArrayList<Integer> temp = new ArrayList<>(t);
            temp.add(j);
            helper(j + 1, n, k - 1, ans, temp, k1);
            temp = new ArrayList<>(t);
            helper(j + 1, n, k - 1, ans, temp, k1);
        }
    }
}
