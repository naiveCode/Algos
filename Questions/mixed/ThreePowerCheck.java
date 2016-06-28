/**
 * Created by naiveCode on 13/1/16.
 */
public class ThreePowerCheck {
    public boolean isPowerOfThree(int n) {
        if(Integer.toString(n,3).matches("10*")){
            return true;
        }else return false;
    }
}
