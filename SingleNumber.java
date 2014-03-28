public class Solution {
    public int singleNumber(int[] A) {
        /*
            a^a==0
            a^b=b^a
            (a^b)^c = a^(b^c) <= only 8 cases
            
            O(n) O(1)
        */
        
        int r = A[0];
        for(int i = 1; i < A.length; i++) {
            r ^= A[i];
        }
        return r;
    }
}
