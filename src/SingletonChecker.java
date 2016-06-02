/**
 * Created by naiveCode on 20/2/16.
 */
public class SingletonChecker {

    public static void main(String[] args) {
        System.out.println("Check me like you do..!!");

        for (int i = 0; i < 100; i++) {
            Thread t = new SingleThread("" + i);
            t.start();
        }
    }

    private static class SingleThread extends Thread {
        String threadName;

        SingleThread(String n) {
            threadName = n;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 100; i++) {
                System.out.print(threadName + " -> ");TestSingleton.getInstance(i);
            }
        }
    }
}
