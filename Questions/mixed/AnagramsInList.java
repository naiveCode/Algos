import java.util.*;

public class AnagramsInList {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        HashMap<Long,ArrayList<Integer>> stringMAp = new HashMap<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i=0;i<a.size();i++){
            String test = a.get(i);
            char[] ar = test.toCharArray();
            Arrays.sort(ar);
            String sorted = String.valueOf(ar);
            long numberHash = sorted.hashCode();
            if(stringMAp.containsKey(numberHash)){
                ArrayList<Integer> t = stringMAp.get(numberHash);
                t.add(i+1);
                stringMAp.put(numberHash,t);
            }else {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(i+1);
                stringMAp.put(numberHash,t);
            }
        }
        Iterator<Map.Entry<Long, ArrayList<Integer>>> it = stringMAp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, ArrayList<Integer>> pair = it.next();
//            System.out.println(pair.getKey() + " = " + pair.getValue());
            ArrayList<Integer> s = pair.getValue();
//            if(s.size()>1){
                ans.add(s);
//            }
            it.remove(); // avoids a ConcurrentModificationException

        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> s = new LinkedList<>();
        String [] t = {"cat", "dog", "god", "tca"};
        for (int i=0;i<t.length;i++){
            s.add(t[i]);
        }
        AnagramsInList p = new AnagramsInList();
        System.out.println(p.anagrams(s));
    }


}
