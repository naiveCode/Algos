import java.util.ArrayList;

public class Stairs {
    ArrayList<Integer> fib;

    Stairs() {
        fib = new ArrayList<>();
        fib.add(1);
        fib.add(2);

    }

    public int climbStairs(int a) {
        if (fib.size() < a) {
            for (int i = fib.size(); i < a; i++) {
                fib.add(fib.get(i - 1) + fib.get(i - 2));
            }
        }
        return fib.get(a - 1);
    }

    public static void main(String[] args) {
        Stairs s = new Stairs();
        System.out.println(s.climbStairs(4));
    }
}
