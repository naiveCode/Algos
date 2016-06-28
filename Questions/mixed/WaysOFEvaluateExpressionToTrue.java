public class WaysOFEvaluateExpressionToTrue {
    int MOD = 1003;

    public int cnttrue(String A) {
        StringBuilder symbols = new StringBuilder();
        StringBuilder operators = new StringBuilder();
        for (int i = 0; i < A.length(); ++i) {
            char cur = A.charAt(i);
            if (cur == 'T' || cur == 'F') symbols.append(cur);
            else operators.append(cur);
        }


        return cnt(symbols.toString().toCharArray(), operators.toString().toCharArray()) % MOD;
    }

    int cnt(char exp[], char op[]) {
        int n = exp.length;
        int t[][][] = new int[n][n][2];
//        int f[][]= new int[n][n];
        for (int i = 0; i < n; ++i) {
            if (exp[i] == 'T') t[i][i][0] = 1;
            else t[i][i][1] = 1;
        }
        for (int gap = 1; gap < n; ++gap) {
            for (int i = 0, j = gap; j < n; ++i, ++j) {

                for (int g = 0; g < gap; ++g) {
                    int k = i + g;
                    switch (op[k]) {
                        case '&':
                            t[i][j][0] += t[i][k][0] * t[k + 1][j][0];
                            t[i][j][1] += t[i][k][0] * t[k + 1][j][1] + t[i][k][1] * t[k + 1][j][0] + t[i][k][1] * t[k + 1][j][1];
                            break;
                        case '|':
                            t[i][j][0] += t[i][k][0] * t[k + 1][j][0] + t[i][k][0] * t[k + 1][j][1] + t[i][k][1] * t[k + 1][j][0];
                            t[i][j][1] += t[i][k][1] * t[k + 1][j][1];
                            break;
                        case '^':
                            t[i][j][0] += t[i][k][0] * t[k + 1][j][1] + t[i][k][1] * t[k + 1][j][0];
                            t[i][j][1] += t[i][k][0] * t[k + 1][j][0] + t[i][k][1] * t[k + 1][j][1];
                            break;
                    }

                    t[i][j][0] %= MOD;
                    t[i][j][1] %= MOD;
                }
            }
        }

        return t[0][n - 1][0];
    }
}

