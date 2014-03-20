import java.util.Stack;

public class Solution {
    public int reverse(int x) {
        
        /*
            consider int overflow
            O(n) time O(1) space algo (n is number of digits)
            save sign
            long retval
            while x>0:
                d=x%10
                retval+=d
                retval*=10
                x/=10
            retval/=10
            retval add sign
            if retval < Int.min:
                return Int.min
            if retval > Int.max:
                return Int.max
            return (int)retval;
        */
        boolean isPositive = x > 0;
        long retval = 0;
        
        if(!isPositive) {
            x = -x;
        }
        
        while(x > 0) {
            int d = x % 10;
            retval += d;
            retval *= 10;
            x /= 10;
        }
        retval /= 10;
        if(!isPositive) {
            retval *= -1;
        }
        
        if(retval < 0x80000000) {
            return 0x80000000;
        }
        else if(retval > 0x7fffffff) {
            return 0x7fffffff;
        }
        
        return (int)retval;
    }
}
