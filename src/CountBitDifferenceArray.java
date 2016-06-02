import java.util.ArrayList;

public class CountBitDifferenceArray {
    public int cntBits(ArrayList<Integer> A) {
        long []bitCount = new long[32];
        for (int i=0;i<A.size();i++){
            int mask = 1 ;
            int t = A.get(i);
            for (int j=0;j<32;j++){
                if((t&mask)==mask){
                    bitCount[j]++;
                }
                mask = mask<<1;
            }
        }
        long count = 0;
        for (int i=0;i<32;i++){
            count = (count + (2*bitCount[i]*((A.size()-bitCount[i]))%1000000007)%1000000007)%1000000007;
        }
        return (int) count;
    }
}
