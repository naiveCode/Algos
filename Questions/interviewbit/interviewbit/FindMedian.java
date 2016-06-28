package interviewbit;

public class FindMedian {
    private static final int MOD = 10000003;

    public static int seatsNonOptim(String a) {
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < a.length(); i++){
            int count = shift(a.toCharArray(), i);
            if(count < minCount)
                minCount = count;
//            System.out.println("Count = " + count);
        }
        return minCount;
    }

    public static int shift(char[] s, int i){
//        System.out.println("Shifting with i = " + i + " is " + String.valueOf(s));
        int count = 0;
        int j = 0;
        int k = i;
        while(j < k){
            if(s[j] == '.'){
                j++;
//                System.out.println("\t incremented j = " + j);
            }
            else if(s[k] == 'x'){
                k--;
//                System.out.println("\t decremented k = "+ k);
            }
            else{
                s[k] = s[j];
                s[j] = '.';
                count = (count + k-j)%MOD;
                j++;
                k--;
//                System.out.println("\t decremented j and incremented k " + j + ", " + k );
            }
        }
//        System.out.println("After shifting with first half is " + String.valueOf(s) +" count = " + count);
        j = s.length - 1;
        k = i;
        while (j > k) {
            if (s[j] == '.') {
                j--;
            }
            else if (s[k] == 'x') {
                k++;
            }
            else {
                s[k] = s[j];
                s[j] = '.';
                count = (count + j-k)%MOD;
                j--;
                k++;
            }
        }

//        System.out.println("After shifting with i = " + i + " is " + String.valueOf(s) +" count = " + count);
        return count;
    }

    public static int seats(String a) {
        int i = findMedian(a.toCharArray());
        if(i == -1)
            return 0;
        return shift(a.toCharArray(), i);
    }

    public static int findMedian(char[] s){
        int count1 = 0;
        for(int i = 0; i <s.length; i++){
            if(s[i] == 'x')
                count1++;
        }
        if(count1 == 0)
            return -1;

        count1 = (count1 + 1)/2;
        int count2 = 0;
        for(int i = 0; i <s.length; i++){
            if(s[i] == 'x'){
                count2++;
                if(count2 == count1)
                    return i;
            }
        }
        return -1;

    }

    public static void main(String[] args){
        String a = "....x..xx...x..";
        System.out.println(seats(a));
    }
}