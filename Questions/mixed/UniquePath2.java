public class UniquePath2 {
    public int uniquePaths(int m, int n) {
        int startX = 0, startY = 0;
        int[][] dist = new int[m][n];
        int ans = findPossiblePaths(startX, startY, m - 1, n - 1, dist);
        return ans;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return findPossiblePathsWithObstacles(obstacleGrid);
    }

    private int findPossiblePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    path[i][j] = 1;
                } else if (i == 0) {
                    if (obstacleGrid[i][j] != 1) {
                        path[i][j] += path[i][j - 1];
                    }

                } else if (j == 0) {
                    if (obstacleGrid[i][j] != 1) {
                        path[i][j] += path[i - 1][j];
                    }

                } else {
                    if (obstacleGrid[i][j] == 1) {
                        path[i][j] = 0;
                    } else {
                        path[i][j] = path[i - 1][j] + path[i][j - 1];
                    }
                }

            }

        return path[m - 1][n - 1];
    }

    private int findPossiblePaths(int i, int j, int m, int n, int[][] dist) {
        if (i > m || j > n) {
            return 0;
        }
        if (dist[i][j] != 0) {
            return dist[i][j];
        } else {
            if (i == m && j == n) {
                return 1;
            } else {
                dist[i][j] = findPossiblePaths(i + 1, j, m, n, dist) + findPossiblePaths(i, j + 1, m, n, dist);
            }
        }
        return dist[i][j];
    }

    public static void main(String[] args) {
        UniquePath2 t = new UniquePath2();
        int[][] d = {
                {0}
        };
        System.out.println(t.findPossiblePathsWithObstacles(d));
    }


}