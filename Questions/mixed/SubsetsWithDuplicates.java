import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class SubsetsWithDuplicates {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
        Collections.sort(a);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        ans.add(t);
//        for (int i=0;i<a.size();i++){
            t = new ArrayList<>();
//            t.add(a.get(0));
//            ans.add(t);
            helper(0,a,ans,t);
//        }
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

        int uneqCount = 1;
        while (i+uneqCount<a.size() && Objects.equals(a.get(i), a.get(i + uneqCount))){
            uneqCount++;
        }
        if(i+uneqCount<a.size()){
            temp = new ArrayList<>(t);
            helper(i+uneqCount,a,ans,temp);

        }

    }
}
