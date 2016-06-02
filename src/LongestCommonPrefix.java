import java.util.ArrayList;

public class LongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> a) {
        int min = Integer.MAX_VALUE;
        for (String b:a){
            if(b.length()<min){
                min = b.length();
            }
        }
        char[] prefix = new char[min];
        for (int i=0;i<min;i++){
            prefix[i] = a.get(0).charAt(i);
        }
        for (int i=1;i<a.size();i++){
            for (int j=0;j<min;j++){
                if(prefix[j]!=a.get(i).charAt(j)){
                    min = j;
                    break;
                }
            }
        }
        StringBuilder b = new StringBuilder();
        for (int i=0;i<min;i++){
            b.append(prefix[i]);
        }
        return b.toString();

    }
}
