import java.util.ArrayList;

/**
 * Created by naiveCode on 1/3/16.
 */
public class NextGreater {
    public static void main(String[] args) {
        NextGreater n = new NextGreater();
        ArrayList<Integer> t = new ArrayList<>();
        int[] arr = {4, 5, 2, 10};
        for (int i = 0; i < arr.length; i++) {
            t.add(arr[i]);
        }
        System.out.println(n.nextGreater(t));
        arr = new int[]{3, 2, 1};

        for (int i = 0; i < arr.length; i++) {
            t.add(arr[i]);
        }
        System.out.println(n.nextGreater(t));

    }

    public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
        int max = a.get(a.size() - 1);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add( -1);
        for (int i = a.size() - 2; i >= 0; i--) {
            if (max > a.get(i)) {
                ans.add(0, max);
                max = a.get(i);
            } else {
                max = a.get(i);
                ans.add( 0,-1);
            }
        }
        return ans;
    }
}
