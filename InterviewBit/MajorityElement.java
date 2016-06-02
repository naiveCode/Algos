import java.util.Collections;
import java.util.List;

public class MajorityElement {
    public int majorityElement(final List<Integer> a) {
        Collections.sort(a);
        return a.get(a.size()/2);
    }
}
