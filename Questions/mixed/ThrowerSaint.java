import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by naiveCode on 13/2/16.
 */
public class ThrowerSaint {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t--!=0){
            int d = Integer.parseInt(br.readLine());
            int highestBitCount = 0;
            int ans;
            if(d==1){
                System.out.println(1);
                continue;
            }
            while (d>=1){
                d=d>>1;
                highestBitCount++;
            }
            if((highestBitCount-1)%2==0){
                ans = (int) Math.pow(2,highestBitCount-2);
            }else {
                ans = (int) Math.pow(2,highestBitCount-1) -1;
            }
            System.out.println(ans);
        }
    }
}
