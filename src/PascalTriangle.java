import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        if(numRows == 0){
            return ans;
        }
        int []a = {1};
        row.add(a[0]);
        ans.add(row);
        for (int i=1;i<numRows;i++){
            row = new ArrayList<>();
            int []t = new int[a.length+1];
            t[0] = a[0];
            row.add(t[0]);
            for (int j=1;j<a.length;j++){
                t[j] = a[j] + a[j-1];
                row.add(t[j]);
            }
            t[a.length] = a[a.length-1];
            row.add(t[a.length]);
            a = t;
            ans.add(row);
        }
        return ans;
    }
    public class Solution {
        public ArrayList<Integer> getRow(int a) {
            ArrayList<Integer> ans = new ArrayList<>();


            int []b = {1};


            for (int i=1;i<=a;i++){

                int []t = new int[b.length+1];
                t[0] = b[0];

                for (int j=1;j<b.length;j++){
                    t[j] = b[j] + b[j-1];

                }
                t[b.length] = b[b.length-1];

                b = t;

            }
            for (int i=0;i<b.length;i++){
                ans.add(b[i]);
            }

            return ans;
        }
    }


    public static void main(String[] args) {
        PascalTriangle ans = new PascalTriangle();
        System.out.println(ans.generate(3));
    }
}