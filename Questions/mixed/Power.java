public class Power {

    public int power(int x, int n, int d) {
        if (n == 0)
            return 1;

        long v = power(x, n / 2, d);
        v = v % d;
        x = x % d;

        if (n % 2 == 0) {
            return (int)((v * v) % d);
        } else {
            return (int)(((v * v)%d * x) % d);
        }
    }

    public int pow(int x, int n, int d) {
        if (x == 0) {
            return 0;
        }
        if (x < 0 && n % 2 == 1) {
            return (d - power(-x, n, d));
        } else {
            return power(x, n, d);
        }

    }

    public static void main(String[] args) {
        int A = 71045970;
        int B = 41535484;
        int C = 64735492;
        Power s = new Power();
        System.out.println(s.pow(A, B, C));
    }
}
