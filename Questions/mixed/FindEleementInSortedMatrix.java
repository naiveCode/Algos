import java.util.ArrayList;

public class FindEleementInSortedMatrix {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int rowTop = 0, rowBottom = a.size() - 1, rowMiddle = 0;
        //first find the row then go for the coloumn
        boolean elF = false;
        while (rowBottom >= rowTop) {
            rowMiddle = (rowBottom + rowTop) / 2;
            if (a.get(rowMiddle).get(0) <= b && a.get(rowMiddle).get(a.get(rowMiddle).size() - 1) >= b) {
                elF = true;
                break;
            } else if (a.get(rowMiddle).get(0) > b) {
                rowBottom = rowMiddle - 1;
            } else if (a.get(rowMiddle).get(a.get(rowMiddle).size() - 1) < b) {
                rowTop = rowMiddle + 1;
            }
        }
        if (!elF) {
            return 0;
        } else {
            int rowIndex = rowMiddle;
            rowTop = 0;
            rowBottom = a.get(rowIndex).size() - 1;
            while (rowBottom >= rowTop) {
                rowMiddle = (rowBottom + rowTop) / 2;
                if (a.get(rowIndex).get(rowMiddle) == b) {
                    return 1;
                } else if (a.get(rowIndex).get(rowMiddle) > b) {
                    rowBottom = rowMiddle - 1;
                } else {
                    rowTop = rowMiddle + 1;
                }
            }

        }
        return 0;

    }

    public static void main(String[] args) {
        int[][] a =
                {
                        {3, 3, 11, 12, 14},
                        {16, 17, 30, 34, 35},
                        {45, 48, 49, 50, 52},
                        {56, 59, 63, 63, 65},
                        {67, 71, 72, 73, 79},
                        {80, 84, 85, 85, 88},
                        {88, 91, 92, 93, 94},
                };
        ArrayList<ArrayList<Integer>> b = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> c = new ArrayList<>();
            for (int j = 0; j < a[0].length; j++) {
                c.add(a[i][j]);
            }
            b.add(c);
        }
        FindEleementInSortedMatrix s = new FindEleementInSortedMatrix();
        System.out.println(s.searchMatrix(b, 94));
//        B : 41
    }
}
