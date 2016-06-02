import java.util.ArrayList;
import java.util.Collections;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        Collections.sort(a);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        ans.add(t);
        for (int i=0;i<a.size();i++){
            t = new ArrayList<>();
            t.add(a.get(i));
            ans.add(t);
            helper(i+1,a,ans,t);
        }
        return ans;
    }

    private void helper(int i, ArrayList<Integer> a, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> t) {
        if(i>=a.size()){
//            ans.add(t);
            return;
        }
        ArrayList<Integer> temp = new ArrayList<>(t);
        temp.add(a.get(i));
        ans.add(temp);
        helper(i+1,a,ans,temp);

        temp = new ArrayList<>(t);
        helper(i+1,a,ans,temp);

    }
}
