public class Solution {
    public boolean isPalindrome(int x) {
        /*
            if x<0:
                return false
            l=0
            y=x
            p=1
            while y>0:
                l++
                y/=10
                p*=10
            p/=10
            y=x
            while y>0:
                if y/p!=y%10:
                    return false
                y%=p
                y/=10
                p/=100
            return true
            
            O(n) O(1)
        */
        
        if(x < 0) {
            return false;
        }
        
        int p = 1;
        int y = x;
        y /= 10;
        
        while(y > 0) {
            y /= 10;
            p *= 10;
        }
        
        while(x > 0) {
            if(x / p != x % 10) {
                return false;
            }
            x %= p;
            x /= 10;
            p /= 100;
        }
        
        return true;
    }
}
