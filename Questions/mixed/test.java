public class test {
    private int value = 4;

    public int getValue() {
        return value;
    }

    public void changeVal(int value) {
        value = value;
    }

    public static void main(String args[]) {
        int a = 1;
        test c = new test();
        c.changeVal(a);
        System.out.print(c.getValue());
    }
}