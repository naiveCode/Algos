import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by naiveCode on 5/12/15.
 */
public class ValidAnagramCheck {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            int result=0;
            for(int i=s.length()-1;i>=0;i--){
                result = (s.charAt(i)-'A' +1) + result*26;
                System.out.println(result);
            }
            System.out.println("result " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
