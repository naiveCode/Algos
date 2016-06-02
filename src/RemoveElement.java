import java.util.ArrayList;

public class RemoveElement {
    public int removeElement(ArrayList<Integer> A, int B) {
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == B) {
                count++;
            } else {
                A.set(i - count, A.get(i));
            }
        }
        for (int i = 0; i < count; i++)
            A.remove(A.size() - 1);
        return A.size();
    }
}
