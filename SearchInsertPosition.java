/**
 * O(log(n)) O(1)
 */

public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null) return -1;
        int start = 0;
        int end = A.length;
        while(start < end) {
            int mid = (start + end) / 2;
            if(A[mid] == target) {
                return mid;
            }
            else if(A[mid] > target) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
}
