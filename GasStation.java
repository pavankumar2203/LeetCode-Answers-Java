public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
            if cannot travel from i to j then impossible for all nodes in [i..j]
            
            O(n) O(1)
        */
        
        int totalGasLeft = 0;
        int start = 0;
        int tempSum = 0;
        for(int i = 0; i < gas.length; i++) {
            totalGasLeft += gas[i] - cost[i];
            tempSum += gas[i] - cost[i];
            if(tempSum < 0) {
                tempSum = 0;
                start = i + 1;
            }
        }
        
        return totalGasLeft < 0 ? -1 : start;
    }
}
