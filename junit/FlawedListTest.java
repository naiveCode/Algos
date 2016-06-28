import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by naiveCode on 23/6/16.
 */
public class FlawedListTest {

    @Test
    public void testIfPutAbsent(){
        FlawedList<String> list = new FlawedList<>();
        list.putIfAbsent("foo");
        list.putIfAbsent("foo");
//        assertThat(list.size(),);
    }

}