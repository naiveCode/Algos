import java.util.ArrayList;
import java.util.HashMap;

public class MaxPointOnALineIB {

    public static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        int maxPoints = 0;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        if(a.size() != b.size() || a.size() == 0 || a == null || b.size() == 0 || b == null)
            return maxPoints;
        if(a.size() == 1 && b.size() == 1)
            return 1;
        for(int i = 0; i < a.size(); i++){
            int duplicate = 1;
            int vertical = 0;
            int xi = a.get(i);
            int yi = b.get(i);
            for(int j = i+1; j < a.size(); j++){
                int xj = a.get(j);
                int yj = b.get(j);
                if(xi == xj){
                    if(yi == yj){
                        duplicate++;
                    }else{
                        vertical++;
                    }
                }
                else{
                    double slope = 0.0;
                    if(yj - yi == 0)
                        slope = 0.0;
                    else if(xj - xi == 0)
                        slope = Double.MAX_VALUE;
                    else
                        slope = (double)(yj - yi) / (double)(xj - xi);

//                    System.out.println("Slope : " + slope);
                    if(map.containsKey(slope))
                        map.put(slope, map.get(slope) + 1);
                    else
                        map.put(slope, 1);
                }
            }

            for(int sl : map.values())
                if(maxPoints < sl + duplicate)
                    maxPoints = sl + duplicate;

            maxPoints = Math.max(vertical + duplicate, maxPoints);
            map.clear();
        }


        return maxPoints;

    }


    public static void main(String[] args) {
        MaxPointOnALineIB s = new MaxPointOnALineIB();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        String p = "14 -2 -17 -3 2 3 -13 -5 -18 6 9 -10 15 5 2 11 -3 18 -7 -1 -10 -13 14 -6 -2 13 -18 -14 -7 -1 12 -19 1 -13 -9 2 -16 -6 -4 -3 11 2 -4 -2 -16 -11 17 5 5 -13 8 18 -16 -15 -8 12 5 5 4 14 16 2 14 8 -12 4 13 -20 2 -1 -14 -1 -9 -16 20 20 -5 -9 -19 -2 -16 0 -19 1 3 -4 3 -1 1 -20 -18 -2 19 -9 11 2 -16 10 10 -12 12 4 -5 12 -1 -3 -5 2 -17 3 -20 4 18 -1 -15 10 -3 19 -5 -17 17 14 14 7 0 17 0 5 3 -9 10 -13 13 6 10 18 15 1 2 2 19 4 -14 6 -17 6 4 -3 6 7 1 18 12 18";
        String data[] = p.split("\\s");

        for (int i=0;i<data.length;i=i+2){
            a.add(Integer.parseInt(data[i]));
            b.add(Integer.parseInt(data[i+1]));
        }
        System.out.println(s.maxPoints(a, b));
    }
}
