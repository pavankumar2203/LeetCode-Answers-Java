public class Solution {
    public int sqrt(int x) {
        if(x <= 0) return 0;
        if(x < 4) return 1;
        //bin search
        long a = 0;
        long b = x;
        while(b > a + 1) {
            long mid = (a + b) / 2;
            long sq = mid * mid;
            if(sq == x) return (int)mid;
            if(sq > x) b = mid;
            if(sq < x) a = mid;
        }
        return (int)a;
    }
}
