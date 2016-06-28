import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by naiveCode on 1/3/16.
 */
public class BennyAndCityMarchEasy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split("\\s");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);
        int C = Integer.parseInt(data[2]);
        int[] rowSum = new int[N];
        int[] colSum = new int[M];
        int input[][] = new int[N][M];
        int totalSum = 0;
        for (int i = 0; i < N; i++) {
            data = br.readLine().split("\\s");
            for (int j = 0; j < M; j++) {
                input[i][j] = Integer.parseInt(data[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                rowSum[i] += input[i][j];
                colSum[j] += input[i][j];
                totalSum += input[i][j];
            }
        }
        Data[] sumVal = new Data[M + N];
        for (int i = 0; i < N; i++) {
            sumVal[i] = new Data(rowSum[i], i, -1, true);
        }
        for (int j = 0; j < M; j++) {
            sumVal[N + j] = new Data(colSum[j], -1, j, true);
        }
        Arrays.sort(sumVal);

        while ((sumVal[0].value * -1) > C) {
            totalSum = 0;
            int se = sumVal[0].value;
            int rowIndex = sumVal[0].row;
            int colIndex = sumVal[0].col;
            boolean isRow = sumVal[0].isRowSum;
            if (isRow) {
                for (int i = 0; i < M; i++) {
                    input[rowIndex][i] = 0;
                }
            } else {
                for (int i = 0; i < M; i++) {
                    input[i][colIndex] = 0;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    rowSum[i] += input[i][j];
                    colSum[j] += input[i][j];
                    totalSum += input[i][j];
                }
            }
            sumVal = new Data[M + N];
            for (int i = 0; i < N; i++) {
                sumVal[i] = new Data(rowSum[i], i, -1, true);
            }
            for (int j = 0; j < M; j++) {
                sumVal[N + j] = new Data(colSum[j], -1, j, true);
            }

        }
        System.out.println(totalSum);


    }

    static class Data implements Comparable<Data> {
        int value;
        int row, col;
        boolean isRowSum;

        Data(int v, int r, int c, boolean irs) {
            value = v;
            row = r;
            col = c;
            isRowSum = irs;
        }

        @Override
        public int compareTo(Data o) {
            return this.value - o.value;
        }
    }
}
