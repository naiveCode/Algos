import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by naiveCode on 20/3/16.
 */
public class ThreeSumZero {

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (num.size() < 3)
            return result;

        // sort array
        Collections.sort(num);

        for (int i = 0; i < num.size() - 2; i++) {
            // //avoid duplicate solutions
            if (i == 0 || num.get(i) > num.get(i-1)) {

                int negate = -num.get(i);

                int start = i + 1;
                int end = num.size() - 1;

                while (start < end) {
                    //case 1
                    if (num.get(start) + num.get(end) == negate) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num.get(i));
                        temp.add(num.get(start));
                        temp.add(num.get(end));

                        result.add(temp);
                        start++;
                        end--;
                        //avoid duplicate solutions
                        while (start < end && num.get(end) == num.get(end + 1))
                            end--;

                        while (start < end && num.get(start) == num.get(start - 1))
                            start++;
                        //case 2
                    } else if (num.get(start) + num.get(end) < negate) {
                        start++;
                        //case 3
                    } else {
                        end--;
                    }
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        int d [] = {1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};
        for (int i=0;i<d.length;i++){
            a.add(d[i]);
        }
        ThreeSumZero s = new ThreeSumZero();
        System.out.println(s.threeSum(a));
    }
}
