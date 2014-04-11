public class Solution {
    public int jump(int[] A) {
        /*
            clarificatiom:
            if cannot reach end return -1
            else return min jumps
            
            algorithm:
            say at point k we can jump once to end and before k no point can do it
            then we change the problem to a smaller problem jump(A[0..k])+1
            
            psudo code:
            scan A from index A.length-2 to the front:
                if for index i A[i] > A.length - 2 - i:
                    then we find the point k
                    return 1 + jump(A[0..k] include k) if it's not 0 else return -1
                if no such i exist:
                    return -1
        */
        if(A == null || A.length == 0) return -1;
        
        return jump2(A, 0, A.length);
    }
    
    public static int jump2(int[] A, int i, int j) {
        if(j <= i) return -1;
        if(j == i + 1) return 0;
        for(int k = i; k <= j - 2; k++) {
            if(A[k] >= j - k - 1) {
                int r = jump2(A, i, k + 1);
                if(r == -1) return -1;
                else return r + 1;
            }
        }
        return -1;
    }
}
