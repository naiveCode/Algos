import java.util.ArrayList;
import java.util.HashMap;

public class DistinctElementsInAArrayWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> listOfNumber, int windowSize) {
        if (windowSize > listOfNumber.size()) {
            return new ArrayList<Integer>();
        }
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < windowSize; i++) {
            if (numberMap.containsKey(listOfNumber.get(i))) {
                numberMap.put(listOfNumber.get(i), numberMap.get(listOfNumber.get(i)) + 1);
            } else {
                numberMap.put(listOfNumber.get(i), 1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(numberMap.size());
        for (int i = windowSize ; i < listOfNumber.size() ; i++) {
            if (numberMap.get(listOfNumber.get(i - windowSize)) == 1) {
                numberMap.remove(listOfNumber.get(i - windowSize));
            } else {
                numberMap.put(listOfNumber.get(i - windowSize), numberMap.get(listOfNumber.get(i - windowSize)) - 1);
            }
            if (numberMap.containsKey(listOfNumber.get(i))) {
                numberMap.put(listOfNumber.get(i), numberMap.get(listOfNumber.get(i)) + 1);
            } else {
                numberMap.put(listOfNumber.get(i), 1);
            }
            ans.add(numberMap.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[]data = {1,2,1,3,4,3};
        for (int i=0;i<data.length;i++){
            list.add(data[i]);
        }
        DistinctElementsInAArrayWindow s = new DistinctElementsInAArrayWindow();
        int winSize = 3;
        System.out.println(s.dNums(list,winSize));
    }
}
