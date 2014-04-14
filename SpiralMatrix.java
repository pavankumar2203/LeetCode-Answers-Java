import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }
        return spiralOrder(matrix, 0, matrix.length, matrix[0].length);
    }
    /**
     * get list of integers in spiral order starting from left top point (i,i) with m rows and n cols
     */
    private static ArrayList<Integer> spiralOrder(int[][] matrix, int i, int m, int n) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        if(m == 0 || n == 0) return r;
        if(m == 1) {
            for(int j = 0; j < n; j++) {
                r.add(matrix[i][i + j]);
            }
            return r;
        }else if (n == 1) {
            for(int j = 0; j < m; j++) {
                r.add(matrix[i + j][i]);
            }
            return r;
        }else {
            //now both are bigger than 1
            for(int j = 0; j < n - 1; j++) {
                r.add(matrix[i][i + j]);
            }
            for(int j = 0; j < m - 1; j++) {
                r.add(matrix[i + j][i + n - 1]);
            }
            for(int j = 0; j < n - 1; j++) {
                r.add(matrix[i + m - 1][i + n - 1 - j]);
            }
            for(int j = 0; j < m - 1; j++) {
                r.add(matrix[i + m - 1 - j][i]);
            }
            ArrayList<Integer> r1 = spiralOrder(matrix, i + 1, m - 2, n - 2);
            r.addAll(r1);
            return r;
        }
    }
}
