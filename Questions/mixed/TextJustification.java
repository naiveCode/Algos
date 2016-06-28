import java.util.ArrayList;

public class TextJustification {
    public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0, w; i < A.size(); i = w) {
            int l = -1;
            for (w = i; w < A.size() && A.get(w).length() + 1 + l <= B; w++)
                l += A.get(w).length() + 1;
            StringBuilder sb = new StringBuilder(A.get(i));
            int spaces = 1, extra = 0;
            if (w != i + 1 && w != A.size()) {
                spaces = (B - l) / (w - i - 1) + 1;
                extra = (B - l) % (w - i - 1);
            }
            for (int j = i + 1; j < w; j++) {
                for (int s = 0; s < spaces; s++)
                    sb.append(' ');
                if (extra-- > 0)
                    sb.append(' ');
                sb.append(A.get(j));
            }
            int remaining = B - sb.length();
            while (remaining-- > 0) sb.append(' ');
            list.add(sb.toString());
        }
        return list;
    }
}

