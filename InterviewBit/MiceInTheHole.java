import java.util.ArrayList;
import java.util.Collections;

public class MiceInTheHole {
    public int mice(ArrayList<Integer> posOfMice, ArrayList<Integer> posOfHoles) {
        Collections.sort(posOfHoles);
        Collections.sort(posOfMice);
        int ans = Integer.MIN_VALUE;
        for (int i=0;i<posOfHoles.size();i++){
            int diff = Math.abs(posOfHoles.get(i) - posOfMice.get(i));
            if(diff>ans){
                ans = diff;
            }
        }
        return ans;
    }
}
