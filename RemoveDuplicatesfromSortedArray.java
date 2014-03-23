public class Solution {
    public int removeDuplicates(int[] A) {
        /*
            maintain two indices, one for insert, one for check
            
            O(n) O(1)
        */
        if(A.length == 0) {
            return 0;
        }
        
        int insertIndex = 0;
        for(int checkIndex = 1; checkIndex < A.length; checkIndex++) {
            if(A[checkIndex] != A[insertIndex]) {
                A[++insertIndex] = A[checkIndex];
            }
        }
        
        return insertIndex + 1;
    }
}
