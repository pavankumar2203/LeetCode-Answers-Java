//O(log(m*n)) O(1)

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rs = 0;
        int re = matrix.length;
        while(rs < re) {
            int mid = (rs + re) / 2;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] > target) re = mid;
            else rs = mid + 1;
        }
        int r = rs - 1;
        if(r < 0) return false;
        
        int cs = 0;
        int ce = matrix[r].length;
        while(cs < ce) {
            int mid = (cs + ce) / 2;
            if(matrix[r][mid] == target) return true;
            else if(matrix[r][mid] > target) ce = mid;
            else cs = mid + 1;
        }
        return false;
    }
}
