package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class PartailEqualAveragePartition {
    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> arr) {
        int sum = 0;

        int n = arr.size();
        Collections.sort(arr);

        // Caculcate sun of all elements
        for (int i = 0; i < n; i++)
            sum += arr.get(i);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();



        int part[][] = new int[n + 1][sum / 2 + 1];

        for (int i = 0; i < n + 1; i++) {
            part[i][0] = 1;
        }
        for (int i = 0; i < sum / 2 + 1; i++) {
            part[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum/2 + 1; j++) {
                part[i][j] = part[i - 1][j]; //excluding the element
                if (j - arr.get(i - 1) >= 0) {
                    part[i][j] = Math.max(part[i][j], part[i - 1][j - arr.get(i - 1)]);
                }
            }
        }


//        System.out.println("Table formed");
        ArrayList<Integer> temp1 = new ArrayList<>();
        for (int j=sum/arr.size();j<sum/2;j++) {
            int i=j;
//            System.out.println("Checking for sum " + i);
            int p = n;
            ArrayList<Integer> temp = new ArrayList<>();
            if (part[p][i] == 1) {
                while (p >= 1 && i >= 1) {
                    while (p >= 1 && i >= 1 && part[p - 1][i] == 1) {
                        p--;
                    }
                    temp.add(arr.get(p - 1));
                    i = i - arr.get(p - 1);
                    p--;
                }
            }
//            System.out.println(temp);
            if(j*(arr.size() - temp.size()) == (sum-j)*temp.size()){
//                System.out.println("Average Equality for sum " + j);
                if(temp1.size()<temp.size()){
                    temp1 = new ArrayList<>();
                    temp1.addAll(temp);
                    Collections.sort(temp1);
                }else if(temp.size() == temp1.size()){
                    Collections.sort(temp);

                    if(temp.get(0)>temp1.get(0)){
                        temp1 = new ArrayList<>();
                        temp1.addAll(temp);
                    }
                }
            }
        }
        if(temp1.size()>0) {
            arr.removeAll(temp1);
            Collections.sort(arr);
            ans.add(temp1);
            ans.add(arr);
        }



        return ans;
    }

//        for (int i = avg,j=avg, numOfElement = 1; j <= sum / 2; i += avg,j+=avg) {
//            int row = n;
//            ArrayList<Integer> temp = new ArrayList<>();
//            if (part[row][i] == 1) {
//                while (row >= 1 && i>=1) {
//                    while (row >= 1 &&i >=1 &&  part[row - 1][i] == 1) {
//                        row--;
//                    }
//                    temp.add(arr.get(row-1));
//                    i = i - arr.get(row-1);
//                    row--;
//                }
//                if (temp.size()==sum/avg) {
//                    if (maxLength < temp.size()) {
//                        maxLength = temp.size();
//                        temp1 = new ArrayList<>();
//                        temp1.addAll(temp);
//                    }
//                }
//            }


    public static void main(String[] args) {
        PartailEqualAveragePartition s = new PartailEqualAveragePartition();
        ArrayList<Integer> arr = new ArrayList<>();
        int d[] = {47, 14, 30, 19, 30, 4, 32, 32, 15, 2, 6, 24};
        for (int i = 0; i < d.length; i++) {
            arr.add(d[i]);
        }
        System.out.println(s.avgset(arr));
    }

}
