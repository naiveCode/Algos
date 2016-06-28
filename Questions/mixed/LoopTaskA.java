import java.util.concurrent.TimeUnit;

/**
 * Created by naiveCode on 12/6/16.
 */
public class LoopTaskA implements Runnable{

    private static int count = 0;
    private int id;
    @Override
    public void run() {
        System.out.println("******************Task <"+id+"> starting");
        for (int i=0;i<10;i++){
            System.out.println("** "+id+" " + i);
            try{
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("******************Task <"+id+"> Over");
    }
    LoopTaskA(){
        id = ++count;
    }
}
