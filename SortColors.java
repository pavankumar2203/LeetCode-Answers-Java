public class Solution {
    public void sortColors(int[] A) {
        /*
            O(n) O(1)
        */
        
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;
        for(int i = 0; i < A.length; i++) {
            switch(A[i]) {
                case 0: redCount++; break;
                case 1: whiteCount++; break;
                case 2: blueCount++; break;
            }
        }
        int k = 0;
        while(redCount-- > 0) {
            A[k++] = 0;
        }
        while(whiteCount-- > 0) {
            A[k++] = 1;
        }
        while(blueCount-- > 0) {
            A[k++] = 2;
        }
    }
}
