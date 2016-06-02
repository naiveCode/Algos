import java.util.ArrayList;
import java.util.Collections;

public class Max3Product {
    public int maxp3(ArrayList<Integer> a) {
        Collections.sort(a);

        int t1 = a.get(0)*a.get(1)*a.get(a.size()-1);
        int t2 = a.get(a.size()-1)*a.get(a.size()-2)*a.get(a.size()-3);
        return t1>t2?t1:t2;
    }
}
