
class TestThread extends Thread{

    public TestThread(MyRunnable r) {
        super(r);
    }

    public TestThread() {

    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        TestThread t1 = new TestThread();
        System.out.println(t1.getName());
//        t1.run();
//        t1.start();
//        MyRunnable r = new MyRunnable();
//        r.run();
//        TestThread t2 = new TestThread(r);
//        t2.start();
//
        Thread t3 = new Thread(t1);
        System.out.println(t3.getName());
        t3.start();
    }

    @Override
    public void run() {
        System.out.println("test thread call");
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Calling runnable ");
        }
    }
}