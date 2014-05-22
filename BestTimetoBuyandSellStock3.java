public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        if(prices.length == 2) return Math.max(0, prices[1] - prices[0]);
        int[] r = new int[prices.length];
        int cur = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i] != prices[i+1]) {
                r[cur++] = prices[i];
            }
        }
        //if(prices[prices.length-1] == prices[prices.length-2]) 
        r[cur++] = prices[prices.length-1];
        r = Arrays.copyOfRange(r, 0, cur);
        prices = r;
        r = new int[prices.length];
        cur = 0;
        r[cur++] = prices[0];
        for(int i = 1; i < prices.length - 1; i++) {
            if((prices[i] > prices[i-1] && prices[i] > prices[i+1]) || 
                (prices[i] < prices[i-1] && prices[i] < prices[i+1])) {
                r[cur++] = prices[i];
            }
        }
        r[cur++] = prices[prices.length - 1];
        r = Arrays.copyOfRange(r, 0, cur);
        prices = r;
        
        int max = 0;
        max = Math.max(maxDiff(prices), max);
        for(int i = 2; i < prices.length - 1; i++) {
            max = Math.max(maxDiff(Arrays.copyOfRange(prices, 0, i)) 
                + maxDiff(Arrays.copyOfRange(prices, i, prices.length)), max);
        }
        return max;
    }
    
    private int maxDiff(int[] arr) {
        if(arr.length<2) return 0;
        int max = 0;
        int minv = arr[0];
        for(int i = 1; i < arr.length; i++) {
            minv = Math.min(minv, arr[i]);
            max = Math.max(max, arr[i] - minv);
        }
        return max;
    }
}
