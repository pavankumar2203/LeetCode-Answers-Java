public class Solution {
    public int maxProfit(int[] prices) {
        /**
         * d & c
         * O(nlog(n))
         */
         if(prices == null || prices.length == 0 || prices.length == 1) return 0;
         int mid = prices.length / 2;
         int leftMaxP = maxProfit(Arrays.copyOfRange(prices, 0, mid));
         int rightMaxP = maxProfit(Arrays.copyOfRange(prices, mid, prices.length));
         int leftMinV = prices[0];
         for(int i = 1; i < mid; i++) {
             leftMinV = prices[i] < leftMinV ? prices[i] : leftMinV;
         }
         int rightMaxV = prices[mid];
         for(int i = mid + 1; i < prices.length; i++) {
             rightMaxV = prices[i] > rightMaxV ? prices[i] : rightMaxV;
         }
         return Math.max(Math.max(leftMaxP, rightMaxP), rightMaxV - leftMinV);
    }
}
