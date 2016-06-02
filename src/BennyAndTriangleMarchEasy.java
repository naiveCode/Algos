

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by naiveCode on 1/3/16.
 */
public class BennyAndTriangleMarchEasy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]data = br.readLine().split("\\s");
        double a = Double.parseDouble(data[0]);
        double b = Double.parseDouble(data[1]);
        double p  = Double.parseDouble(data[2]);
//        System.out.println(a + " " + b + " " + p);

        double ans = (Math.sqrt(p)*b)/10;
        double roundOff = (double) Math.round(ans*100)/100 ;

        System.out.println(String.format("%.2f",roundOff));
    }
}
