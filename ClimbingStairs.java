/**
 * f1   1
 * f2   2
 * f3   3   f2+f1
 * f4   5   f3+f2
 * ...
 * fn   f(n-1)+f(n-2)
 * O(n) O(1)
 */

public class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        if(n == 2) return 2;
        int i = 3;
        int a = 1;
        int b = 2;
        while(i <= n) {
            int t = a;
            a = b;
            b = t + b;
            i++;
        }
        return b;
    }
}
