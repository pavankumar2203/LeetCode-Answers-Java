public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        
        int currentIndex = 1;
        int insertIndex = 1;
        int count = 1; //count how many times an element has appeared
        int lastVal = A[0];
        
        while(currentIndex < A.length) {
            if(A[currentIndex] == lastVal) {
                count++;
                if(count <= 2) {
                    A[insertIndex++] = lastVal;
                }
            }
            else {
                count = 1;
                A[insertIndex++] = A[currentIndex];
                lastVal = A[currentIndex];
            }
            currentIndex++;
        }
        return insertIndex;
    }
}//O(n) O(1)
