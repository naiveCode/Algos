import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class HotelBookingPossible {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        ArrayList<Event> events = new ArrayList<>();
        for (int s:arrive){
            events.add(new Event(s,true));
        }
        for (int s:depart ){
            events.add(new Event(s,false));
        }
        Collections.sort(events);
        int rooms = 0;
        for (Event e : events){
            if(e.isComing){
                rooms++;
                if(rooms>K){
                    return false;
                }
            }else {
                rooms--;
            }
        }
        if(rooms>K){
            return false;
        }
        return true;
    }

    class Event implements Comparable<Event> {
        int day;
        boolean isComing;


        Event(int x,boolean ic) {
            day = x;
            isComing = ic;
        }


        @Override
        public int compareTo(Event o) {
            return this.day - o.day;
        }
    }

}
