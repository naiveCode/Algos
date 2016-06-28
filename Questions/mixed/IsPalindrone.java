/**
 * Created by naiveCode on 4/1/16.
 */
public class IsPalindrone {
    public boolean isPalindrome(int x) {
        int t=x;
        if(x<0)
            return false;
        long num = 0;
        while (x>0){
            num = num*10 + x%10;
            x=x/10;
        }
        System.out.println(t + " " + num );
        if(t == num)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        IsPalindrone a = new IsPalindrone();
        System.out.println(a.isPalindrome(11));
    }

}
