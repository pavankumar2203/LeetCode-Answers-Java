public class Solution {
    public boolean canJump(int[] A) {
        /*
            O(n) O(1)
        */
        return canJump2(A, A.length);
    }
    
    private static boolean canJump2(int[] A, int end) {
        if(end > A.length || end == 0) {
            return false;
        }
        else if(end == 1) {
            return true;
        }
        else {
            for(int i = end - 2; i >= 0; i--) {
                if(A[i] >= end - i - 1) {
                    return canJump2(A, i + 1);
                }
            }
        }
        return false;
    }
}
