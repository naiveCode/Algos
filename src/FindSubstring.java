import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubstring {
    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        if(b.size()==0 || a.length()==0){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> listmap = new HashMap<>();
        for (String c : b) {
            if(listmap.containsKey(c)){
                listmap.put(c,listmap.get(c)+1);
            }else {
                listmap.put(c,1);
            }
        }
        int lenOfWord = b.get(0).length();
        for (int i=0;i<=a.length() - lenOfWord;i++ ){
            HashMap<String,Integer> temp = new HashMap<>();
            temp.putAll(listmap);
            int j=i;
            while (!temp.isEmpty()){
                if(j + lenOfWord>a.length()){
                    break;
                }
                String s = a.substring(j,j+lenOfWord);
                if(temp.containsKey(s)){
                    int count = temp.get(s);
                    if(count == 1){
                        temp.remove(s);
                    }else {
                        temp.put(s,count-1);
                    }
                }else {
                    break;
                }
                j+=lenOfWord;

            }
            if(temp.isEmpty()){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "c";
        List<String > list = new ArrayList<>();
        String[] data = {"c" };
        for (int i=0;i<data.length;i++){
            list.add(data[i]);
        }
        FindSubstring p = new FindSubstring();
        System.out.println(p.findSubstring(s,list));
    }
}
