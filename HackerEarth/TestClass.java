import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []line = br.readLine().split("\\s");

        int N = Integer.parseInt(line[0]);
        int D = Integer.parseInt(line[1]);
        int multiples = 0;
        line = br.readLine().split("\\s");
        for (int i=0;i<N;i++){
            int num = Integer.parseInt(line[i]);
            if(num%D == 0){
                multiples++;
            }
        }
        long answer = (N-multiples)*multiples + (multiples*(multiples-1))/2;
        System.out.println(answer);
    }
}
