public class LexicographicalRankNonRepeatedCharcters {
    public int findRank(String a) {
        boolean[]charSet = new boolean[255];
        int characterCount = 0;
        for (char b: a.toCharArray()){
            charSet[b] = true;
            characterCount++;
        }
        int []factorialTable = new int[255];
        factorialTable[0] = 1;
        for (int i=1;i<255;i++){
            factorialTable[i] = (factorialTable[i-1]*(i+1))%1000003;
        }
        int totalCount = 1;
        for (char b : a.toCharArray()){
            int numBeforeThis = 0;
            for (int i=0;i<255;i++){
                if(i==b){
                    charSet[b] = false;
                    characterCount--;
                    break;
                }
                if(charSet[i]){
                    numBeforeThis++;
                }
            }
            if (numBeforeThis!=0) {
                totalCount = (totalCount + numBeforeThis*factorialTable[characterCount-1]) % 1000003;
            }
        }

        return totalCount;

    }



    public static void main(String[] args) {
        LexicographicalRankNonRepeatedCharcters s = new LexicographicalRankNonRepeatedCharcters();
        System.out.println(s.findRank("VIEW"));
    }
}
