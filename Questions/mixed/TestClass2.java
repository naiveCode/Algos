import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by naiveCode on 21/2/16.
 */
public class TestClass2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        int test = 0;
        while (test++ != tests) {
            int N = Integer.parseInt(br.readLine());
            String[] data = br.readLine().split("\\s");
            Set<Integer> dataSet = new HashSet<>();
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(data[i]);
                dataSet.add(n);
            }
            Set<Set<Integer>> resultSet = powerSet(dataSet);
            long max = Integer.MIN_VALUE;
            long elements = 0;
            //P = (XOR of all of the values in subset) OR (AND of all of the values in subset)
            for (Set<Integer> a : resultSet) {

                long xor = -1;
                long and = -1;
                for (int d : a) {
                    if (xor != -1) {
                        xor ^= d;
                        and &= d;
                    } else {
                        xor = d;
                        and = d;
                    }
                }
                if ((xor|and) >= max) {
                    max = xor|and;
                    if(elements<a.size())
                        elements = a.size();
                }

            }
            System.out.println(max+ " " + elements);


        }
    }

    public static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
