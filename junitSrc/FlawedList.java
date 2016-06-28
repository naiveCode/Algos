import java.util.ArrayList;

/**
 * Created by naiveCode on 23/6/16.
 */
public class FlawedList<T> extends ArrayList<T> {
    public boolean putIfAbsent(T object){
        boolean absent = !super.contains(object);
        if(absent){
            super.add(object);
        }
        return absent;
    }
}
