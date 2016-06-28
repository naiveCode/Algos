package interviewbit;

import java.util.ArrayList;

public class Bulbs {
    public int bulbs(ArrayList<Integer> a) {
        boolean searchingForZero = true;
        int count = 0;
        for (int b:a){
            if(searchingForZero){
                if(b==0){
                    count++;
                    searchingForZero = false;
                }
            }else {
                if(b==1){
                    count++;
                    searchingForZero = true;
                }
            }
        }
        return count;
    }
}
