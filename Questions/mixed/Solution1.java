public class Solution1 {
    public int trailingZeroes(int n) {
        int tz=0;
        long divider = 5;
        while(divider<=n){
            tz+= n/divider;
            divider = 5*divider;
        }
        return tz;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.trailingZeroes(5));
        System.out.println(s.trailingZeroes(125));
    }
}