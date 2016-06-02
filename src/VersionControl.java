public class VersionControl {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        long curri = 0, currj = 0;
        while ((i < version1.length() && j < version2.length())) {
            while (i < version1.length() && version1.charAt(i) != '.') {
                curri = curri * 10 + (version1.charAt(i) - '0');
                i++;
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                currj = currj * 10 + (version2.charAt(j) - '0');
                j++;
            }
//            System.out.println(" " + curri + " " + currj);
            if (curri > currj) {
                return 1;
            } else if (curri == currj) {
                curri = 0;
                currj = 0;
                i++;
                j++;
                continue;
            } else {
                return -1;
            }
        }
//        System.out.println(" ->" + i + " " + j  + " L->" + version1.length() + " " + version2.length());
        if (i - 1 == version1.length() && j - 1 == version2.length()) {
            return 0;
        } else if (i - 1 == version1.length()) {

            while (j < version2.length()) {
                currj = 0;
                while (j < version2.length() && version2.charAt(j) != '.') {

                    currj = currj * 10 + (version2.charAt(j) - '0');
                    if (currj > 0) {
                        return -1;
                    }
                    j++;
                }
                j++;

            }
            return 0;
        } else {

            while ((i < version1.length())) {
                curri = 0;
//                System.out.println(version1.charAt(j));
                while (i < version1.length() && version1.charAt(i) != '.') {
                    curri = curri * 10 + (version1.charAt(i) - '0');

                    if (curri > 0) {
                        return 1;
                    }
                    i++;
                }
                i++;
            }
            return 0;
        }
    }
    public boolean isBadVersion(int v){
        return false;
    }

    public static void main(String[] args) {
        VersionControl a = new VersionControl();
        System.out.println(a.compareVersion("444444444444444444444444", "4444444444444444444444444"));
        System.out.println(a.compareVersion("01", "1"));
        System.out.println(a.compareVersion("1", "1.1"));
        System.out.println(a.compareVersion("1.0.1", "1"));
    }
}