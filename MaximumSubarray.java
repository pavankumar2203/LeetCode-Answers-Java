public class Solution {
    public int maxSubArray(int[] A) {
        /*
            brute force O(n^3)
            improved brute force O(n^2)
            divide and conquer O(nlog(n))
            scan and check if current sum is < 0 O(n)
        */
        if(A == null || A.length == 0) {
            throw new IllegalArgumentException("illegal arg");
        }
        int max = A[0];
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            if(sum > max) {
                max = sum;
            }
            if(sum <= 0) {
                sum = 0;
            }
        }
        
        return max;
    }
}
