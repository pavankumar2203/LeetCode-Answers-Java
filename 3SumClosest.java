import java.util.*;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int closest = num[0]+num[1]+num[2];
        for(int i=0;i<num.length-2;i++){
            for(int j=i+1;j<num.length-1;j++){
                /*for(int k=j+1;k<num.length;k++){
                    int sum = num[i]+num[j]+num[k];
                    if(Math.abs(sum-target) < Math.abs(closest-target)){
                        closest = sum;
                    } else if(sum > target) {
                        break;
                    }
                }*/
                for(int k=num.length-1;k>j;k--){
                    int sum = num[i]+num[j]+num[k];
                    if(Math.abs(sum-target) < Math.abs(closest-target)){
                        closest = sum;
                    } else if(sum < target) {
                        break;
                    }
                }
            }
        }
        return closest;
    }
}
