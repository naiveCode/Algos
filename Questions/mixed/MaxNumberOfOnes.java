import java.util.ArrayList;

public class MaxNumberOfOnes {
    public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
        int numberOfZeroes = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int maxSize = Integer.MIN_VALUE;
        int maxSizeIndex = 0;
        for (int i = 0; i < a.size(); i++) {

            if (a.get(i) == 0) {
                numberOfZeroes++;
            }

            ans.add(a.get(i));
            if (numberOfZeroes > b) {
                while (numberOfZeroes > b) {
                    if (ans.get(0) == 0) {
                        ans.remove(0);
                        numberOfZeroes--;
                    } else {
                        ans.remove(0);
                    }
                }

            }
            if (maxSize < ans.size()) {
                maxSize = ans.size();
                maxSizeIndex = i;
            }

        }
        ArrayList<Integer> x = new ArrayList<>();
        for (int i1 = maxSizeIndex - maxSize; i1 < maxSizeIndex; i1++) {
            x.add(i1 + 1);
        }
        return x;
    }

    public static void main(String[] args) {
        int a[] = {0, 1, 1, 1};
        ArrayList<Integer> p = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            p.add(a[i]);
        }
        MaxNumberOfOnes s = new MaxNumberOfOnes();
        System.out.println(s.maxone(p, 0));
    }
}

