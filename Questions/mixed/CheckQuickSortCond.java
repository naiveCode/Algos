/**
 * Created by naiveCode on 20/2/16.
 */
public class CheckQuickSortCond {

    public static void main(String[] args) {
        int[] arr = {
                5, 1, 4, 3, 6, 8, 10, 7, 9
        };
        int max[] = new int[arr.length];
        int min[] = new int[arr.length];
        max[0] = arr[0];
        min[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1, j = arr.length - 2; i < arr.length; i++, j--) {
            //find max array
            if (arr[i] > max[i - 1]) {
                max[i] = arr[i];
            } else {
                max[i] = max[i - 1];
            }
            //find min array
            if (arr[j] < min[j + 1]) {
                min[j] = arr[j];
            } else {
                min[j] = min[j + 1];
            }
        }
        int i;
        for (i = 1; i < arr.length-1; i++) {
            if (arr[i] > max[i-1] && arr[i] < min[i+1]) {
                System.out.println(arr[i]);
                break;
            }
        }
        if (i == arr.length) {
            System.out.println(-1);
        }

    }
}
