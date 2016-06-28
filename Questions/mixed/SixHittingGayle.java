/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class SixHittingGayle {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        for (int i = 0; i < T; i++) {
            String[] data = br.readLine().split("\\s");
            int N = Integer.parseInt(data[0]);
            int M = Integer.parseInt(data[1]);
            GtoP[] gtoPs = new GtoP[N];
            for (int j = 0; j < N; j++) {
                data = br.readLine().split("\\s");
                gtoPs[j] = new GtoP(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
            }
            Arrays.sort(gtoPs);
            int visited = 0;
            boolean gotOne = false;
            long powerHeHas = M;
            boolean itsAYes = true;
            while (visited != N) {
                for (int j = N - 1; j >= 0; j--) {
                    if (!gtoPs[j].visited) {
                        if (gtoPs[j].powerRequired <= powerHeHas) {
                            gtoPs[j].visited = true;
                            visited++;
                            gotOne = true;
                            powerHeHas += gtoPs[j].gain;
                        }
                    }
                }
                if(!gotOne){
                    itsAYes = false;
                    break;
                }
            }
            if(itsAYes)
            System.out.println("YES");
            else System.out.println("NO");

        }

    }

    static class GtoP implements Comparable<GtoP> {
        int gain, powerRequired;
        boolean visited;

        GtoP(int g, int p) {
            gain = g;
            powerRequired = p;
            visited = false;
        }

        @Override
        public int compareTo(GtoP o) {
            return this.gain - o.gain;
        }
    }
}
