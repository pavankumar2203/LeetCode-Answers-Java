/**
 * f0 = 1
 * f1 = 1
 * f2 = 2
 * f3 = 5
 * f(n+1) = f0*f(n) + f1*f(n-1) + ... + f(n-1)*f1 + f(n)*f0
 * 
 * O(n^2) O(n)
 */

public class Solution {
    public int numTrees(int n) {
        long[] r = new long[n + 1];
        r[0] = 1;
        r[1] = 1;
        for(int i = 2; i <=n; i++) {
            long t = 0;
            for(int j = 0; j < i; j++) {
                t += r[j] * r[i - 1 - j];
            }
            r[i] = t;
        }
        
        return (int)(r[n]);
    }
}
