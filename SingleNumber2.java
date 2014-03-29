public class Solution {
    public int singleNumber(int[] A) {
        /*
            int[32] a to store the # of times 1 appears at index i
            
            O(n) O(1)
        */
        
        int[] bitTimes = new int[32];
        
        for(int i = 0; i < A.length; i++) {
            int n = A[i];
            for(int j = 0; j < 32; j++) {
                bitTimes[j] += n & 1;
                n = n >> 1;
            }
        }
        int r = 0;
        for(int j = 31; j >= 0; j--) {
            r = r << 1;
            r += bitTimes[j] % 3;
        }
        
        return r;
    }
}
