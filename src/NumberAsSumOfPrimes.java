import java.util.ArrayList;

public class NumberAsSumOfPrimes {
    public ArrayList<Integer> primesum(int a) {
        boolean []sieve = new boolean[a];
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i=2;i<a;i++){
            if(!sieve[i]) {
                primes.add(i);
                for (int j = 1; i * j < a; j++) {
                    sieve[i * j] = true;
                }
                sieve[i] = true;
            }
        }
        Integer[] s = new Integer[primes.size()];
        primes.toArray(s);
        int numberOfPrimes = primes.size();
        int left = 0,right = numberOfPrimes-1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (left<=right){
            if((s[left] + s[right])==a){
                ans.add(s[left]);
                ans.add(s[right]);
                break;
            }else if((s[left] + s[right])<a){
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberAsSumOfPrimes s= new NumberAsSumOfPrimes();
        System.out.println(s.primesum(12));
    }
}
