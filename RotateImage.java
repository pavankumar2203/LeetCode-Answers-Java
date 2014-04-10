public class Solution {
    public void rotate(int[][] matrix) {
        /**
         * put matrix in x-y plane. center is O
         * fold along y = 0
         * fold along y = -x
         * O(n^2) O(1)
         */
         if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
         for(int i = 0; i < matrix.length / 2; i++) {
             for(int j = 0; j < matrix[i].length; j++) {
                 int t = matrix[i][j];
                 matrix[i][j] = matrix[matrix.length - 1 - i][j];
                 matrix[matrix.length - 1 - i][j] = t;
             }
         }
         for(int i = 1; i < matrix.length; i++) {
             for(int j = 0; j < i; j++) {
                 int t = matrix[i][j];
                 matrix[i][j] = matrix[j][i];
                 matrix[j][i] = t;
             }
         }
    }
}
