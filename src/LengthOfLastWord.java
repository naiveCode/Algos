public class LengthOfLastWord {
    public int lengthOfLastWord(final String a) {
        char[]d = a.toCharArray();
        int wordLength =0;
        boolean firstWord = false;
        for (int i=0;i<d.length;i++){
            if(d[i]!=' '){
                if(!firstWord){
                    firstWord = true;
                    wordLength = 0;
                }
                wordLength++;
            }else {
                firstWord = false;
            }
        }
        return wordLength;
    }

    public static void main(String[] args) {
        LengthOfLastWord a = new LengthOfLastWord();
        System.out.println(a.lengthOfLastWord("Hello my"));

    }
}
