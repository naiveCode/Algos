public class TestSingleton {
    private TestSingleton() {
        System.out.println("Constructor");
    }

    static int count=0;
    public static TestSingleton getInstance(int c) {
        System.out.println("Get instance called" +c);
        return TestSingletonHolder.INSTANCE;

    }

    private static class TestSingletonHolder {
        public TestSingletonHolder(){
            System.out.println("Constructor for TestSingletonHolder");
        }
        private static final TestSingleton INSTANCE = new TestSingleton();

    }
}