public class WeirdVersionControl {
    public int compareVersion(String a, String b) {
        String[] ver1 = a.split("\\.");
        String[] ver2 = b.split("\\.");
        int lim = Math.min(ver1.length, ver2.length);
        int i;
        for (i = 0; i < lim; i++) {
            String v1 = ver1[i];
            String v2 = ver2[i];
            int startingZerov1 = 0;
            int startingZerov2 = 0;
            for (int j = 0; j < v1.length(); j++) {
                if (v1.charAt(j) == '0') {
                    startingZerov1++;
                }else {
                    break;
                }
            }
            for (int j = 0; j < v2.length(); j++) {
                if (v2.charAt(j) == '0') {
                    startingZerov2++;
                }else {
                    break;
                }
            }
            if (v1.length() - startingZerov1 == v2.length() - startingZerov2) {
                int stringCompareResult = v1.substring(startingZerov1).compareTo(v2.substring(startingZerov2));
                if (stringCompareResult == 0) {
                    continue;
                } else if (stringCompareResult > 0) {
                    return 1;
                } else return -1;
            } else if (v1.length() - startingZerov1 > v2.length() - startingZerov2) {
                return 1;
            } else if (v1.length() - startingZerov1 < v2.length() - startingZerov2) {
                return -1;
            }
        }
        if(i==ver1.length && i==ver2.length){
            return 0;
        }else if(ver1.length==i){
            for (;i<ver2.length;i++){
                if(ver2[i].replace("0","").length()>0){
                    return -1;
                }
            }
        }else if(ver2.length==i){
            for (;i<ver1.length;i++){
                if(ver1[i].replace("0","").length()>0){
                    return 11;
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        WeirdVersionControl a = new WeirdVersionControl();
        System.out.println(a.compareVersion("4444371174137455", "5.168"));
        System.out.println(a.compareVersion("01", "1"));
        System.out.println(a.compareVersion("13.0", "13.0.8"));
    }
}
