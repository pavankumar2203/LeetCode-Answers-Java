/**
 * DP
 * O(m*n) O(m*n)
 */

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        int[][] ir = new int[grid.length][grid[0].length];
        ir[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++) {
            ir[i][0] = grid[i][0] + ir[i - 1][0];
        }
        for(int i = 1; i < grid[0].length; i++) {
            ir[0][i] = grid[0][i] + ir[0][i - 1];
        }
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                ir[i][j] = grid[i][j] + Math.min(ir[i - 1][j], ir[i][j - 1]);
            }
        }
        return ir[grid.length - 1][grid[0].length - 1];
    }
}
