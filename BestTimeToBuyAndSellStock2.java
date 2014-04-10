public class Solution {
    public int maxProfit(int[] prices) {
        int r = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i + 1] > prices[i]) {
                r += prices[i + 1] - prices[i];
            }
        }
        return r;
    }
}

//O(n) O(1)
