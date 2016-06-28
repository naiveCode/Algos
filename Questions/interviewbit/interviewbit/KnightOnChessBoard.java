package interviewbit;

import java.util.ArrayDeque;
import java.util.Queue;

public class KnightOnChessBoard {
    public int knight(int N, int M, int x1, int y1, int x2, int y2) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x1, y1));

        boolean[][] visited = new boolean[N + 1][M + 1];
        visited[x1][y1] = true;
        int level = -1;
        while (!queue.isEmpty()) {
            level++;
//            System.out.println();
            Queue<Point> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                Point curr = queue.poll();
//                System.out.println("data " + curr.x + " " + curr.y);
                if (curr.x == x2 && curr.y == y2) {
                    return level;
                }
                for (int i = 0; i < possibleMoves.length; i++) {
                    int x = curr.x + possibleMoves[i][0];
                    int y = curr.y + possibleMoves[i][1];
                    if (isValid(x, y, N, M) && !visited[x][y]) {
//                        System.out.println("valid  " + x + " " + y);
                        visited[x][y] = true;
                        temp.add(new Point(x, y));
                    }
                }
            }
            queue.addAll(temp);
        }
        return -1;
    }

    private boolean isValid(int x, int y, int m, int n) {
//        System.out.print("(" + x + "," + y + ")|");
        return (x > 0 && x <= m && y > 0 && y <= n);
    }

    int[][] possibleMoves = {{1, 2},
                             {2, 1},
                             {-1, 2},
                             {-2, 1},
                             {-1, -2},
                             {-2, -1},
                             {1, -2},
                             {2, -1}};

    class Point {
        int x, y;

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static void main(String[] args) {
        KnightOnChessBoard s = new KnightOnChessBoard();
        System.out.println(s.knight(4, 7, 2, 6, 2, 4));
    }
}
