import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FormLargestNumberWithArrayDigits {
    // DO NOT MODIFY THE LIST
    public String largestNumber(final List<Integer> a) {
        List<String> b = new LinkedList<>();
        for (int i = 0; i < a.size(); i++) {
            b.add(String.valueOf(a.get(i)));
        }
        String[] c = new String[b.size()];
        b.toArray(c);
        Arrays.sort(c, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s = o1+o2;
                String t = o2+o1;
                return s.compareTo(t);
            }
        });
        StringBuilder s = new StringBuilder();
        int i=c.length-1;
        while (i>=0 && c[i].contentEquals("0")){
            i--;
        }
        if(i==-1)
            return "0";
        for (; i >=0; i--) {
            s.append(c[i]);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        int[] da = {782, 240, 409, 678, 940, 502, 113, 686, 6, 825, 366, 686, 877, 357, 261, 772, 798, 29, 337, 646, 868, 974, 675, 271, 791, 124, 363, 298, 470, 991, 709, 533, 872, 780, 735, 19, 930, 895, 799, 395, 905 };
        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < da.length; i++)
            l.add(da[i]);
        FormLargestNumberWithArrayDigits a = new FormLargestNumberWithArrayDigits();
        System.out.println(a.largestNumber(l));
        System.out.println();
    }
}
