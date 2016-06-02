public class MAtrixForFibbo {
    public int climbStairs(int n) {

        int totalSteps = 0;
        int[][] mat1 = {{0, 1}, {1, 1}};
        if(n==1) return 1;
        mat1 = findMultiple(mat1, n);

        totalSteps = mat1[0][0] + mat1[0][1];

        return totalSteps;
    }

    public int[][] findMultiple(int[][] mat, int n) {
        if (n == 0 || n==1) {
            return mat;
        } else if (n % 2 == 0) {
            return findMultiple(multiplyMatrix(mat, mat), n / 2);
        } else {
            return multiplyMatrix(mat,findMultiple(multiplyMatrix(mat, mat),n/2));
        }
    }

    public int[][] multiplyMatrix(int[][] mat1, int[][] mat2) {
        int[][] res = new int[2][2];
        res[0][0] = mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0];
        res[0][1] = mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1];
        res[1][0] = mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0];
        res[1][1] = mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1];
//        System.out.println(res[0][0] + "   " + res[0][1] + "\n"+ res[1][0] + "   " +res[1][1]);
//        System.out.println();

        return res;
    }

    public static void main(String[] args) {
        MAtrixForFibbo a = new MAtrixForFibbo();

        System.out.println(a.climbStairs(1));
//        System.out.println("*****************************************");
        System.out.println(a.climbStairs(2));
//        System.out.println("*****************************************");
        System.out.println(a.climbStairs(3));
//        System.out.println("*****************************************");
        System.out.println(a.climbStairs(4));
//        System.out.println("*****************************************");
        System.out.println(a.climbStairs(5));
//        System.out.println("*****************************************");
        System.out.println(a.climbStairs(6));
//        System.out.println("*****************************************");
        System.out.println(a.climbStairs(7));
//        System.out.println("*****************************************");
        System.out.println(a.climbStairs(8));
//        System.out.println("*****************************************");
    }
}
