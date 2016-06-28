import java.util.ArrayList;
import java.util.Collections;


public class NextPrmutation {
    public void nextPermutation(ArrayList<Integer> a) {
        int i;
        for (i = a.size() - 1; i > 0; i--) {
            if (a.get(i) > a.get(i - 1)) {
                break;
            }
        }
        if (i == 0) {
            Collections.sort(a);
            return;
        }
        int j;
        int x = a.get(i - 1), smallest = i;
        for (j = i + 1; j < a.size(); j++) {
            if (a.get(j) > x && a.get(j) < a.get(smallest)) {
                smallest = j;
            }

        }
        int t= a.get(i-1);
        a.set(i-1,a.get(smallest));
        a.set(smallest,t);
        sort(a,i,a.size());
        System.out.println();

    }

    private void sort(ArrayList<Integer> a, int i, int size) {
        for (int j = i; j < size; j++) {
            for (int k = j; k < size; k++) {
                if (a.get(j) > a.get(k)) {
                    int t = a.get(j);
                    a.set(j, a.get(k));
                    a.set(k, t);
                }
            }
        }
    }


    public static void main(String[] args) {
        NextPrmutation s = new NextPrmutation();
        ArrayList<Integer> a = new ArrayList<>();

        int[] arr = {444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52};
        for (int i = 0; i < arr.length; i++) {
            a.add(arr[i]);
        }
        s.nextPermutation(a);
    }
}
