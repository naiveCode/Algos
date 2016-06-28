import java.util.ArrayList;

public class MultiplyVeryLargeNumber {
    int[] possibleLength = {1, 2, 3};

    public ArrayList<String> restoreIpAddresses(String a) {
        if (a.length() > 12 || a.length() < 4) {
            return new ArrayList<String>();
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            int lengthFirstByte = possibleLength[i];
            if (a.length() - lengthFirstByte <= 0) {
                continue;
            }
            String p = a.substring(0, lengthFirstByte);
            int firstByte = Integer.parseInt(p);
            if (p.charAt(0) == '0' && p.length() > 1) {
                continue;
            }

            if (firstByte >= 0 && firstByte < 256) {
                for (int j = 0; j <= 2; j++) {
                    int lengthSecondByte = possibleLength[j];
                    if (a.length() - (lengthFirstByte + lengthSecondByte) <= 0) {
                        continue;
                    }
                    String q = a.substring(lengthFirstByte,
                            lengthFirstByte + lengthSecondByte);
                    int secondByte = Integer.parseInt(q);
                    if (q.charAt(0) == '0' && q.length() > 1) {
                        continue;
                    }
                    if (secondByte >= 0 && secondByte < 256) {
                        for (int k = 0; k <= 2; k++) {
                            int lengthThirdByte = possibleLength[k];
                            if (a.length() - (lengthFirstByte + lengthSecondByte + lengthThirdByte) <= 0) {
                                continue;
                            }
                            String r = a.substring(lengthFirstByte + lengthSecondByte,
                                    lengthFirstByte + lengthSecondByte + lengthThirdByte);
                            int thirdByte = Integer.parseInt(r);
                            if (r.charAt(0) == '0' && r.length() > 1) {
                                continue;
                            }

                            if (thirdByte >= 0 && thirdByte < 256) {
                                String s = a.substring(lengthFirstByte + lengthSecondByte + lengthThirdByte, a.length());
                                if (s.length() > 3) {
                                    continue;
                                }
                                int fourthByte = Integer.parseInt(s);
                                if (s.charAt(0) == '0' && s.length() > 1) {
                                    continue;
                                }
                                if (fourthByte >= 0 && fourthByte < 256) {
                                    ans.add(p + "" + q + "" + r + "" + s);

                                }
                            } else {
                                continue;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                continue;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MultiplyVeryLargeNumber s = new MultiplyVeryLargeNumber();
        System.out.println(s.restoreIpAddresses("0000"));
    }
}
