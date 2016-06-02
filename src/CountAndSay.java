public class CountAndSay {
    public String countAndSay(int a) {
        if(a==0){
            return "";
        }
        StringBuilder ans = new StringBuilder();
        String digit = String.valueOf(1);
        for (int i=0;i<a-1;i++){

            int dig = 11,count = 0,size=0;
            StringBuilder temp = new StringBuilder();
            for (int j=0;j<digit.length();j++){
                if(dig!=(digit.charAt(j)-'0')){
                    if(dig!=11){
                        temp.append(count);
                        temp.append(dig);
                        size = 0;
                    }
                    dig  = (digit.charAt(j)-'0');
                    count=1;
                    size++;
                }else {
                    count++;
                }
            }
            digit = temp.toString();
            if(size!=0){
                digit = digit + count + "" + dig;
            }
        }
        return digit;
    }

    public static void main(String[] args) {
        CountAndSay s = new CountAndSay();
        for (int i=0;i<10;i++) {
            System.out.println(s.countAndSay(i));
        }
    }
}
