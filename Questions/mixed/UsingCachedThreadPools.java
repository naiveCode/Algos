import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by naiveCode on 12/6/16.
 */
public class UsingCachedThreadPools {
    public static void main(String[] args) {
        System.out.println("Main starts here..");

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new LoopTaskA());
        exec.execute(new LoopTaskA());
        exec.execute(new LoopTaskA());

        exec.execute(new LoopTaskA());
        exec.execute(new LoopTaskA());
        exec.execute(new LoopTaskA());

        exec.shutdown();
        System.out.println("Main ends here...");
    }
}
