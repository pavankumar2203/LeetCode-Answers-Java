import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        /**
         * since this is a commonly used coding system
         * there must be an efficient way to encode and
         * decode and we can google it.
         * 
         * here is an O(2^n) O(2^n) algorithm
         * say for n-1 we get r, then for each e in r
         * append it to newR, the for each e from end to
         * front in r, append (1<<n-1)+e to r
         * return r
         * 
         * T(n) = 2T(n-1) => O(2^n)
         */
         
         ArrayList<Integer> r1 = new ArrayList<Integer>();
         if(n == 0) {
             r1.add(0);
             return r1;
         }
         if(n == 1) {
             r1.add(0);
             r1.add(1);
             return r1;
         }
         ArrayList<Integer> r2 = grayCode(n - 1);
         for(int e : r2) {
             r1.add(e);
         }
         int a = 1 << (n - 1);
         for(int i = r2.size() - 1; i >= 0; i--) {
             r1.add(a + r2.get(i));
         }
         return r1;
    }
}
