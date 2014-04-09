import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        /**
         * reuse row0 and col0 for a O(m*n) O(1) algo
         */
         if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
         boolean firstRowHasZero = false;
         for(int j = 0; j < matrix[0].length; j++) {
             if(matrix[0][j] == 0) {
                 firstRowHasZero = true;
                 break;
             }
         }
         boolean firstColHasZero = false;
         for(int i = 0; i < matrix.length; i++) {
             if(matrix[i][0] == 0) {
                 firstColHasZero = true;
                 break;
             }
         }
         for(int i = 1; i < matrix.length; i++) {
             for(int j = 1; j < matrix[0].length; j++) {
                 if(matrix[i][j] == 0) {
                     matrix[i][0] = 0;
                     matrix[0][j] = 0;
                 }
             }
         }
         for(int i = 1; i < matrix.length; i++) {
             if(matrix[i][0] == 0) {
                 for(int j = 1; j < matrix[0].length; j++) {
                     matrix[i][j] = 0;
                 }
             }
         }
         for(int j = 1; j < matrix[0].length; j++) {
             if(matrix[0][j] == 0) {
                 for(int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                 }
             }
         }
         if(firstRowHasZero) {
             for(int j = 0; j < matrix[0].length; j++) {
                 matrix[0][j] = 0;
             }
         }
         if(firstColHasZero) {
             for(int i = 0; i < matrix.length; i++) {
                 matrix[i][0] = 0;
             }
         }
    }
}
