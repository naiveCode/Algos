class Test{
    int a=20;
    static int b=10;
    void m1()
    {
        TestA t= new TestA();
        System.out.println(t.b);
    }
    public static void main(String args[])
    {
        TestA t1= new TestA();
        t1.m1();
    }
}