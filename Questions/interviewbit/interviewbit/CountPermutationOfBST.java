package interviewbit;

public class CountPermutationOfBST {
    public int cntPermBST(int A, int B) {
        int[][] choose = new int[A][B];
        choose[1][0] = 1;
        choose[0][0] = 1;
        for (int numbers = 2;numbers<A;numbers++){
            for (int height = 0;height<B && height<numbers-1;height++){
                for (int i=0;i<numbers;i++){
                    choose[numbers][height] += choose[numbers-i][height-i];
                }
            }
        }
        return rec(A, B, choose);
    }

    private int rec(int N, int M, int[][] choose) {
        if (N <= 1) {
            if (M == 0) return 1;
            return 0;
        }
        int ret = 0;
        for (int i = 1; i < N; i++) {
            int x = i - 1;
            int y = N - i;
            int ret1 = 0;
            for (int j = 0; j < M - 2; j++) {
                ret1 += rec(x, j, choose) * rec(y, M - 1, choose);
            }
            for (int j = 0; j < M - 2; j++) {
                ret1 += rec(y, j, choose) * rec(x, M - 1, choose);
            }
            ret1 += rec(x, M - 1, choose) * rec(y, M - 1, choose);
            ret = ret1 + choose[x + y][ y];

        }
        return ret;
    }
}


