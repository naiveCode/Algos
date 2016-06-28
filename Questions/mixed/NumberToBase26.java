public class NumberToBase26 {
    public String convertToTitle(int a) {
        StringBuilder b = new StringBuilder();
        while (a>0){
            int c = a%26;
            char d = (char) ('A' + ((c==0)?25:(c-1)));
            b.append(d);
            a=a/26;
            if(c==0)
                a--;

        }
        return b.reverse().toString();
    }

    public static void main(String[] args) {
        NumberToBase26 s = new NumberToBase26();
        System.out.println(s.convertToTitle(943566));
        //BAQTZ
    }
}
