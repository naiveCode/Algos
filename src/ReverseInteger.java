public class ReverseInteger {
    public int reverse(int x) {
        int y = 0;

        while(x != 0) {
            int yy = y*10 + x%10;

            if ((yy - x%10)/10 != y) return 0;
            else y = yy;

            x = x/10;
        }
        return y;
    }

    public static void main(String[] args) {
        ReverseInteger a = new ReverseInteger();
        System.out.println(a.reverse(1534236469));
        System.out.println(a.reverse(-2147483648));

//        a.reverse(9646324351);
    }
}