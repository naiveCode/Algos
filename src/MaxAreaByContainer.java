import java.util.ArrayList;
import java.util.Stack;

public class MaxAreaByContainer {
    public int maxArea(ArrayList<Integer> height) {
        if (height == null || height.size() < 2) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = height.size() - 1;

        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height.get(left), height.get(right)));
            if (height.get(left) < height.get(right))
                left++;
            else
                right--;
        }

        return max;
    }
}
