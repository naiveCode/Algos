import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class FourSum {
    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
        if (a.size() < 4)
            return new ArrayList<>();
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i >= 0 && i < a.size() - 3; i++) {
            for (int j = i + 1; j < a.size() - 2; j++) {
                int left = j + 1;
                int right = a.size() - 1;
                int remSum = b - (a.get(i) + a.get(j));
                HashSet<Integer> numIncludedSet = new HashSet<>();
                while (left < right) {
                    if(numIncludedSet.contains(a.get(left))){
                        left++;
                        continue;
                    }
                    int sum = a.get(left) + a.get(right);
                    if (sum == remSum) {
                        ArrayList<Integer> t = new ArrayList<>();
                        t.add(a.get(i));
                        t.add(a.get(j));
                        t.add(a.get(left));
                        t.add(a.get(right));
                        numIncludedSet.add(a.get(left));
                        numIncludedSet.add(a.get(right));
                        right--;

                        left++;

                        result.add(t);
                    } else if (sum > remSum) {
                        if(Objects.equals(a.get(right), a.get(right - 1))){
                            while (left<right && Objects.equals(a.get(right), a.get(right - 1))) {
                                right--;
                            }
                        }else {
                            right--;
                        }


                    } else {
                        if(Objects.equals(a.get(left), a.get(left + 1))){
                            while (left<right && Objects.equals(a.get(left), a.get(left + 1))) {
                                left++;
                            }
                        }else {
                            left++;
                        }

                    }
                }
                while (j + 1 < a.size() - 2 && Objects.equals(a.get(j), a.get(j + 1))) {
                    j++;
                }
            }
            while (i + 1 < a.size() - 3 && Objects.equals(a.get(i), a.get(i + 1))) {
                i++;
            }
        }
        return result;
    }
}

