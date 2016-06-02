import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by naiveCode on 1/3/16.
 */
public class BennyAndIceMarchEasy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string = br.readLine().toCharArray();
        int initialX = 5001;
        int initialY = 5001;
        boolean[][] visited = new boolean[10002][10002];
        visited[initialX][initialY] = true;
        int size = string.length;
        int fallCount = 0;
        for (int i = 0; i < size; i++) {
            switch (string[i]) {
                case 'L':
                    initialX--;
                    break;
                case 'R':
                    initialX++;
                    break;
                case 'D':
                    initialY++;
                    break;
                case 'U':
                    initialY--;
                    break;
            }
            if (!visited[initialX][initialY]) {
                visited[initialX][initialY] = true;
            } else {
                fallCount++;
            }

        }
        System.out.println(fallCount);
    }
}
