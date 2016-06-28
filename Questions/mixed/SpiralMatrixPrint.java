import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrixPrint {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        int T=0,B=a.size()-1,L=0,R=a.get(0).size()-1;
        int dir = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        // Populate result;
        while (T<=B&& L<=R){
            switch (dir){
                case 0:
                    for (int i=L;i<=R;i++){
                        ans.add(a.get(T).get(i));
                    }
                    T++;
                    dir = 1;
                    break;
                case 1:
                    for (int i=T;i<=B;i++){
                        ans.add(a.get(i).get(R));
                    }
                    R--;
                    dir = 2;
                    break;
                case 2:

                    for (int i=R;i>=L;i--){
                        ans.add(a.get(B).get(i));
                    }
                    B--;
                    dir = 3;
                    break;
                case 3:

                    for (int i=B;i>=T;i--){
                        ans.add(a.get(i).get(L));
                    }
                    L++;
                    dir = 0;
                    break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrixPrint b = new SpiralMatrixPrint();
        List<ArrayList<Integer>> l = new LinkedList<>();
        for (int i=0;i<a.length;i++){
            ArrayList<Integer> t = new ArrayList<>();
            for (int j=0;j<a[0].length;j++){
                t.add(a[i][j]);
            }
            l.add(t);

        }
        SpiralMatrixPrint p = new SpiralMatrixPrint();
        System.out.println(p.spiralOrder(l));
    }
}
