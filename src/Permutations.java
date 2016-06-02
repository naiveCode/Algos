import java.util.ArrayList;

public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[]arr = new int[a.size()];
        for (int i=0;i<a.size();i++){
            arr[i] = a.get(i);
        }
        ArrayList<Integer> intermediate = new ArrayList<>();
        helper(ans,arr,0,a.size()-1);
        return ans;
    }

    void helper(ArrayList<ArrayList<Integer>> ans, int[] a, int l, int r)
    {
        int i;
        if (l == r){
            ArrayList<Integer> t = new ArrayList<>();
            for (int j = 0;j<a.length;j++){
                t.add(a[j]);
            }
            ans.add(t);
        }
//            printf("%s\n", a);
        else
        {
            for (i = l; i <= r; i++)
            {
                swap(a,l, i);
                helper(ans,a, l+1, r);
                swap(a,l,i); //backtrack
            }
        }
    }

    private void swap(int[] a, int l, int i) {
        int t = a[l];
        a[l] = a[i];
        a[i] = t;
    }
}
