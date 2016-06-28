import java.util.HashSet;
import java.util.List;

public class DiffPossibleIB {
    public int diffPossible(final List<Integer> a, int b) {
        HashSet<Integer> numberRequiredSet = new HashSet<>();
        for (int c : a) {
            if (numberRequiredSet.contains(c)) {
                return 1;
            } else {
                numberRequiredSet.add(b + c);
                numberRequiredSet.add(c-b);
            }
        }
        return 0;
    }
}
