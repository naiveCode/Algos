package hackerearth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

class SubstringMatching {
    public static void main(String args[]) throws Exception {
//        File f = new File("/home/naiveCode/IdeaProjects/hackerTest/test/test.txt");
//        BufferedReader br = new BufferedReader(new FileReader(f));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int t = 0;
        while (t++ != T) {
            String[] data = br.readLine().split("\\s");
            String expr = data[0];
            String match = data[1];
//            System.out.println(expr + " " + match);
            boolean[] matchArray = new boolean[match.length()];

            if (expr.length() * 2 != match.length()) {
//                System.out.println("Length mismatch");
                System.out.println("Impossible");
                continue;
            }
            int foundAt = match.lastIndexOf(expr);
//            System.out.println("found at " + foundAt);
            if (foundAt == -1) {
                System.out.println("Impossible");
                continue;
            }
            StringBuilder remaining = new StringBuilder();
            if (foundAt == 0) {
                remaining.append(match.substring(expr.length()));
            } else {
                remaining.append(match.substring(0, foundAt)).append(match.substring(foundAt + expr.length()));
//                System.out.println("Remainin " + remaining.toString());
            }
            if (remaining.toString().contentEquals(expr)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }

//            if (countMatch == match.length) {
//                System.out.println("Possible");
//            } else {
//                System.out.println("Impossible");
//            }
        }
    }
}
