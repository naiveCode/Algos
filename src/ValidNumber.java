import java.util.regex.Pattern;

/**
 * Created by naiveCode on 11/2/16.
 */
public class ValidNumber {

    public static void main(String[] args) {
        ValidNumber v = new ValidNumber();
        System.out.println(v.isNumber("-01.1e-10"));

    }
    public boolean isNumber(String s) {
//        try{
//            Double.parseDouble(s);
//            return true;
//        }catch (NumberFormatException n){
//            return false;
//        }
        return Pattern.matches("-?(([0-9]{1}+\\d*|0)(\\.\\d+)?|\\.\\d+)(e-?[1-9]{1}+\\d*)?", s.trim());
    }

}
