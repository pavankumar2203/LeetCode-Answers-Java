/**
 * O(log(dividend/divisor)) O(1)
 */


public class Solution {
    public int divide(int dividend, int divisor) {
        /*
            use + - << >>
            or use BigInteger's methods
        */
        long dd = dividend;
        long dr = divisor;
        boolean positive = true;
        if(dd > 0 && dr < 0) {
            dr = -dr;
            positive = false;
        }
        if(dd < 0 && dr > 0) {
            dd = -dd;
            positive = false;
        }
        if(dd < 0 && dr < 0) {
            dd = -dd;
            dr = -dr;
        }
        //if dr==0: ...
        if(dd < dr) return 0;
        long r = 0;
        long p = 1;
        while(dd > 0) {
            dd -= dr;
            r += p;
            dr <<= 1;
            p <<= 1;
        }
        p >>= 1;
        r -= p;
        dr >>= 1;
        dd += dr;
        while(p > 0) {
            if(dd - dr >= 0) {
                dd -= dr;
                r += p;
            }
            else {
                p >>= 1;
                dr >>= 1;
            }
        }
        if(!positive) r = -r;
        return (int)r;
    }
}
