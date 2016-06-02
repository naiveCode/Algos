//max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.

import java.util.List;

public class MinmiseDiffFromThreeLists {
    // DO NOT MODIFY THE LISTS
    /*
    A better approach might be to:
> - Iterate over all elements of a,
> - Binary search for element just smaller than or equal to in b and c, and note the difference.
> - Repeat the process for b and c. O(n log n).
     */
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {

        int p = A.size(), q = B.size(), r = C.size();
        int diff = Integer.MAX_VALUE;  // Initialize min diff

        // Initialize result
        int res_i = 0, res_j = 0, res_k = 0;

        // Traverse arrays
        int i = 0, j = 0, k = 0;
        while (i < p && j < q && k < r) {
            // Find minimum and maximum of current three elements
            int minimum = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            int maximum = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));

            // Update result if current diff is less than the min
            // diff so far
            if (maximum - minimum < diff) {
//                res_i = i, res_j = j, res_k = k;
                diff = maximum - minimum;
            }

            // We can't get less than 0 as values are absolute
            if (diff == 0) break;

            // Increment index of array with smallest value
            if (A.get(i) == minimum) i++;
            else if (B.get(j) == minimum) j++;
            else k++;
        }
        return diff;
        // Print result
//        cout << A[res_i] << " " << B[res_j] << " " << C[res_k];
    }

}
