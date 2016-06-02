/**
 * Created by naiveCode on 21/2/16.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        } else if (nums1.length == 0) {
            return nums2[nums2.length / 2];
        } else if (nums2.length == 0) {
            return nums1[nums1.length / 2];
        } else {
            int i = 0, j = 0, l;
            int index = 0;
            for (l = 0; i < nums1.length &
                    j < nums2.length &
                    l < (nums1.length + nums2.length) / 2; l++) {
                if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    i++;
                }
                l++;
            }
            if (l < (nums1.length + nums2.length) / 2) {

            }
        }
        return 0;
    }
}
