import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split("\\s");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);
        long[] timeReq = new long[N];
        data = br.readLine().split("\\s");
        long max = Integer.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            timeReq[i] = Long.parseLong(data[i]);
            sum+=timeReq[i];
            if(timeReq[i]>max){
                max = timeReq[i];
            }
        }

        int t = (int) (sum/M);
        if(t>max){
            System.out.println(t);
        }else {
            System.out.println(max);
        }

    }
}
