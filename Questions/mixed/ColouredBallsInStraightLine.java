import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by naiveCode on 19/3/16.
 */
public class ColouredBallsInStraightLine {
    public static void main(String[] args) throws IOException {
        int[] input = new int[4];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split("\\s");
        for (int i = 0; i < 4; i++) {
            input[i] = Integer.parseInt(data[i]);
        }
        Arrays.sort(input);
        //now there is only one way to place the first ball colour
        //places created after using one ball color = i+1
        //since it is sorted we know that we can fill the whole space b/w the balls
        int comb = 1;
        int spacesCreated = input[0] + 1;
        int spacesLeftToFill = spacesCreated;
        int ballsWeCanUse = input[1];
        if (spacesLeftToFill < ballsWeCanUse) {
            spacesLeftToFill = spacesCreated - input[1];
        } else {
            spacesLeftToFill = 0;
            comb *= spacesCreated - ballsWeCanUse;
        }

        ballsWeCanUse = input[2] - spacesLeftToFill;
        spacesCreated = input[0] + input[1] + 1;
        if (spacesLeftToFill < ballsWeCanUse) {
            spacesLeftToFill = ballsWeCanUse - spacesCreated;
        } else {
            comb *= spacesCreated - ballsWeCanUse;
            spacesLeftToFill = 0;
        }
        ballsWeCanUse = input[3] - spacesLeftToFill;
        spacesCreated = input[0] + input[1] + input[2] + 1;
        if (spacesCreated < ballsWeCanUse) {
            spacesLeftToFill = ballsWeCanUse - spacesCreated;
        } else {
            comb *= spacesCreated - ballsWeCanUse;
            spacesLeftToFill = 0;
        }
        System.out.println(comb);
    }
}
