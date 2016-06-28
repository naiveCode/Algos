import java.util.ArrayList;

public class ReachEndOfArrayJump {
    public int canJump(ArrayList<Integer> a) {
        if(a==null || a.size()<=1){
            return 1;
        }
        int jumper = a.get(0);
        if(jumper == 0 ){
            return 0;
        }
        for (int i=1;i<a.size();i++){
            if(jumper>a.get(i)){
                jumper--;
            }
            else {
                jumper = a.get(i);
            }
            if(jumper <= 0 && i!=a.size()){
                return 0;
            }
        }
        return 1;

    }
/*
Brute force Stack overflow
 */
    private int canJumpHelper(ArrayList<Integer> a, int i) {

        if(i>=a.size()){
            return 1;
        }
        int jumpPossible = a.get(i);
        for (int j=jumpPossible;j>0;j--){
            if(canJumpHelper(a,j)==1){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ReachEndOfArrayJump s = new ReachEndOfArrayJump();
        int []data = {33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28 };
        System.out.println("length of data is fucking " + data.length);
        ArrayList<Integer> d = new ArrayList<>();
        for (int i=0;i<data.length;i++){
            d.add(data[i]);
        }
        System.out.println(s.canJump(d));
    }
}
