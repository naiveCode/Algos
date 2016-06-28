import java.util.ArrayList;

public class MinStepsToJumpArray {
    public int jump(ArrayList<Integer> a) {
        if (a == null || a.size() <= 1) {
            return 0;
        }
        if (a.get(0) == 0) {
            return -1;
        }
        int currentNumberOfSteps = 1;
        int maxIndexReachable = Integer.MIN_VALUE;
        int currentPossible = 0;
        for (int i = 0; i < a.size(); i++) {
            maxIndexReachable = Math.max(i + a.get(i), maxIndexReachable);
            if (currentPossible < i) {
                currentPossible = maxIndexReachable;
                currentNumberOfSteps++;
            }
        }
        if (maxIndexReachable < a.size()) {
            return -1;
        }
        return currentNumberOfSteps;

    }

}