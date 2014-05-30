import java.util.*;
public class Solution {
    public int largestRectangleArea(int[] height) {
        return maxArea(height, 0, height.length);
    }
    private int maxArea(int[] height, int i, int j) {
        if(j==i) return 0;
        if(j-i==1) return height[i];
        int minIndex = i;
        int min = height[i];
        for(int k=i; k<j; k++) {
            if(height[k]<min) {
                min = height[k];
                minIndex = k;
            }
        }
        int maxLeft = maxArea(height, i, minIndex);
        int maxRight = maxArea(height, minIndex+1, j);
        return Math.max(min*(j-i), Math.max(maxLeft, maxRight));
    }
}
