package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class CanCompleteCircuit {
    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        int endIndex = -1;

        for (int i = 0; i < gas.size(); i++) {
            int availableGas = 0;
            int count = 0;

            for (int j = i; count <= cost.size(); j = (j + 1) % cost.size()) {
                count++;
                availableGas += gas.get(j);

                if (availableGas - cost.get(j) >= 0) {
                    availableGas = availableGas - cost.get(j);
                } else {
                    availableGas = availableGas - cost.get(j);
                    break;
                }

            }
//            System.out.println(availableGas);
            if (count == cost.size() &&availableGas>=0) {
                endIndex = i;
                break;
            }
        }
        return endIndex;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        int[] c = {684, 57, 602, 987};
        int[] d = {909, 535, 190, 976};
        for (int i = 0; i < c.length; i++) {
            a.add(c[i]);
            b.add(d[i]);
        }
        CanCompleteCircuit s = new CanCompleteCircuit();
        System.out.println(s.canCompleteCircuit(a, b));
    }
}
