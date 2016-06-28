public class NonIntersectingChordsInACircle {
    public int chordCnt(int N) {
        if (N == 1) {
            return 1;
        }
        int h[] = new int[2*N];
        h[0] = 1;
        h[1] = 1;
//        h[2] = 2;
        for (int i=2;i<=N;i++){
            for (int j=0;j<i;j++) {
                h[i] = ((h[j]%1000000007) * (h[i-j-1]%1000000007) + h[i])%1000000007;
            }
        }
//        System.out.println(h[N-1]);
        return h[N]%1000000007;
    }



    public static void main(String[] args) {
        NonIntersectingChordsInACircle s = new NonIntersectingChordsInACircle();
        for (int i=1;i<10;i++)
            System.out.println(s.chordCnt(i));
    }
}
