import java.util.List;

public class BuyAndSellStock2 {
    public int maxProfit(final List<Integer> a) {
        int maxProf = 0;
        int j=0;
        for (int i=1;i<a.size();i++){
            if(a.get(i)>a.get(i-1)){
                maxProf += a.get(i)-a.get(i-1);
            }
        }
        return maxProf;
    }
}
