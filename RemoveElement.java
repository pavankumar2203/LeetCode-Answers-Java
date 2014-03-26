public class Solution {
    public int removeElement(int[] A, int elem) {
        /*
            k=0
            for i=0..A.length-1:
                if A[i]!=v:
                    A[k++]=A[i]
            return k
            
            O(n) O(1)
        */
        
        int k = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != elem) {
                A[k++] = A[i];
            }
        }
        
        return k;
    }
}
