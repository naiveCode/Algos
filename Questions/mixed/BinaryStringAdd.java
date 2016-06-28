public class BinaryStringAdd {
    public String addBinary(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return a + b;
        }
        int aIndex = a.length()-1, bIndex = b.length()-1;
        StringBuilder ans = new StringBuilder();
        int remainder = 0;
        while (aIndex >=0 || bIndex >=0) {
            int aData = 0, bData = 0;
            if (aIndex >=0) {
                aData = a.charAt(aIndex) - '0';
                aIndex--;
            }
            if (bIndex >=0) {
                bData = b.charAt(bIndex) - '0';
                bIndex--;
            }

            int data = (aData + bData + remainder) % 2;
            remainder = (aData + bData + remainder) / 2;
            ans.append(data);

        }
        if(remainder!=0){
            ans.append(1);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        BinaryStringAdd s = new BinaryStringAdd();
        System.out.println(s.addBinary("1010","1011"));
    }
}