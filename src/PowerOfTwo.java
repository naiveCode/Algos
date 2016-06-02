/**
 * Created by naiveCode on 15/2/16.
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        PowerOfTwo p = new PowerOfTwo();
        System.out.println(p.isPowerOfTwo(8));
        System.out.println(p.isPowerOfTwo(9));
        System.out.println(p.isPowerOfTwo(-8));
        System.out.println(p.isPowerOfTwo(-9));
    }

    private boolean isPowerOfTwo(int n){
//        n = Math.abs(n);
        return (n & (n - 1)) == 0;
    }
}

