public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] r = new int[n][n];
        int len = n;
        int i = 0;
        int v = 1;
        while(v <= n * n) {
            /**
             * start from (i,i)
             * move right len-1 times
             * move down len-1 times
             * move left len-1 times
             * move up len-1 times
             * if len>2:
             *      len-=2
             *      i++
             * 
             * O(n^2) O(1)
             */
             for(int j = 0; j < len - 1; j++) {
                 r[i][i + j] = v++;
             }
             for(int j = 0; j < len - 1; j++) {
                 r[i + j][i + len - 1] = v++;
             }
             for(int j = 0; j < len - 1; j++) {
                 r[i + len - 1][i + len - 1 - j] = v++;
             }
             for(int j = 0; j < len - 1; j++) {
                 r[i + len - 1 - j][i] = v++;
             }
             if(len > 2) {
                 len -= 2;
                 i++;
             }
             if(v == n * n) {
                 r[n / 2][n / 2] = v++;
             }
        }
        return r;
    }
}
