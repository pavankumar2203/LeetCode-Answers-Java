/**
 * DP
 * O(m*n) O(m*n)
 */

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int[][] ir = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        if(obstacleGrid[0][0] == 1) return 0;
        ir[0][0] = 1;
        boolean noObstacleBefore = true;
        for(int i = 1; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] == 0 && noObstacleBefore) {
                ir[i][0] = 1;
            }
            else {
                ir[i][0] = 0;
                noObstacleBefore = false;
            }
        }
        noObstacleBefore = true;
        for(int i = 1; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i] == 0 && noObstacleBefore) {
                ir[0][i] = 1;
            }
            else {
                ir[0][i] = 0;
                noObstacleBefore = false;
            }
        }
        for(int i = 1; i < obstacleGrid.length; i++) {
            for(int j = 1; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 1) {
                    ir[i][j] = 0;
                }
                else if(ir[i - 1][j] == 0 && ir[i][j - 1] == 0) {
                    ir[i][j] = 0;
                }
                else if(ir[i - 1][j] == 0) {
                    ir[i][j] = ir[i][j - 1];
                }
                else if(ir[i][j - 1] == 0) {
                    ir[i][j] = ir[i - 1][j];
                }
                else {
                    ir[i][j] = ir[i][j - 1] + ir[i - 1][j];
                }
            }
        }
        
        return ir[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
