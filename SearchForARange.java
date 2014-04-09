//O(log(n)) O(1)

public class Solution {
    public int[] searchRange(int[] A, int target) {
        if(A == null || A.length == 0) return new int[]{-1, -1};
        int i = Arrays.binarySearch(A, target);
        if(i < 0) return new int[] {-1, -1};
        
        //find the first index of target
        int start = 0;
        int end = i;
        while(start < end) {
            int mid = (start + end) / 2;
            if(A[mid] == target) end = mid;
            else if(A[mid] < target) start = mid + 1;
        }
        int firstIndex = end;
        
        //find last index of target
        start = i;
        end = A.length - 1;
        while(start < end) {
            int mid = (start + end) / 2 + 1;
            if(A[mid] == target) start = mid;
            else if(A[mid] > target) end = mid - 1;
        }
        int lastIndex = start;
        
        return new int[]{firstIndex, lastIndex};
    }
}
