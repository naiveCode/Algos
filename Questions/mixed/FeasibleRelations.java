import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by naiveCode on 23/1/16.
 */
public class FeasibleRelations {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTest = Integer.parseInt(br.readLine());
        int test = 0;
        while (test++ != numOfTest) {
            String[] data = br.readLine().split("\\s");
            int N = Integer.parseInt(data[0]);
            int K = Integer.parseInt(data[1]);
            Set<Integer> equalSet = new HashSet<>();
            Set<Integer> unequalSet = new HashSet<>();
            String ans = "YES";
            int i;
            for (i = 0; i < K; i++) {
                data = br.readLine().split("\\s");
                int a = Integer.parseInt(data[0]);
                char operation = data[1].charAt(0);
                int b = Integer.parseInt(data[2]);
//                System.out.println(operation);
                switch (operation) {
                    case '=':
                        if (unequalSet.contains(a) && unequalSet.contains(b)) {
                            ans = "NO";
                            break;
                        }else {
                            equalSet.add(a);
                            equalSet.add(b);
                        }
                        break;
                    case '!':
                        if (equalSet.contains(a) && equalSet.contains(b)) {
                            ans = "NO";
                            break;
                        }else {
                            unequalSet.add(a);
                            unequalSet.add(b);
                        }
                        break;
                }

            }
            for (; i < K; i++) {
                String garbage = br.readLine();
            }
            System.out.println(ans);
        }
    }
}
