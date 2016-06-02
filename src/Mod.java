public class Mod {
    public int Mod(int x, int n, int p) {
        if (n == 0) return 1 % p;
        long y = 0;
        if (n % 2 == 0) {
            y = Mod(x, n/2, p);
            y = (y * y) % p;
        } else {
            y = x % p;
            y = (y * Mod(x, n - 1, p)) % p;
        }
        // Incase y is negative.
        return (int)((y + p) % p);
    }
}
