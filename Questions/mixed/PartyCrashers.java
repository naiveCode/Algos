import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by naiveCode on 19/3/16.
 */
public class PartyCrashers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split("\\s");
        int N = Integer.parseInt(data[0]);
        int Q = Integer.parseInt(data[1]);
        HashSet<String> nameSet = new HashSet<>();
        for (int i = 0;i<N;i++){
            String name = br.readLine();
            nameSet.add(name);
        }
        int count = 0;
        for (int i=0;i<Q;i++){
            String d = br.readLine();
            if(!d.matches("[\\d]+")){
                if(!nameSet.contains(d)){
                    count++;
                }
            }else {
                if(Integer.parseInt(d)<=20){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
