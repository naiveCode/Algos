import java.util.ArrayList;
import java.util.HashMap;

public class Colorful {
    public int colorful(int a) {
        if (a == 0) {
            return 1;
        }
        int t = a;
        HashMap<Integer, Integer> products = new HashMap<>();
        int lengthOfNumber = 0;
        ArrayList<Integer> number = new ArrayList<>();
        while (t != 0) {
            number.add(t % 10);
            t = t / 10;
            lengthOfNumber++;
        }
        for (int l = lengthOfNumber; l > 0; l--) {
            for (int i = 0; i <= lengthOfNumber - l; i++) {
                int prod =1;
                for (int j = i; j < i + l; j++) {
                    prod *= number.get(j);
                }
                if(products.containsKey(prod)){
                    return 0;
                }else {
                    products.put(prod,prod);
                }
            }
        }
        return 1;

    }

    public static void main(String[] args) {
        Colorful s = new Colorful();
        System.out.println(s.colorful(99));
    }
}
