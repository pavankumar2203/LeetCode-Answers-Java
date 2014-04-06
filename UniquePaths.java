public class Solution {
    public int uniquePaths(int m, int n) {
        /*
            dynamic programming O(mn)
            f(m,0)=1
            f(0,n)=1
            f(m,n)=f(m-1,n)+f(m,n-1)
            O(m*n) O(m*n)
        */
        int[][] table = new int[m][n];
        for(int i = 0; i < m; i++) {
            table[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            table[0][j] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }
        
        return table[m - 1][n - 1];
    }
}
