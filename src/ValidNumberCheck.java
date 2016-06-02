import java.util.ArrayList;

interface NumberValidate {

    boolean validate(String s);
}

abstract class NumberValidateTemplate implements NumberValidate {

    public boolean validate(String s) {
        if (checkStringEmpty(s)) {
            return false;
        }

        s = checkAndProcessHeader(s);

        return s.length() != 0 && doValidate(s);

    }

    private boolean checkStringEmpty(String s) {
        return s.equals("");

    }

    private String checkAndProcessHeader(String value) {
        value = value.trim();

        if (value.startsWith("+") || value.startsWith("-")) {
            value = value.substring(1);
        }


        return value;
    }


    protected abstract boolean doValidate(String s);
}

class NumberValidator implements NumberValidate {

    private ArrayList<NumberValidate> validators = new ArrayList<>();

    public NumberValidator() {
        addValidators();
    }

    private void addValidators() {
        NumberValidate nv = new IntegerValidate();
        validators.add(nv);

        nv = new FloatValidate();
        validators.add(nv);

        nv = new HexValidate();
        validators.add(nv);

        nv = new SienceFormatValidate();
        validators.add(nv);
    }

    @Override
    public boolean validate(String s) {
        for (NumberValidate nv : validators) {
            if (nv.validate(s)) {
                return true;
            }
        }

        return false;
    }


}

class IntegerValidate extends NumberValidateTemplate {

    protected boolean doValidate(String integer) {
        for (int i = 0; i < integer.length(); i++) {
            if (!Character.isDigit(integer.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}

class HexValidate extends NumberValidateTemplate {

    private char[] valids = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};

    protected boolean doValidate(String hex) {
        hex = hex.toLowerCase();
        if (hex.startsWith("0x")) {
            hex = hex.substring(2);
        } else {
            return false;
        }

        for (int i = 0; i < hex.length(); i++) {
            if (Character.isDigit(hex.charAt(i)) && isValidChar(hex.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidChar(char c) {
        for (char valid : valids) {
            if (c == valid) {
                return true;
            }
        }

        return false;
    }
}

class SienceFormatValidate extends NumberValidateTemplate {

    protected boolean doValidate(String s) {
        s = s.toLowerCase();
        int pos = s.indexOf("e");
        if (pos == -1) {
            return false;
        }

        if (s.length() == 1) {
            return false;
        }

        String first = s.substring(0, pos);
        String second = s.substring(pos + 1, s.length());

        return !(!validatePartBeforeE(first) || !validatePartAfterE(second));


    }

    private boolean validatePartBeforeE(String first) {
        if (first.equals(""))
            return false;

        if (!checkHeadAndEndForSpace(first))
            return false;


        NumberValidate integerValidate = new IntegerValidate();
        NumberValidate floatValidate = new FloatValidate();
        return !(!integerValidate.validate(first) && !floatValidate.validate(first));

    }

    private boolean checkHeadAndEndForSpace(String part) {

        return !(part.startsWith(" ") ||
                part.endsWith(" "));

    }

    private boolean validatePartAfterE(String second) {
        if (second.equals("")) {
            return false;
        }

        if (!checkHeadAndEndForSpace(second)) {
            return false;
        }

        NumberValidate integerValidate = new IntegerValidate();
        return integerValidate.validate(second);

    }
}

class FloatValidate extends NumberValidateTemplate {

    protected boolean doValidate(String floatVal) {
        int pos = floatVal.indexOf(".");
        if (pos == -1) {
            return false;
        }

        if (floatVal.length() == 1) {
            return false;
        }

        String first = floatVal.substring(0, pos);
        String second = floatVal.substring(pos + 1, floatVal.length());

        return checkFirstPart(first) && checkFirstPart(second);

    }

    private boolean checkFirstPart(String first) {
        return !(!first.equals("") && !checkPart(first));

    }

    private boolean checkPart(String part) {
        if (!Character.isDigit(part.charAt(0)) ||
                !Character.isDigit(part.charAt(part.length() - 1))) {
            return false;
        }

        NumberValidate nv = new IntegerValidate();
        return nv.validate(part);

    }
}

public class ValidNumberCheck {
    public boolean isNumber(String s) {
        NumberValidate nv = new NumberValidator();

        return nv.validate(s);
    }

    public static void main(String[] args) {
        ValidNumberCheck v = new ValidNumberCheck();
        v.isNumber("");
    }
}
