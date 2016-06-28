import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SearchRange {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int left = 0, right = a.size() - 1, middle = 0;
        boolean elFound = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.re
        while (left <= right) {
            middle = (left + right) / 2;
            if (a.get(middle) == b) {
                elFound = true;
                break;
            } else if (a.get(middle) > b) {
                right = middle - 1;
            } else {

                left = middle + 1;
            }
        }
        if (!elFound) {
            ArrayList<Integer> c = new ArrayList<>();
            c.add(-1);
            c.add(-1);
            return c;
        }
        left = 0;
        right = middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (a.get(middle) == b) {

            } else {

                left = middle + 1;
            }
        }
        right = middle;
        while (right < a.size() && a.get(middle) == a.get(right)) {
            right++;
        }
        ArrayList<Integer> c = new ArrayList<>();
        c.add(left + 1);
        c.add(right - 1);
        return c;
    }

    public static void main(String[] args) {
        int[] d = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < d.length; i++) {
            a.add(d[i]);
        }
        SearchRange s = new SearchRange();
        System.out.println(s.searchRange(a, 10));
    }
}
