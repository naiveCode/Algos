import java.util.ArrayList;

public class RemoveDuplicates {
     public int removeDuplicates(ArrayList<Integer> A) {

        int index = 1;
        int count = 1;
        int n = A.size();

        for (int i = 1; i < n; i++) {
            if (A.get(i).intValue() == A.get(i - 1).intValue() && count < 2) {
                A.set(index, A.get(i));
                count++;
                index++;
            } else if (A.get(i).intValue() != A.get(i - 1).intValue()) {
                A.set(index, A.get(i));
                count = 1;
                index++;
            }
        }


        return index;
    }

    public static void main(String[] args) {
        int[] data = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5, 6};
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            al.add(data[i]);
        }
        RemoveDuplicates s = new RemoveDuplicates();
        System.out.println(s.removeDuplicates(al));
    }
}
