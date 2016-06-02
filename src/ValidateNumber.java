public class ValidateNumber {

    public int myAtoi(String str) {
        int result = 0, i = 0, sign = 1;
        if(str == null || str.length() == 0)
            return result;
        char[] arr = str.toCharArray();
        while(arr[i]==' ' && i< arr.length)
            i++;
        if(i==arr.length)
            return result;
        if(arr[i] == '-' || arr[i] == '+'){
            sign = arr[i] == '-'? -1: 1;
            i++;
        }
        int j = i;
        for(; j < str.length(); j++){
            if(arr[j] >'9' || arr[j] <'0')
                break;
            if((j > i) &&
                    (Integer.parseInt(str.substring(i, j)) > Integer.MAX_VALUE/10 ||
                            (Integer.parseInt(str.substring(i, j)) == Integer.MAX_VALUE/10 &&
                                    (sign == 1 && arr[j]>='7' || sign == -1&& arr[j] >= '8'))))
                return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }
        result = i==j? 0: Integer.parseInt(str.substring(i, j));
        return result*sign;
    }



    public static void main(String[] args) {
        ValidateNumber s = new ValidateNumber();
        System.out.println(s.myAtoi("    010"));
//        System.out.println("************************");
        System.out.println(s.myAtoi("  00010"));
        System.out.println(s.myAtoi("2147483648"));
        System.out.println(s.myAtoi("+"));
        System.out.println(s.myAtoi("+-2"));
        System.out.println(s.myAtoi("-"));
        System.out.println(s.myAtoi("9223372036854775809"));
        System.out.println(s.myAtoi("-12a32"));

    }
}