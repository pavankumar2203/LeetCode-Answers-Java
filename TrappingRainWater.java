public class Solution {
    public int trap(int[] A) {
        /*
            O(n) O(1)
        */
        
        int water = 0;
        
        int highestIndex = 0;
        for(int i = 1; i < A.length; i++) {
            if(A[i] > A[highestIndex]) {
                highestIndex = i;
            }
        }
        
        int leftHighestIndex = 0;
        for(int i = 1; i < highestIndex; i++) {
            if(A[i] >= A[leftHighestIndex]) {
                leftHighestIndex = i;
            }
            else {
                water += A[leftHighestIndex] - A[i];
            }
        }
        
        int rightHighestIndex = A.length - 1;
        for(int i = A.length - 2; i > highestIndex; i--) {
            if(A[i] >= A[rightHighestIndex]) {
                rightHighestIndex = i;
            }
            else {
                water += A[rightHighestIndex] - A[i];
            }
        }
        
        return water;
    }
}
