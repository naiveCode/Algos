import java.util.ArrayList;
import java.util.HashMap;

public class TwoTwoSumEqual {
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        ArrayList<Integer> leftNu = new ArrayList<>();
        ArrayList<ArrayList<Integer>> mul = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, ArrayList> sumMap = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                if (sumMap.containsKey(a.get(i) + a.get(j))) {
                    ArrayList t = sumMap.get(a.get(i) + a.get(j));
                    ans.addAll(t);
                    ans.add(i);
                    ans.add(j);
                    mul.add(ans);
                    ans = new ArrayList<>();
                } else {
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(i);
                    t.add(j);
                    sumMap.put(a.get(i) + a.get(j), t);
                }
            }
        }

        if (mul.size() == 0) {
            return new ArrayList<>();
        }
        int A = Integer.MAX_VALUE, B = Integer.MAX_VALUE, C = Integer.MAX_VALUE, D = Integer.MAX_VALUE;
        for (int i = 0; i < mul.size(); i++) {
            ArrayList<Integer> temp = mul.get(i);
            int A1 = temp.get(0);
            int B1 = temp.get(1);
            int C1 = temp.get(2);
            int D1 = temp.get(3);
            if ((A1 < A ||
                    A1 == A && B1 < B ||
                    A1 == A && B1 == B && C1 < C ||
                    A1 == A && B1 == B && C1 == C && D1 < D) && (A1!=C1 && B1!=D1 && A1!=D1 && B1!=C1 && A1!=B1 && C1!=D1)) {
                A = A1;
                B = B1;
                C = C1;
                D = D1;
            }

        }

        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(A);
        ret.add(B);
        ret.add(C);
        ret.add(D);
        return ret;
    }

    public static void main(String[] args) {
        TwoTwoSumEqual s  = new TwoTwoSumEqual();
        int [] d ={1, 1, 1, 1, 1 };
        ArrayList<Integer> a = new ArrayList<>();
        for (int i=0;i<d.length;i++){
            a.add(d[i]);
        }

        System.out.println(s.equal(a));
    }
}
